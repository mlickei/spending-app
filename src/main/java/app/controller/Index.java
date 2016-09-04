package app.controller;

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

        ContentContainer contentContainer = new ContentContainer();
        contentContainer.addContent("This is the index");
        applicationService.addToBodyContent(contentContainer.render());
        return applicationService;
    }
}
