import com.sinosoft.one.demo.model.account.User;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-10-12
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class Simple {

    @PersistenceContext
    EntityManager em;



    @Test
    public void sql(){
        Session session = em.unwrap(Session.class);

        String sql = "select * from acct_user";
        List<User> l= session.createSQLQuery(sql).addEntity(User.class).list();
        Assert.assertNotNull(l);
    }

}
