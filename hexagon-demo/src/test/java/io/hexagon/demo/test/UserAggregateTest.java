package io.hexagon.demo.test;

import io.ebean.EbeanServer;
import io.hexagon.demo.DemoApplication;
import io.hexagon.demo.domain.model.Person;
import io.hexagon.demo.domain.model.User;
import io.hexagon.demo.domain.model.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Xuegui Yuan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserAggregateTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    @Qualifier("secondEbeanServer")
    EbeanServer secondEbeanServer;

    @Test
    public void testChangePersonName() {
        User user  = new User("yuanxuegui", "123456");
        Person person = new Person();
        person.setName("test");
        user.setPerson(person);
        userRepository.save(user);

        User userInDb = userRepository.findOne(user.getId());
        Assert.assertEquals("yuanxuegui", userInDb.getUsername());
        Assert.assertEquals("test", userInDb.getPerson().getName());

        userInDb.changePersonName("Xuegui Yuan");
        userRepository.save(userInDb);
        User userInDb2 = userRepository.findOne(user.getId());
        Assert.assertEquals("Xuegui Yuan", userInDb2.getPerson().getName());

        userRepository.db(secondEbeanServer);
        User userInSecondDb = userRepository.findOne(userInDb2.getId());

        for (int i = 0; i < 10; i++) {
            User u  = new User("yuanxuegui", "123456");
            Person p = new Person();
            p.setName("test");
            u.setPerson(p);
            userRepository.save(u);
        }

        Page<User> page = userRepository.findAll(new PageRequest(1, 10));
        Assert.assertEquals(10, page.getSize());

        System.out.println("select username");
        User userWithUsername = userRepository.findOne(1L, "username");
        System.out.println(userWithUsername.getUsername());
    }
}
