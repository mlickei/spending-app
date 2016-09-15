package app.controller;

import app.component.ComponentRenderer;
import app.component.LoginComponent;
import app.resource.css.CSSProvider;
import app.service.ApplicationService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * The login page controller. Used to render the login page along with it's specific resource files.
 */
public class Login extends Controller
{

    public Login(ApplicationService applicationService, ModelAndView modelAndView, HttpSession session)
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

        //Generate header information and add resources
        getResourceManager().addResource(CSSProvider.BASE_STYLES);
        getResourceManager().addResource(CSSProvider.LOGIN_PAGE);
    
        ComponentRenderer renderer = new ComponentRenderer();
        renderer.addComponent(new LoginComponent());
        
        applicationService.setBodyContent(renderer.renderComponents());
        return applicationService;
    }

}
