package com.capstoneproject.fooddeliveryapp.userInfo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstoneproject.fooddeliveryapp.userInfo.config.JwtUtil;
import com.capstoneproject.fooddeliveryapp.userInfo.dto.UserDTO;
import com.capstoneproject.fooddeliveryapp.userInfo.mapper.UserMapper;
import com.capstoneproject.fooddeliveryapp.userInfo.model.User;
import com.capstoneproject.fooddeliveryapp.userInfo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional
    public UserDTO addUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.mapUserDTOToUser(userDTO);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword())); // Encrypt password
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
        Optional<User> fetchedUser = userRepository.findById(userId);
        if (fetchedUser.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    public ResponseEntity<String> authenticate(UserDTO userDTO) {
        User user = loadUserByUsername(userDTO.getUserName());
        if (passwordEncoder.matches(userDTO.getUserPassword(), user.getUserPassword())) {
            String token = jwtUtil.generateToken(user);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(UserMapper.INSTANCE::mapUserToUserDTO)
                    .collect(Collectors.toList());
    }
}
