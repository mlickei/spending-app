package app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The base application to boot with. Not really sure what else it does at this time.
 */
@SpringBootApplication
public class Application
{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}