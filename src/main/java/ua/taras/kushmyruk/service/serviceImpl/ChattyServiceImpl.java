package ua.taras.kushmyruk.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.Repository.MessageRepository;
import ua.taras.kushmyruk.Repository.UserRepository;
import ua.taras.kushmyruk.model.Message;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.ChattyService;

@Service
public class ChattyServiceImpl implements ChattyService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public ChattyServiceImpl(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Iterable<String> findOnlineUsers() {
        return userRepository.findOnlineUser();
    }

    @Override
    public void addMessage(User user, String text) {
        Message message = new Message(text, user);
        messageRepository.save(message);
    }
}
