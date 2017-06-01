package io.hexagon.demo.test;

import io.hexagon.demo.DemoApplication;
import io.hexagon.demo.domain.model.Person;
import io.hexagon.demo.domain.model.User;
import io.hexagon.demo.domain.model.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Xuegui Yuan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserAggregateTest {
    @Autowired
    UserRepository userRepository;

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
    }
}
