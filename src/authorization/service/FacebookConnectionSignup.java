package com.higgsup.authorization.service;

import com.facebook.ads.sdk.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * Created on 15-Sep-17.
 * OwnerBy anhvu
 */
public class FacebookConnectionSignup implements ConnectionSignUp {

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
//        User user = new User();
//        user.setUsername(connection.getDisplayName());
//        user.setPassword(randomAlphabetic(8));
//        userRepository.save(user);
//        return user.getUsername();
        return null;
    }
}
