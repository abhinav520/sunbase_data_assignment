package com.abhinav.sunbase.controller;

import com.abhinav.sunbase.Dto.LoginDto;
import com.abhinav.sunbase.Dto.SignUpDto;
import com.abhinav.sunbase.model.User;
import com.abhinav.sunbase.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/sunbase/portal/api/assignment.jsp")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User login successfully!...", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto newUser){
        // creating user object
        User user = new User();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
        return new ResponseEntity<>("User is registered successfully!", HttpStatus.OK);
    }


}
