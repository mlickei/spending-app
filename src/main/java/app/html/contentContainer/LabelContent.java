package app.html.contentContainer;

import app.html.ContentContainer;

/**
 * A label that will be rendered as a label html tag.
 * Can contain other content containers but those should only be inputs.
 */
public class LabelContent extends ContentContainer {

    private String whatFor = "";
    private String labelText = "";

    /**
     * Empty constructor for bland lame label.
     */
    public LabelContent() {
    }

    /**
     * Nice constructor that allows you to set properties for the label html.
     * @param id      Id of label
     * @param classes Classes of label
     * @param whatFor For attribute of label
     */
    public LabelContent(String id, String classes, String whatFor, String labelText) {

        if (id != null && !id.isEmpty()) {
            setId(id);
        }

        if (classes != null && !classes.isEmpty()) {
            setClasses(classes);
        }

        if (whatFor != null && !whatFor.isEmpty()) {
            setFor(whatFor);
        }

        if (labelText != null && !labelText.isEmpty()) {
            setLabelText(labelText);
        }

    }

    @Override
    public String render() {

        addContent("<label id=\"" + getId() + "\" class=\"" + getClasses() + "\" for=\"" + getFor() + "\">");
        addContent(getLabelText());
        addContent(renderChildren());
        addContent("</label>");

        return getContent();
    }

    /**
     * Sets the for attribute in the label
     * @param whatFor The for value
     */
    public void setFor(String whatFor) {
        this.whatFor = whatFor;
    }

    /**
     * Gets the for attribute values in label
     * @return For value
     */
    public String getFor() {
        return this.whatFor;
    }

    /**
     * Sets label text that is rendered before the children content.
     * @param labelText Text to render before children content.
     */
    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    /**
     * Gets the label text that'll be rendered before the children content.
     * @return Label text
     */
    public String getLabelText()
    {
        return this.labelText;
    }

}
