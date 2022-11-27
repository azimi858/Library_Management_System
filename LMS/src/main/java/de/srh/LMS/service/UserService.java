package de.srh.LMS.service;

import de.srh.LMS.entity.User;
import de.srh.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Business Logic for Users
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EMailValidationService eMailValidationService;

    @Autowired
    public UserService(UserRepository userRepository, EMailValidationService eMailValidationService) {
        this.userRepository = userRepository;
        this.eMailValidationService = eMailValidationService;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) throws  IllegalStateException{

        if (eMailValidationService.eMailExists(user)){
            throw new IllegalStateException("email already taken");
        }
        if(!eMailValidationService.validateEMail(user)){
            throw new IllegalStateException("false email format");
        }
        userRepository.save(user);
    }
}