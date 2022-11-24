package de.srh.LMS.entityTests;

import de.srh.LMS.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.format.FormatStyle;

@SpringBootTest
public class StudentTests {
    @Test
    void testStudentAgeCalc(){
        Student stud = new Student("Lakus", "Andreas",
                "Andreas.Lakus@stud.hochschule-heidelberg.de",
                11012049, LocalDate.of(1986,04,01));
        System.out.println(stud.getAge());
    }
}
