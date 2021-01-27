package ua.taras.kushmyruk;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.taras.kushmyruk.Repository.MessageRepository;
import ua.taras.kushmyruk.Repository.UserRepository;
import ua.taras.kushmyruk.model.Message;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.ChattyService;
import ua.taras.kushmyruk.service.RegistrationService;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMessageTest {
    private User user;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChattyService chattyService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void initUser() {
        registrationService.registrate("username", "password");
        user = userRepository.findByUsername("username");
    }

    @Test
    public void testSendMessage() {
        chattyService.addMessage(user, "Hello");
        chattyService.addMessage(user, "I am here");
        chattyService.addMessage(user, "My name John");
        List<Message> messages = messageRepository.findAll();
        assertEquals(3, messages.size());
        assertEquals("username", messages.get(1).getAuthorName());
        assertEquals("My name John", messages.get(2).getText());
    }
}
