package app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * The base application to boot with. Not really sure what else it does at this time.
 */
@SpringBootApplication
@EnableRedisHttpSession
public class Application
{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}