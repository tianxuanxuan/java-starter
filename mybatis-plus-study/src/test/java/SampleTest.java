import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xgit.starter.MybatisPlusMain8082;
import com.xgit.starter.entities.Role;
import com.xgit.starter.entities.User;
import com.xgit.starter.mapper.RoleMapper;
import com.xgit.starter.mapper.UserMapper;
import com.xgit.starter.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianxuanxuan
 * On 2020-09-12 17:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusMain8082.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

//    @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<Role> userList = userMapper.selectList(null);
//        System.out.println(userList);
//    }

    @Test
    public void testSelectService(){
        System.out.println(("----- selectAll method test ------"));
        Role user = roleService.getOne(Wrappers.<Role>lambdaQuery().eq(Role::getId,"Alice"),false);
        System.out.println(user);
        List<Role> userList = roleService.list();
        System.out.println(userList);
    }

    @Test
    public void testInsert(){
        Role role = new Role();
        role.setRoleName("测试");
        role.setNote("测试");
        role.setRemarkInfo("备注信息");
        roleService.save(role);
    }

    @Test
    public void testQuery(){
        List<Long> ids = Arrays.asList(1L, 2L);
        List<User> roles = userMapper.selectBatchIds(ids);
        roles.forEach(System.out::println);
    }

    @Test
    public void testQueryByMap(){
        //where role_name = "测试" and note = "测试"，map中key的值是数据库字段值
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("name", "王天风");
        queryMap.put("age", 25);
        List<User> roles = userMapper.selectByMap(queryMap);
        roles.forEach(System.out::println);
    }

    /**
     * 年龄小于40，名字包含“雨”
     */
    @Test
    public void testSelectWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").lt("age", 40);
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 年龄大于20小于40，名字包含“雨”，email不为空
     */
    @Test
    public void testSelectWrapper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨")
                .between("age",20,40)
                .isNotNull("email");
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 名字为王姓，或者年龄大于等于25，年龄降序排列，年龄相同按照id升序排列
     * like "王%" or age >= 25 order by age desc, id asc
     */
    @Test
    public void testSelectWrapper3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .or()
                .ge("age",25)
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 创建日期为2020年10月20日并且直属上级名字为王姓
     * date_format(dateColumn,'%Y-%m-%d') = "2020-10-20" and manager_id in (select id from user where name like "王%")
     */
    @Test
    public void testSelectWrapper4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = 2020-10-19 or true" ) sql注入
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}", "2020-10-19")
                .inSql("manager_id", "select id from user where name like '王%'");
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 名字为王姓并且(年两小于40或邮箱不为空)
     * like "王%" and (age < 40 or email is not null)
     */
    @Test
    public void testSelectWrapper5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .and(qw->qw.lt("age",40).or().isNotNull("email"));
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 名字为王姓或者（年龄大于20且小于40且邮箱不为空)
     * like "王%" or (age < 40 or age > 20 and email is not null)
     */
    @Test
    public void testSelectWrapper6(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .or(qw -> qw.lt("age", 40).gt("age", 20).isNotNull("email"));
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * (年龄小于40或者邮箱不为空)并且名字为王姓
     * (age < 40 or email is not null) and name like "王%"
     */
    @Test
    public void testSelectWrapper7(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.nested(qw -> qw.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "王");
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 年龄为30,31,34,35
     * (age < 40 or email is not null) and name like "王%"
     */
    @Test
    public void testSelectWrapper8(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.in("age", Arrays.asList(31,32,34,35));
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 返回满足条件的一条语句
     * (age < 40 or email is not null) and name like "王%"
     */
    @Test
    public void testSelectWrapper9(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.in("age", Arrays.asList(31,32,34,35)).last("limit 1");
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 年龄小于40，名字包含“雨”,只返回name，age
     */
    @Test
    public void testSelectWrapperSuper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("name","age").like("name", "雨").lt("age", 40);
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * 年龄小于40，名字包含“雨”,去除某些字段
     */
    @Test
    public void testSelectWrapperSuper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select(User.class, user -> !user.getColumn().equals("create_time")
            && !user.getColumn().equals("manager_id"))
                .like("name", "雨").lt("age", 40);
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    @Test
    public void testCondition(){
        String name = "王";
        String email = "";
        condition(name,email);
    }
    private void condition(String name, String email){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like(!StringUtils.isEmpty(name), "name", name)
                .like(!StringUtils.isEmpty(email), "email", email);
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }

    /**
     * entity作为where条件
     */
    @Test
    public void testSelectWrapperEntity(){
        User user = new User();
        user.setName("刘红雨");
        user.setAge(32);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(user);
        queryWrapper.like("name", "雨").lt("age", 40);//和entity设置的条件互不干扰，都会出现在where
        List<User> roles = userMapper.selectList(queryWrapper);
        roles.forEach(System.out::println);
    }
}
