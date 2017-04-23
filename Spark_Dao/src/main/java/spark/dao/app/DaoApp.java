package main.java.spark.dao.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource(locations={"classpath:SparkDao_Spring.xml"})
@PropertySource(value={"classpath:dao.properties"})
public class DaoApp  implements CommandLineRunner {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DaoApp.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        //do something

    }
}