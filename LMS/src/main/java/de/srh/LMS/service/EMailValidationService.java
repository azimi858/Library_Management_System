package de.srh.LMS.service;

import de.srh.LMS.entity.User;
import de.srh.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class EMailValidationService {
    private final UserRepository userRepository;

    @Autowired
    public EMailValidationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean eMailExists(User user){
        Optional<User> userOptional = userRepository
                .findUserByEMail(user.getEmail());
        return userOptional.isPresent();
    }
    public static boolean patternMatcher(String eMail, String pattern){
        return Pattern.compile(pattern)
                .matcher(eMail)
                .matches();
    }
    public boolean validateEMail(User user){
        String eMailAddress = user.getEmail();
        String regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return EMailValidationService.patternMatcher(eMailAddress, regexPattern);
    }

}
