package app.controller;

import app.service.ApplicationService;
import app.resource.ResourceManager;

/**
 * Base for all controllers.
 * Right now the only thing a controller needs to do is implement the init method to return a renderable application service.
 */
public class Controller
{

    private ApplicationService applicationService;
    private ResourceManager resourceManager = new ResourceManager();

    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     */
    Controller(ApplicationService applicationService)
    {
        this.applicationService = applicationService;
    }

    /**
     * Init is used to generate all the necessary html and resources for the current application service
     * @return The updated application service with the html and resources included.
     */
    public ApplicationService init()
    {
        return this.applicationService;
    }

    public ApplicationService getApplicationService()
    {
        return applicationService;
    }

    public void setApplicationService(ApplicationService applicationService)
    {
        this.applicationService = applicationService;
    }

    public ResourceManager getResourceManager()
    {
        return resourceManager;
    }

    public void setResourceManager(ResourceManager resourceManager)
    {
        this.resourceManager = resourceManager;
    }
}
