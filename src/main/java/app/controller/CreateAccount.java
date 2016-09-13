package app.controller;

import app.component.ComponentRenderer;
import app.component.CreateAccountComponent;
import app.service.ApplicationService;

/**
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
public class CreateAccount extends Controller
{
    
    /**
     * Base constructor with the application service passed in
     *
     * @param applicationService The application service used in the current controller
     */
    public CreateAccount(ApplicationService applicationService)
    {
        super(applicationService);
    }
    
    @Override
    public ApplicationService init()
    {
        ApplicationService service = getApplicationService();
    
        ComponentRenderer renderer = new ComponentRenderer();
        renderer.addComponent(new CreateAccountComponent());
        
        service.setTitle("Create Account");
        service.setBodyContent(renderer.renderComponents());
        
        return service;
    }
    
}
