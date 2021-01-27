package ua.taras.kushmyruk.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.ChattyService;

@Controller
public class ChattyController {
    private final ChattyService chattyService;

    public ChattyController(ChattyService chattyService) {
        this.chattyService = chattyService;
    }

    @GetMapping("/chatty")
    public String getChattyPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("onlineUsers", chattyService.findOnlineUsers());
        model.addAttribute("messages", chattyService.getAllMessages());
        return "chatty";
    }

    @PostMapping("/chatty")
    public String addMessage(@AuthenticationPrincipal User user, @RequestParam String text, Model model) {
        chattyService.addMessage(user, text);
        model.addAttribute("onlineUsers", chattyService.findOnlineUsers());
        model.addAttribute("messages", chattyService.getAllMessages());
        return "chatty";
    }
}
