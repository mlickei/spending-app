package app.controller;

import app.service.ApplicationService;
import app.resource.ResourceManager;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Base for all controllers.
 * Right now the only thing a controller needs to do is implement the init method to return a renderable application service.
 */
public class Controller
{

    private ApplicationService _applicationService;
    private ModelAndView _modelAndView;
    private HttpSession _session;
    private ResourceManager resourceManager = new ResourceManager();

    /**
     * Base constructor with the application service passed in
     * @param applicationService The application service used in the current controller
     */
    public Controller(ApplicationService applicationService, ModelAndView modelAndView, HttpSession session)
    {
        _applicationService = applicationService;
        _modelAndView = modelAndView;
        _session = session;
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
    
    public ModelAndView getModelAndView()
    {
        return _modelAndView;
    }
    
    public void setModelAndView(ModelAndView modelAndView)
    {
        _modelAndView = modelAndView;
    }
    
    public HttpSession getSession()
    {
        return _session;
    }
    
    public void setSession(HttpSession session)
    {
        _session = session;
    }
}
