package de.srh.LMS.entityTests;

import de.srh.LMS.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UserTests {
    @Test
    void testUserAgeCalc(){
        User usr = new User("Lakus", "Andreas",
                "Andreas.Lakus@stud.hochschule-heidelberg.de",
                "123456");
    }
}
