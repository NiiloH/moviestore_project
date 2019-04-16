package com.example.palvelinprojekti;


import com.example.palvelinprojekti.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class PalvelinprojektiApplication {



    //MOVIE STORE MAIN CLASS


    public static void main(String[] args) {
        SpringApplication.run(PalvelinprojektiApplication.class, args);
    }

    @Primary
    @Bean
    public CommandLineRunner items(ItemRepository repository, CategoryRepository drepository, UserRepository userRepository) {
        return (args) -> {

            //pull-out repository for category

            drepository.save(new Category("Thriller"));
            drepository.save(new Category("Horror"));
            drepository.save(new Category("Drama"));
            drepository.save(new Category("Action"));
            drepository.save(new Category("Document"));
            drepository.save(new Category("War"));
            drepository.save(new Category("Comedy"));
            drepository.save(new Category("Scifi"));



            // CREATING 4 MOVIES TO THE LIST

            repository.save(new Item("Travel program Turku", "Pasi Heino", "1", 2010, 20.56, "Online", drepository.findByName("Document").get(0)));
            repository.save(new Item("Blade Runner", "Ridley Scott", "2", 1982, 20, "VHS", drepository.findByName("Scifi").get(0)));
            repository.save(new Item("Tuntematon Sotilas", "Aku Louhimies", "3", 2016, 25, "Online", drepository.findByName("War").get(0)));
            repository.save(new Item("Trainspotting", "John Hodge", "4", 2016, 10, "VHS", drepository.findByName("Drama").get(0)));


            /*luo käyttäjän/salasanan

            admin/admin,

            user/user */

            User user1 =new User("user",
                    "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");

            User user2 =new User("admin",
                    "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");

            userRepository.save(user1);
            userRepository.save(user2);

        };
    }
}

