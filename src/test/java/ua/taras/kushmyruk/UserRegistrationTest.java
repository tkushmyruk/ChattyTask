package ua.taras.kushmyruk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.taras.kushmyruk.Repository.UserRepository;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.RegistrationService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistrationTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    RegistrationService registrationService;

    @Test
    public void testRegistration() {
        registrationService.registrate("username", "password");
        User user = repository.findByUsername("username");
        assertEquals("username", user.getUsername());
        assertEquals(true, user.isEnabled());
    }
}
