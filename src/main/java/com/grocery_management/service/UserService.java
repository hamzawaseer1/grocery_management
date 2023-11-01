package com.grocery_management.service;

import com.grocery_management.enumiration.Role;
import com.grocery_management.model.User;
import com.grocery_management.repository.UserRepository;
import com.grocery_management.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.grocery_management.constants.Constant.*;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("inside the UserService for signup {}", requestMap);
        try {
            if (validateSignUp(requestMap)) {

                if (userRepository.existsUserByEmail(requestMap.get("email"))) {
                    return Utils.getResponseEntity(USER_EXISTS, BAD_REQUEST);
                } else {
                    userRepository.save(getUserFromMap(requestMap));
                    return Utils.getResponseEntity(USER_SAVED_SUCCESSFULLY, OK);
                }
            } else {
                return Utils.getResponseEntity(INVALID_DATA, BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Utils.getResponseEntity(SOMETHING_WENT_WRONG, INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateSignUp(Map<String, String> requestMap) {
        return (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password"));
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus(requestMap.get("status"));
        user.setRole(Role.ROLE_USER);
        return user;
    }
}
