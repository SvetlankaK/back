package com.svetakvetko.config;

import com.svetakvetko.domain.User;
import com.svetakvetko.mapper.RoleMapper;
import com.svetakvetko.mapper.UserMapper;
import com.svetakvetko.payload.JwtResponse;
import com.svetakvetko.payload.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
///todo не понимаю какой путь тут должен быть
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    //todo и тут
// ещё не понимаю, что именно мне надо хранить в токене(ну в плане роль, логин, а в остальном не уверена. и не совсем уверена, где это определяется, поэтому я нигде и не меняла то
// , что есть
    @PostMapping("/signin")

    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }


}