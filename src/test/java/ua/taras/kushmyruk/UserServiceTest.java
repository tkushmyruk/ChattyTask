package ua.taras.kushmyruk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import ua.taras.kushmyruk.model.Role;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.RegistrationService;
import ua.taras.kushmyruk.service.serviceImpl.UserServiceImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RegistrationService registrationService;

    @Test
    public void testFindUserByUsernameMethod(){
        registrationService.registrate("John", "password");
        User user = (User)userService.loadUserByUsername("John");
        assertEquals("John", user.getUsername());
        assertEquals(Role.USER, user.getRoles().toArray()[0]);
    }

}
