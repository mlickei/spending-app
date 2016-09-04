package app.service;

import app.resource.ResourceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * The application service is used to store all of the content.
 * It is rendered by setting up the model mappings and returning them to the controller.
 * The model mapping is used in the jsp to render the content.
 */
@Service
public class ApplicationService
{

    private String title = "";
    private String description = "";
    private String bodyContent = "";
    private String headerContent = "";
    private String contentType = "";
    //TODO implement content type uses;

    /**
     * Set description of the page
     * @param description Page description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Returns description of the page
     * @return The page description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Sets page title
     * @param title The page title string to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Gets the page title
     * @return The page title that's been set
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Adds the string of header content to the header.
     * @param moreHeaderContent The header content that you want to append to the current header
     */
    public void addToHeaderContent(String moreHeaderContent)
    {
        this.headerContent = this.headerContent + moreHeaderContent;
    }

    /**
     * Gets the current pages header content. Typically links and meta tags.
     * @return The pages header content
     */
    public String getHeaderContent()
    {
        return headerContent;
    }

    /**
     * Sets the header content and will override the header content already set.
     * @param headerContent New header content string
     */
    public void setHeaderContent(String headerContent)
    {
        this.headerContent = headerContent;
    }

    /**
     * Appends content to the body string that'll be rendered in the htlm body tag.
     * @param moreBodyContent The body content string representation that'll be appended.
     */
    public void addToBodyContent(String moreBodyContent)
    {
        this.bodyContent = this.bodyContent + moreBodyContent;
    }

    /**
     * Sets the body content to the new string. Will override the existing content with the new content.
     * @param bodyContent The new string of body content to override the old body string content.
     */
    public void setBodyContent(String bodyContent)
    {
        this.bodyContent = bodyContent;
    }

    /**
     * Gets the current pages body content.
     * @return The current body content string.
     */
    public String getBodyContent()
    {
        return this.bodyContent;
    }

    /**
     * Renders everything; body, headers, resource links, etc. into their specific model view mapings.
     * @param modelAndView The model and view to add the content mappings to.
     * @return The passed model and view with added mappings of content.
     */
    public ModelAndView render(ModelAndView modelAndView, ResourceManager resourceManager)
    {
        addToHeaderContent(resourceManager.renderResourceLinks());
        modelAndView.addObject("headers", getHeaderContent());
        modelAndView.addObject("body", getBodyContent());
        modelAndView.addObject("description", getDescription());
        modelAndView.addObject("title", getTitle());
        return modelAndView;
    }

}
