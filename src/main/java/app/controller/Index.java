package app.controller;

import app.component.ComponentRenderer;
import app.component.LoginComponent;
import app.html.ContentContainer;
import app.model.User;
import app.service.ApplicationService;
import app.session.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public class Index extends Controller
{

    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     */
    public Index(ApplicationService applicationService, ModelAndView modelAndView, HttpSession session)
    {
        super(applicationService, modelAndView, session);
    }

    /**
     * Init is used to generate all the necessary html and resources for the current application service
     * @return The updated application service with the html and resources included.
     */
    @Override
    public ApplicationService init()
    {
        ApplicationService applicationService = getApplicationService();
        HttpSession session = getSession();
    
        User user = (User) session.getAttribute(SessionAttributes.USER);
    
        if(user == null)
        {
            ComponentRenderer renderer = new ComponentRenderer();
            renderer.addComponent(new LoginComponent());
            applicationService.setBodyContent(renderer.renderComponents());
        }
        else
        {
            String username = user.getUserName();
    
            ContentContainer container = new ContentContainer();
            container.setContent("<div class=\"user-name\">" + username + "</div>");
            applicationService.setBodyContent(container.render());
        }
    
        
        return applicationService;
    }
}
