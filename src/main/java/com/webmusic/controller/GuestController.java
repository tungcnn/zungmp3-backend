package com.webmusic.controller;

import com.webmusic.model.Role;
import com.webmusic.model.User;
import com.webmusic.service.role.RoleService;
import com.webmusic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/api")
@CrossOrigin("*")
@RestController
public class GuestController {
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleService roleService;

    @PostMapping("/registration")
    public ResponseEntity<Void> registration(@RequestBody User user) {
        Optional<User> username = userService.findByUsername(user.getUsername());
        if (!username.isPresent()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = roleService.findById(2L).get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Optional<User> updateUser=userService.findById(user.getId());
        if(!updateUser.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        user.setPassword(updateUser.get().getPassword());
        Role role = roleService.findById(2L).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
//        user.setUsername(updateUser.get().getUsername());
        userService.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUser1(@PathVariable("id") Long id){
        Optional<User> deleteUser=userService.findById(id);
        if(deleteUser==null){
            System.out.println("Unable to delete, User with id"+id+"nod found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        Optional<User> deleteUser=userService.findById(user.getId());
        if(deleteUser==null){
            System.out.println("Unable to delete, User with not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.delete(user.getId());
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
