package app.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Defines where the services are located that are used for the application.
 */
@Configuration
@ComponentScan({"app.service"})
public class SpringRootConfg
{

}
