package app.controller;

import app.component.ComponentRenderer;
import app.component.LoginComponent;
import app.html.ContentContainer;
import app.service.ApplicationService;

public class Index extends Controller
{

    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     */
    public Index(ApplicationService applicationService)
    {
        super(applicationService);
    }

    /**
     * Init is used to generate all the necessary html and resources for the current application service
     * @return The updated application service with the html and resources included.
     */
    @Override
    public ApplicationService init()
    {
        ApplicationService applicationService = getApplicationService();

        ComponentRenderer renderer = new ComponentRenderer();
        renderer.addComponent(new LoginComponent());
        applicationService.setBodyContent(renderer.renderComponents());
        
        return applicationService;
    }
}
