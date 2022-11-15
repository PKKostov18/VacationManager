package com.pkkostov18.vacationmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VacationManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(VacationManagerApplication.class, args);
    }
/*
    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting Player 2: {}", userRepository.save(new User("Pacata69", "plamen123",
                "Plamen", "Kostov", "siuu")));

    }
    */

}
