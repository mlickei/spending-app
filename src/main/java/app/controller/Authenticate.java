package app.controller;

import app.database.UserDatabaseManager;
import app.model.User;
import app.security.Authenticator;
import app.service.ApplicationService;
import app.session.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Authentication controller used for logging in users.
 */
public class Authenticate extends Controller
{
    
    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     * @param modelAndView The model and view being used.
     * @param session The session
     */
    public Authenticate(ApplicationService applicationService, ModelAndView modelAndView, HttpSession session)
    {
        super(applicationService, modelAndView, session);
    }

    /**
     * This one will authenticate a user's username with the provided password
     *
     * @param username The user name given
     * @param password The password
     * @return A valid response if user passes
     */
    public ApplicationService init(String username, String password)
    {
        ApplicationService applicationService = getApplicationService();
        boolean isUser = Authenticator.authenticateUser(username, password);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("authentication:");
        sb.append(isUser);

        //We know the user is authenticated so pass the username on so the js can log them in
        if(isUser)
        {
            UserDatabaseManager userManager = new UserDatabaseManager();
            User user = userManager.getUser(username);
            getSession().setAttribute(SessionAttributes.USER, user);
            sb.append(", user: {");
            sb.append("username: \"");
            sb.append(username);
            sb.append("\" }");
        }

        sb.append("}");
        applicationService.setBodyContent(sb.toString());
        
        return applicationService;
    }

}
