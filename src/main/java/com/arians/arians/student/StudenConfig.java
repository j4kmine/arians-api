package com.arians.arians.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
//indicates that a class declares one or more @Bean methods and may be processed
// by the Spring container to generate bean definitions and service requests for
// those beans at runtime
public class StudenConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return  args -> {
            Student mariam = new Student(
                    1L,"mariam","mariam@mail.com", LocalDate.now()
            );
            Student alex = new Student(
                    2L,"alex","alex@mail.com", LocalDate.now()
            );
            studentRepository.saveAll(List.of(mariam,alex));
        };
    }
}
