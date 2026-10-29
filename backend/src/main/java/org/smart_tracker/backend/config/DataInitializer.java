package org.smart_tracker.backend.config;

import lombok.RequiredArgsConstructor;
import org.smart_tracker.backend.dto.Priority;
import org.smart_tracker.backend.model.Task;
import org.smart_tracker.backend.model.User;
import org.smart_tracker.backend.repo.TaskRepository;
import org.smart_tracker.backend.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository,
                                          TaskRepository taskRepository,
                                          PasswordEncoder passwordEncoder) {
        return args -> {
            // Проверяем, есть ли уже тестовый пользователь
            if (userRepository.findByUsername("test_user").isEmpty()) {
                // Создаем пользователя
                User user = new User();
                user.setUsername("test_user");
                user.setPassword(passwordEncoder.encode("password123"));
                userRepository.save(user);

                // Создаем задачи для этого пользователя
                Task task1 = new Task();
                task1.setTitle("Сделать фронтенд");
                task1.setDescription("Подключить API");
                task1.setPriority(Priority.HIGH);
                task1.setUser(user);
                taskRepository.save(task1);

                System.out.println("✅ Тестовый пользователь test_user (пароль: password123) успешно создан!");
            }
        };
    }
}