package pl.betse.beontime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@LiquibaseDataSource
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
