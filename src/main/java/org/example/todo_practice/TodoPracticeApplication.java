package org.example.todo_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.TimeZone;

@SpringBootApplication
public class TodoPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoPracticeApplication.class, args);
    }

}
