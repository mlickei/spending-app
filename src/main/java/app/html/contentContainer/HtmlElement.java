package app.html.contentContainer;

import app.html.ContentContainer;

/**
 * Should be used to create customizable html elements
 */
public class HtmlElement extends ContentContainer
{

    private String elementType;
    private String innerContent;
    //TODO: add other attributes such as data attributes

    /**
     * Nice method for setting all values in the element.
     * @param elementType The html element type. Use HtmlElementType to get type.
     * @param id The id for html.
     * @param classes The class(es) for html element.
     * @param innerContent The inner content (string) of html element.
     */
    HtmlElement(String elementType, String id, String classes, String innerContent)
    {

        if(id != null && !id.isEmpty())
        {
            setId(id);
        }

        if(classes != null && !classes.isEmpty())
        {
            setClasses(classes);
        }

        if(elementType != null && !elementType.isEmpty())
        {
            setElementType(elementType);
        }

        if(innerContent != null && !innerContent.isEmpty())
        {
            setInnerContent(innerContent);
        }

    }

    /**
     * Special rendering that DOES NOT render any children content containers.
     * @return The string representation of the html element.
     */
    @Override
    public String render() {

        String elementType = getElementType();

        if(!elementType.equals(HtmlElementType.BR))
        {
            addContent("<" + elementType + " id=\"" + getId() + "\" class=\"" + getClasses() + "\">");
            addContent(getInnerContent());
            addContent("</" + elementType + ">");
        }
        else
        {
           addContent("<"+elementType+" />");
        }

        return getContent();
    }

    /**
     * Gets the element type of html.
     * @return Element type.
     */
    public String getElementType() {
        return elementType;
    }

    /**
     * Sets html element type. Should use the HtmlElementType to get the standard html element types.
     * @param elementType Html element type
     */
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    /**
     * Gets the inner content of html element.
     * @return Inner content
     */
    public String getInnerContent() {
        return innerContent;
    }

    /**
     * Sets inner content of html element. Will override the inner content.
     * @param innerContent Inner content to set in html element.
     */
    public void setInnerContent(String innerContent) {
        this.innerContent = innerContent;
    }

    //TODO: make an addInnerContent method

}
