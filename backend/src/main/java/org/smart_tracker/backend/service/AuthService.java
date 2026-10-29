package org.smart_tracker.backend.service;

import lombok.RequiredArgsConstructor;
import org.smart_tracker.backend.dto.request.AuthRequest;
import org.smart_tracker.backend.dto.response.AuthResponse;
import org.smart_tracker.backend.model.User;
import org.smart_tracker.backend.repo.UserRepository;
import org.smart_tracker.backend.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRequest request) {
        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        //Проверяем пароль
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        //Достаем username
        String username = authentication.getName();

        //Генерируем токен
        String token = jwtService.generateToken(username);

        return new AuthResponse(token);
    }
}
