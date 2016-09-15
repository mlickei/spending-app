package app.controller;

import app.database.UserDatabaseManager;
import app.model.User;
import app.security.Authenticator;
import app.service.ApplicationService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
public class AuthenticateNew extends Controller
{
    
    /**
     * Base constructor with the application service passed in
     *
     * @param applicationService The application service used in the current controller
     */
    public AuthenticateNew(ApplicationService applicationService, ModelAndView modelAndView, HttpSession session)
    {
        super(applicationService, modelAndView, session);
    }
    
    public ApplicationService init(String username, String password, String email)
    {
        ApplicationService applicationService = getApplicationService();
        
        if (Authenticator.doesUserExist(username))
        {
            //TODO display message about user already existing.
            applicationService.addToBodyContent("Failed creating user.");
        }
        else
        {
            UserDatabaseManager userManager = new UserDatabaseManager();
            userManager.insertUser(username, password, email, "");
            applicationService.addToBodyContent("Success!");
        }
    
        return applicationService;
    }
}
