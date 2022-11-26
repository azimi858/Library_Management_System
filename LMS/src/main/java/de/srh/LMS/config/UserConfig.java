package de.srh.LMS.config;

import de.srh.LMS.entity.User;
import de.srh.LMS.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
// Init Database Configuration with data
@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User andreas = new User(
                    "Lakus",
                    "Andreas",
                        "Andreas.Lakus@stud.hochschule-heidelberg.de",
                        11012049,
                        LocalDate.of(1986,04,01)
            );

            User yogi = new User(
                    "Parihar",
                    "Yogesh",
                    "Yogesh.Parihar@stud.hochschule-heidelberg.de",
                    11027728,
                    LocalDate.of(1992,11,04)
            );
            userRepository.saveAll(List.of(andreas, yogi));
        };
    }
}
