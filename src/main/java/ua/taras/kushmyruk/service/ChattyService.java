package ua.taras.kushmyruk.service;

import ua.taras.kushmyruk.model.Message;
import ua.taras.kushmyruk.model.User;

public interface ChattyService {

    Iterable<Message> getAllMessages();

    Iterable<String> findOnlineUsers();

    void addMessage(User user, String text);

}
