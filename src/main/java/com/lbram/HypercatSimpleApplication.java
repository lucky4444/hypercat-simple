package com.lbram;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HypercatSimpleApplication {

//    @Autowired
//    private IItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(HypercatSimpleApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return (args) ->
        {
//            itemService.deleteAll();
        };
    }
}
