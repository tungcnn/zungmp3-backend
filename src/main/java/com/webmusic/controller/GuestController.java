package com.webmusic.controller;

import com.webmusic.model.*;
import com.webmusic.service.role.RoleService;
import com.webmusic.service.user.UserService;
import com.webmusic.service.user.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    VerificationTokenService verificationTokenService;

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
        if(!updateUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Role role = roleService.findById(2L).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
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
    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<?> updatePassword(@RequestBody PasswordForm passwordForm, @PathVariable Long id){
        Optional<User> user=userService.findById(id);

        if(!user.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(passwordForm.getUsername(), passwordForm.getCurrentPassword()));
            if (authentication.isAuthenticated()) {
                user.get().setPassword(passwordEncoder.encode(passwordForm.getNewPassword()));
                userService.save(user.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            throw new RuntimeException("Fail Authentication");
        }catch(Exception e){
            throw new RuntimeException("Error =>"+e);
        }
    }
//
//    @PostMapping("/forgot-password")
//    public ResponseEntity<?> forgotPassword(@RequestBody PasswordForgotForm passwordForgotForm){
//        User user=userService.findByEmail(passwordForgotForm.getEmail());
//        if(user==null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        VerificationToken token=new VerificationToken(user);
//        token.setExpiryDate(10);
////        verificatonTokenService.save(token);
////        emailService.sendEmail(
//                passwordForgotForm.getEmail(),
//                "Reset Password",
//                "You are in process of resetting password." +
//                        "Click below Url to set new password :" +
//                        "http://localhost:4200/recover-password" + "?token=" + token.getToken());
//        return new ResponseEntity<>(passwordForgotForm, HttpStatus.OK);
//    }
//    @RequestMapping(value = "user/new-password", method = {RequestMethod.GET, RequestMethod.POST})
//    public ResponseEntity<User> updatePassword(@RequestParam("token") String token, @RequestBody User user) {
//        VerificationToken verificationToken = verificationTokenService.findByToken(token);
//        boolean isExpired = verificationToken.isExpired();
//        if (token == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        if (isExpired) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        User currentUser = userService.findByEmail(verificationToken.getUser().getEmail());
//        if (currentUser == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        String newPassword = passwordEncoder.encode(user.getPassword());
//        currentUser.setPassword(newPassword);
//        userService.save(currentUser);
//        return new ResponseEntity<>(currentUser, HttpStatus.OK);
//}
}
