package com.yatskiv.test;

import com.yatskiv.test.entity.User;
import com.yatskiv.test.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void givenUserRepository_whenSaveAndRetrieveEntity_thenOk(){
        User user = userService
                .saveOrUpdate(new User("Nazar", 20, null), 1L);

        Optional<User> foundUser = userService
                .getById(user.getId());

        Assert.assertNotNull(foundUser.get());
        Assert.assertEquals(user.getName(), foundUser.get().getName());

    }
}
