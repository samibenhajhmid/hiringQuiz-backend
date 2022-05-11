package com.smoothalgo.hiringQuiz;

import com.smoothalgo.hiringQuiz.entities.User;
import com.smoothalgo.hiringQuiz.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



import static com.smoothalgo.hiringQuiz.enumerations.Role.ADMIN;
import static com.smoothalgo.hiringQuiz.enumerations.Role.CANDIDATE;

@SpringBootApplication
@RestController
public class QuizServiceApplication implements CommandLineRunner {
    @Autowired
    IUserService iUserService;

    public static void main(String[] args) {
        SpringApplication.run(QuizServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //User user = new User("sami","belhadj","sami@enis.tn","pass1", ADMIN);
        //User user1 =  new  User("ali","belhadj","ali@enis.tn","pass2",CANDIDATE);
        //iUserService.addUser(user);
        //iUserService.addUser(user1);
    }

}
