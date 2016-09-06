package app.controller;

import app.model.User;
import app.security.Authenticator;
import app.service.ApplicationService;

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
    public AuthenticateNew(ApplicationService applicationService)
    {
        super(applicationService);
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
            User user = new User(username, password, "", email, "");
            user.insertUser();
            applicationService.addToBodyContent("Success!");
        }
    
        return applicationService;
    }
}