package app.html.contentContainer.inputField;

import app.html.ContentContainer;
import app.html.contentContainer.inputField.InputType;

/**
 * Used to make basic html input fields
 */
public class InputFieldContent extends ContentContainer
{

    private String inputType = InputType.TEXT;
    private String value = "";
    private String name = "";

    /**
     * Boring basic constructor for input fields. Input type is set to text by default.
     */
    public InputFieldContent()
    {
    }

    /**
     * Nice constructor to set up a full input field. Set to an input type of text by default.
     * @param id The input id
     * @param classes The classes to add to the input
     * @param value The value to set the input to
     */
    public InputFieldContent(String id, String classes, String inputType, String name, String value)
    {

        if(id != null && !id.isEmpty()) {
            setId(id);
        }

        if(classes != null && !classes.isEmpty()) {
            setClasses(classes);
        }

        if(inputType != null && !inputType.isEmpty())
        {
            setInputType(inputType);
        }

        if(name != null && !name.isEmpty())
        {
            setName(name);
        }

        if(value != null && !value.isEmpty()) {
            setValue(value);
        }

    }

    /**
     * Special rendering for input types. DOES NOT RENDER AND CHILDREN CONTENT CONTAINERS.
     * @return The text representation of input field.
     */
    @Override
    public String render() {
        return "<input id=\""+getId()+"\" class=\""+getClasses()+"\" type=\""+getInputType()+"\" value=\""+getValue()+"\" name=\""+getName()+"\" />";
    }

    /**
     * Sets the value of the input field.
     * @param val Value to set.
     */
    public void setValue(String val)
    {
        this.value = val;
    }

    /**
     * Gets value set in input field.
     * @return Value set in input field.
     */
    public String getValue()
    {
        return this.value;
    }

    /**
     * Sets the input type. Use the InputType class to access the standard types.
     * @param inputType Input type to set the input field to.
     */
    public void setInputType(String inputType)
    {
        this.inputType = inputType;
    }

    /**
     * Returns the set input type.
     * @return Input type of input field.
     */
    public String getInputType()
    {
        return this.inputType;
    }

    /**
     * Sets the name attribute of input. To be used in conjunction with the for attribute in a label and will be the request parameter.
     * @param name Name value for name attribute.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name set in the input field.
     * @return Name set in input field.
     */
    public String getName()
    {
        return this.name;
    }

}
