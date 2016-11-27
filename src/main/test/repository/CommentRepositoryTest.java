package repository;

import com.carpool.model.CommentEntity;
import com.carpool.model.JourneyEntity;
import com.carpool.repository.CommentEntityRepository;
import com.carpool.repository.JourneyEntityRepository;
import com.carpool.repository.UserEntityRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by qi on 2016/11/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/dispatcher-servlet.xml"})
public class repositoryTest{


    @Resource
    private JourneyEntityRepository journeyEntityRepository;
    @Autowired
    private CommentEntityRepository repository;

    @Before
    public void setUp() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test()
    {
        List<JourneyEntity> journeyEntities = journeyEntityRepository.findByStartTimeBetween(new Date(),new Date());
        Assert.assertTrue(journeyEntities.size()==0);
    }

    @Test
    public void test1()
    {
    //    Assert.assertTrue(repository.countIdBySourceUserId("12")==0);
  /*      Sort sort = new Sort(Sort.Direction.DESC, "id");
        int page = 0; int size = 10;
        Pageable pageable = new PageRequest(page, size, sort);
       Page<CommentEntity> commentEntityPage =repository.findBySourceUserId("1",pageable);
       Assert.assertTrue(commentEntityPage.getTotalElements()==0);
    */
        repository.sumOfCreditByUserId("123");

    }

}
