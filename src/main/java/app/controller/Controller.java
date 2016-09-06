package app.controller;

import app.service.ApplicationService;
import app.resource.ResourceManager;

/**
 * Base for all controllers.
 * Right now the only thing a controller needs to do is implement the init method to return a renderable application service.
 */
public class Controller
{

    private ApplicationService _applicationService;
    private ResourceManager resourceManager = new ResourceManager();

    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     */
    public Controller(ApplicationService applicationService)
    {
        this._applicationService = applicationService;
    }

    /**
     * Init is used to generate all the necessary html and resources for the current application service
     * @return The updated application service with the html and resources included.
     */
    public ApplicationService init()
    {
        return this._applicationService;
    }

    public ApplicationService getApplicationService()
    {
        return _applicationService;
    }

    public void setApplicationService(ApplicationService applicationService)
    {
        _applicationService = applicationService;
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
