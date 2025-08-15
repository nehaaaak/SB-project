package com.project;

import com.project.customer.Customer;
import com.project.customer.CustomerRepository;
import com.project.customer.Gender;
// import com.project.s3.S3Buckets;
import com.project.s3.S3Service;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder,
            S3Service s3Service) { 

        return args -> {
            createRandomCustomer(customerRepository, passwordEncoder);
            s3Service.createBucketIfNotExists("spring-upload-demo");

//            testBucketUploadAndDownload(s3Service, s3Buckets);
        };
    }

    // private static void testBucketUploadAndDownload(S3Service s3Service, S3Buckets s3Buckets) {
    //     s3Service.putObject(s3Buckets.getBucketName(),
    //             "foo",
    //             "Hello World!".getBytes());

    //     byte[] obj = s3Service.getObject(s3Buckets.getBucketName(),
    //             "foo");

    //     System.out.println("Object: " + new String(obj));
    // }

    private static void createRandomCustomer(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        var faker = new Faker();
        Random random = new Random();
        Name name = faker.name();
        String firstName = name.firstName();
        String lastName = name.lastName();
        int age = random.nextInt(16, 99);
        Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@formik.com";
        Customer customer = new Customer(
                firstName +  " " + lastName,
                email,
                passwordEncoder.encode("password"),
                age,
                gender);
        customerRepository.save(customer);
        System.out.println(email);
    }

}
