package ua.taras.kushmyruk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.taras.kushmyruk.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
