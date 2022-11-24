package de.srh.LMS.config;

import de.srh.LMS.entity.Student;
import de.srh.LMS.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student andreas = new Student(
                    "Lakus",
                    "Andreas",
                        "Andreas.Lakus@stud.hochschule-heidelberg.de",
                        11012049,
                        LocalDate.of(1986,04,01)
            );

            Student yogi = new Student(
                    "Parihar",
                    "Yogesh",
                    "Yogesh.Parihar@stud.hochschule-heidelberg.de",
                    11027728,
                    LocalDate.of(1992,11,04)
            );
            studentRepository.saveAll(List.of(andreas, yogi));
        };
    }
}
