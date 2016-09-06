package app.html;

import java.util.ArrayList;
import java.util.List;

/**
 * Base implementation for content containers and rendering content.
 */
public class ContentContainer implements Html
{

    private String content = "";
    private String classes = "";
    private String id = "";

    List<ContentContainer> contentContainers = new ArrayList<ContentContainer>();

    public ContentContainer()
    {
    }
    
    public ContentContainer(String className)
    {
        classes = className;
    }
    
    /**
     * Combines all of the content containers into a string of content.
     * Renders all children content inside of a wrapping div along with its own content.
     * @return The string representation of rendered content.
     */
    @Override
    public String render() {

        for (ContentContainer contentContainer : getContentContainers()) {
            addContent("<div id=\"" + contentContainer.id + "\" class=\"" + contentContainer.classes + "\">");
            contentContainer.renderChildren();
            addContent("</div>");
        }

        return getContent();
    }

    /**
     * Renders all children content by looping through all content containers and calling their render method.
     * Will append the children's rendering to the content of this container.
     */
    @Override
    public void renderChildren() {
        String renderedContent = "";

        for (ContentContainer contentContainer : getContentContainers()) {
            renderedContent = renderedContent + contentContainer.render();
        }

        addContent(renderedContent);
    }

    /**
     * Adds the string of content to the current content.
     * @param content String to be added to the current content.
     */
    public void addContent(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.content);
        sb.append(content);
        this.content = sb.toString();
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void addClassName(String className) {
        this.classes = this.classes + " " + className;
    }

    @Override
    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String getClasses() {
        return this.classes;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setContentContainers(List<ContentContainer> contentContainers) { this.contentContainers = contentContainers; }

    @Override
    public List<ContentContainer> getContentContainers() {
        return this.contentContainers;
    }

    @Override
    public List<ContentContainer> addContentContainer(ContentContainer contentContainer) {
        this.contentContainers.add(contentContainer);
        return this.contentContainers;
    }
}
