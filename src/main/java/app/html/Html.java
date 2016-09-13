package app.html;

import java.util.List;

/**
 * Used as the base interface for all html.
 * Requires a method for rendering it's content and a way to manage all of the content containers inside of it.
 */
public interface Html
{

    /**
     * Used to render content on a page
     * @return String representation of the content
     */
    String render();

    /**
     * Renders all children (content containers)
     */
    String renderChildren();

    /**
     * Sets the content of html
     * @param content The string of html to set the content
     */
    void setContent(String content);

    /**
     * Gets the content of html
     * @return Html content
     */
    String getContent();

    /**
     * Sets class name(s) for this html.
     * @param classes The class name(s) to set for html. Space separated for each class name.
     */
    void setClasses(String classes);

    /**
     * Gets the class name(s) for the html.
     * @return The class name(s) for html. Space separated for each class name.
     */
    String getClasses();

    /**
     * Sets id for html
     * @param id The id to set for html
     */
    void setId(String id);

    /**
     * Gets the id set for html
     * @return The id set for html
     */
    String getId();

    /**
     * Sets and overrides the list of content containers.
     * @param contentContainers The new list of content containers.
     */
    void setContentContainers(List<ContentContainer> contentContainers);

    /**
     * Gets the list of content containers for html
     * @return List of content containers for html
     */
    List<ContentContainer> getContentContainers();

    /**
     * Adds the content container to the list of content containers in html
     * @param contentContainer The content container to add
     * @return List of content containers so that you can chain commands on the list.
     */
    List<ContentContainer> addContentContainer(ContentContainer contentContainer);

    //TODO: make a addContentContainers which allows the adding of a list to the list

}
