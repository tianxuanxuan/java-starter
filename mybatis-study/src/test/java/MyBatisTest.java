import com.xgit.starter.MyBatisStudyApplication;
import com.xgit.starter.dao.RoleDao;
import com.xgit.starter.entities.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-01 15:26
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisStudyApplication.class)
@Slf4j
public class MyBatisTest {
    @Autowired
    private RoleDao roleDao;


    /**
     *
     * 开启事务，测试一级缓存效果
     * 缓存命中顺序：二级缓存 --> 一级缓存 --> 数据库
     *
     */
    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void testMybatisLevel1Cache(){
        log.info("一级缓存查询");
        // 第一次查询，缓存到一级缓存
        List<Role> result1 = roleDao.findRolesByName("总经理","");
        log.info("一级缓存查询结果" + result1);
        // 第二次查询，直接读取一级缓存
        log.info("二级缓存查询");
        List<Role> result2 = roleDao.findRolesByName("总经理","");
        log.info("二级缓存查询结果" + result2);
    }

    /**
     * 测试二级缓存效果
     * 需要*Mapper.xml开启二级缓存
     **/
    @Test
    public void testLevel2Cache(){
        log.info("二级缓存查询1");
        List<Role> result1 = roleDao.findRolesByName("总经理","");
        log.info("二级缓存查询结果1" + result1);

        log.info("二级缓存查询2");
        List<Role> result2 = roleDao.findRolesByName("总经理","");
        log.info("二级缓存查询结果2" + result2);
    }
}
