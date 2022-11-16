package com.sillysally.mongodbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbTestApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;
    public static void main(String[] args)
    {
        SpringApplication.run(MongoDbTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        //Spara några kunder
        repository.save(new Customer("Sally", "Resch"));
        repository.save(new Customer("Oskar", "Martens"));
        repository.save(new Customer("Nasir", "Tedros"));

        //Hämta alla kunder
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()){
            System.out.println(customer);
        }

        //Hämta en enskilld kund
        System.out.println("Customer found with findByFirstName('Sally'):");
        System.out.println("---------------------------------------------");
        System.out.println(repository.findByFirstName("Sally"));

        System.out.println("Customers found with findByLastName('Martens'):");
        System.out.println("-----------------------------------------------");
        for (Customer customer : repository.findByLastName("Martens")){
            System.out.println(customer);
        }
    }

}
