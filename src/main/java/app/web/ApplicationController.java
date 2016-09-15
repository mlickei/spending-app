package app.web;

import app.controller.*;
import app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static app.session.SessionAttributes.USER;

/**
 * This is where all of the page mapping magic happens.
 * Use methods and request mappings to setup page controllers and get page path information from wildcard pages and request parameters.
 */
@org.springframework.stereotype.Controller
@SessionAttributes({USER})
public class ApplicationController
{
    
    private ApplicationService _applicationService;
    
    /**
     * Base constructor to use the application controller.
     *
     * @param applicationService The application service to use.
     */
    @Autowired
    public ApplicationController(ApplicationService applicationService)
    {
        _applicationService = applicationService;
    }
    
    /**
     * The index of the website. Passes on to the Index controller.
     *
     * @return The model and view with mappings of content to be rendered in jsp page.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("index");
        //Create new instance of the page object we are rendering
        Index index = new Index(_applicationService, modelAndView, session);
        //Running init will cause the page object to render all of it's content
        _applicationService = index.init();
        //Use the render method to setup the model
        modelAndView = _applicationService.render(modelAndView, index.getResourceManager());
        //The jsp to be rendered
        return modelAndView;
    }
    
    /**
     * The login page to be rendered. Passes on to the Login controller.
     *
     * @return The model and view with mappings of content to be rendered in jsp page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("index");
        Login login = new Login(_applicationService, modelAndView, session);
        _applicationService = login.init();
        _applicationService.setDescription("Test description");
        modelAndView = _applicationService.render(modelAndView, login.getResourceManager());
        return modelAndView;
    }
    
    /**
     * Will authenticate that a user has proper credentials. Can be used as a webservice.
     *
     * @param username The username for user
     * @param password The users password
     * @return The model and view with mappings of content to be rendered in jsp page.
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView authenticate(HttpSession session, @RequestParam(value = "username", required = true, defaultValue = "") String username, @RequestParam(value = "password", required = true, defaultValue = "") String password)
    {
        ModelAndView modelAndView = new ModelAndView("index");
        Authenticate authenticate = new Authenticate(_applicationService, modelAndView, session);
        _applicationService = authenticate.init(username, password);
        modelAndView = this._applicationService.render(modelAndView, authenticate.getResourceManager());
        return modelAndView;
    }
    
    @RequestMapping(value = "/account/create", method = RequestMethod.GET)
    public ModelAndView createAccount(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("index");
        CreateAccount createAccount = new CreateAccount(_applicationService, modelAndView, session);
        _applicationService = createAccount.init();
        modelAndView = _applicationService.render(modelAndView, createAccount.getResourceManager());
        return modelAndView;
    }
    
    @RequestMapping(value = "/user/authenticate-new", method = RequestMethod.POST)
    public ModelAndView authenticateNew(HttpSession session,
                                        @RequestParam(value = "username", required = true, defaultValue = "") String username,
                                        @RequestParam(value = "password", required = true, defaultValue = "") String password,
                                        @RequestParam(value = "email", required = true, defaultValue = "") String email)
    {
        ModelAndView modelAndView = new ModelAndView("index");
        AuthenticateNew authenticateNew = new AuthenticateNew(_applicationService, modelAndView, session);
        _applicationService = authenticateNew.init(username, password, email);
        modelAndView = _applicationService.render(modelAndView, authenticateNew.getResourceManager());
        return modelAndView;
    }

    /*  TODO: method to start a user session given the username
        Start user session http://stackoverflow.com/questions/18791645/how-to-use-session-attributes-in-spring-mvc
     */
    
}
