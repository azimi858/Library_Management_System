package de.srh.LMS.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import de.srh.LMS.entity.User;
import de.srh.LMS.exception.UserNotFoundException;
import de.srh.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public void changeUserProfile(Long userID, User changeUser) {
        if(!userRepository.existsById(userID)){
            throw new UserNotFoundException(
                    "User with id " + userID + " does not exist");
        }
        User newChangedUser = userRepository.findUserByID(userID).get();
        changeUser.setId(userID);
        if (changeUser.getEmail() != null){
            System.out.println(String.format("email: %s", changeUser.getEmail() ));
            newChangedUser.setEmail(changeUser.getEmail());
            newChangedUser.setUsername(changeUser.getEmail());
        }
        if (changeUser.getSurname() != null){
            System.out.println(String.format("surname: %s", changeUser.getSurname() ));
            newChangedUser.setSurname(changeUser.getSurname());
        }
        if (changeUser.getFirstname() != null){
            System.out.println(String.format("firstname: %s", changeUser.getFirstname() ));
            newChangedUser.setFirstname(changeUser.getFirstname());
        }
        if (changeUser.getPassword() != null){
            System.out.println(String.format("password: %s", changeUser.getPassword() ));
            newChangedUser.setPassword(changeUser.getPassword());
        }
        userRepository.save(newChangedUser);
    }
}