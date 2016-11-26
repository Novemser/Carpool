package repository;

import com.carpool.model.CommentEntity;
import com.carpool.repository.CommentEntityRepository;
import com.carpool.repository.UserEntityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by qi on 2016/11/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/dispatcher-servlet.xml"})
public class repositoryTest{


    @Resource
    private UserEntityRepository entityRepository;
    @Autowired
    private CommentEntityRepository repository;

    @Before
    public void setUp() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test()
    {
     Assert.assertEquals(1,entityRepository.findAll().size());
    }

    @Test
    public void test1()
    {
        Assert.assertTrue(repository.findAll().size()==0);
    }

}
