package connectionTests;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ConnectionTests {

    @Test
    public void ConnectionTests() throws Exception{

        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser");

        Assertions.assertNotNull(connection);

        connection.close();

    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void ConnectionTests2(){

        try{
            Connection con = dataSource.getConnection();
            log.info(con);
        }catch (Exception e){

        }
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void ConnectionTest3(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            log.info(sqlSession);
            log.info(connection);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
