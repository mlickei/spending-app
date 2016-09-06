package app.controller;

import app.security.Authenticator;
import app.service.ApplicationService;

/**
 * Authentication controller used for logging in users.
 */
public class Authenticate extends Controller
{

    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     */
    public Authenticate(ApplicationService applicationService)
    {
        super(applicationService);
    }

    /**
     * This one will authenticate a user's username with the provided password
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
