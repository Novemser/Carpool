package repository;

import com.carpool.website.dao.CommentEntityRepository;
import com.carpool.website.dao.JourneyEntityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qi on 2016/11/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/dispatcher-servlet.xml"})
public class RepositoryTest {

    @Autowired
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
//        List<JourneyEntity> journeyEntities = journeyEntityRepository.findByStartTimeBetween(new Date(),new Date());
//        Assert.assertTrue(journeyEntities.size()==0);
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
//        repository.sumOfCreditByUserId("123");

    }

}
