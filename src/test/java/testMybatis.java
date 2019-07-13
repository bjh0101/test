import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.security.auth.Subject;
import java.io.InputStream;
import java.util.List;

public class testMybatis {


    @Test
    public void jedis(){
        Jedis jedis = new Jedis();
        jedis.set("1","1");
        jedis.close();
    }
}
