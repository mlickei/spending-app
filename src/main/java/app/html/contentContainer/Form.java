package app.html.contentContainer;

import app.html.ContentContainer;
import app.html.Html;

/**
 * Standard form html element. Default method is set to get.
 */
public class Form extends ContentContainer
{

    public static String POST = "post";
    public static String GET = "get";

    private String action = "";
    private String methodType = this.GET;

    /**
     * Nice way to create form element while setting attributes of form.
     * @param id Id for form
     * @param classes Classes for form
     * @param methodType Method type for form
     * @param action Action for where the form goes to
     */
    public Form(String id, String classes, String methodType, String action)
    {

        if(id != null && !id.isEmpty())
        {
            setId(id);
        }

        if(classes != null && !classes.isEmpty())
        {
            setClasses(classes);
        }

        if(methodType != null && !methodType.isEmpty())
        {
            setMethodType(methodType);
        }

        if(action != null && !action.isEmpty())
        {
            setAction(action);
        }

    }

    @Override
    public String render() {
        addContent("<form id=\""+getId()+"\" class=\""+getClasses()+"\" method=\""+getMethodType()+"\" action=\""+getAction()+"\">");
        for (Html contentContainer : getContentContainers()) {
            addContent(contentContainer.render());
        }
        addContent("</form>");

        return getContent();
    }

    /**
     * Gets action attribute of form. This will be a url or path that the form will direct people to.
     * @return Action type, where the form will direct users to.
     */
    public String getAction() {
        return action;
    }

    /**
     * Set action for form. This will be a url or path that the form will direct people to.
     * @param action The action that the form will direct users to.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Gets the method type. GET, POST, etc.
     * @return Method type.
     */
    public String getMethodType() {
        return methodType;
    }

    /**
     * Sets the method type. GET, POST, etc.
     * @param methodType The method type to use in form.
     */
    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

}
