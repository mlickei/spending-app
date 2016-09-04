package app.web;

import app.controller.Authenticate;
import app.controller.Login;
import app.controller.Index;
import app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is where all of the page mapping magic happens.
 * Use methods and request mappings to setup page controllers and get page path information from wildcard pages and request parameters.
 */
@org.springframework.stereotype.Controller
public class ApplicationController
{

    private ApplicationService applicationService;

    /**
     * Base constructor to use the application controller.
     * @param applicationService The application service to use.
     */
    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    /**
     * The index of the website. Passes on to the Index controller.
     * @return The model and view with mappings of content to be rendered in jsp page.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        //Create new instance of the page object we are rendering
        Index index = new Index(applicationService);
        //Running init will cause the page object to render all of it's content
        this.applicationService = index.init();
        //Use the render method to setup the model
        modelAndView = applicationService.render(modelAndView, index.getResourceManager());
        //The jsp to be rendered
        return modelAndView;
    }

    /**
     * The login page to be rendered. Passes on to the Login controller.
     * @return The model and view with mappings of content to be rendered in jsp page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        Login login = new Login(applicationService);
        this.applicationService = login.init();
        applicationService.setDescription("Test description");
        modelAndView = this.applicationService.render(modelAndView, login.getResourceManager());
        return modelAndView;
    }

    /**
     * Will authenticate that a user has proper credentials. Can be used as a webservice.
     * @param username The username for user
     * @param password The users password
     * @return The model and view with mappings of content to be rendered in jsp page.
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView authenticate(@RequestParam(value="username", required = true, defaultValue = "") String username, @RequestParam(value = "password", required = true, defaultValue = "") String password)
    {
        ModelAndView modelAndView = new ModelAndView("index");
        Authenticate authenticate = new Authenticate(applicationService);
        this.applicationService = authenticate.init(username, password);
        modelAndView = this.applicationService.render(modelAndView, authenticate.getResourceManager());
        return modelAndView;
    }

    /*  TODO: method to start a user session given the username
        Start user session http://stackoverflow.com/questions/18791645/how-to-use-session-attributes-in-spring-mvc
     */

}
