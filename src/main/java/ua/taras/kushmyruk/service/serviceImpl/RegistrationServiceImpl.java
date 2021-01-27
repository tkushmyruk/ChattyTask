package ua.taras.kushmyruk.service.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.Repository.UserRepository;
import ua.taras.kushmyruk.model.Role;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.RegistrationService;

import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registrate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(Collections.singleton(Role.USER));
            user.setEnabled(true);
            userRepository.save(user);
        }

    }
}
