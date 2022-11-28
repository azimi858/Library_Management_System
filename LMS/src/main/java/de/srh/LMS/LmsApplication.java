package de.srh.LMS;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(LmsApplication.class, args);
		System.out.println("Hello World!");
		isbn_classify classify = new isbn_classify();
		try{

			classify.sendGET("978-3-16-148410-0");

		}catch (IOException a){


		}


	}

}

