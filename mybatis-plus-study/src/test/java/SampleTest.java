import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xgit.starter.MybatisPlusMain8082;
import com.xgit.starter.entities.Role;
import com.xgit.starter.mapper.RoleMapper;
import com.xgit.starter.service.RoleService;
import com.xgit.starter.service.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-12 17:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusMain8082.class)
public class SampleTest {

    @Autowired
    private RoleMapper userMapper;

    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Role> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Test
    public void testSelectService(){
        System.out.println(("----- selectAll method test ------"));
        //Role user = roleService.getOne(Wrappers.<Role>lambdaQuery().eq(Role::getId,"Alice"),false);
        //System.out.println(user);
        List<Role> userList = roleService.list();
        System.out.println(userList);
    }
}
