package de.srh.LMS.service;

import de.srh.LMS.entity.User;
import de.srh.LMS.exception.UserNotFoundException;
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
        user.setUsername(user.getEmail());
        userRepository.save(user);
    }

    public void deleteUser(Long userID){
        if(!userRepository.existsById(userID)) {
            throw new UserNotFoundException(
                    "User with id " + userID + " does not exist");
        }
        userRepository.deleteById(userID);
    }

    // TODO: Change UserProfile completely by ID PUT, GET User by id, email, PATCH-> Change ressources and fields
    public void resetUserProfile(Long userID, User user){
        if(!userRepository.existsById(userID)){
            throw new UserNotFoundException(
                    "User with id " + userID + " does not exist");
        }
        user.setId(userID);
        user.setUsername(user.getEmail());
        userRepository.save(user);
    }
}