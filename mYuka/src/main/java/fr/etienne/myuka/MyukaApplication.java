package fr.etienne.myuka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MyukaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyukaApplication.class, args);
    }

}
