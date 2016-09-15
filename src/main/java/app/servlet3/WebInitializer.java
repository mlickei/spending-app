package app.servlet3;

import app.application.config.SpringRootConfg;
import app.application.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * The web initializer for setting the spring configs and servlet mappings.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    /**
     * Gets the spring root config
     * @return The spring root config class.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringRootConfg.class};
    }

    /**
     * Gets the spring web config
     * @return The spring web config class
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebConfig.class};
    }

    /**
     * Gets the servlet mapping path
     * @return The servlet mapping path
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
