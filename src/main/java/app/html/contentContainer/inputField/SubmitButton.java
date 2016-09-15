package app.html.contentContainer.inputField;

/**
 * Will setup a simple submit button for a form or something.
 */
public class SubmitButton extends InputFieldContent
{

    private final String type = InputType.SUBMIT;

    /**
     * Boring constructor. Sets input type to submit by default.
     */
    public SubmitButton()
    {
        setInputType(type);
    }

    /**
     * Nice constructor to set values for the button. Sets input type to submit by default.
     * @param id Id for input
     * @param classes Classes for input
     * @param value Value of submit button (shows up as button text)
     */
    public SubmitButton(String id, String classes, String value)
    {

        setInputType(type);

        if(id != null && !id.isEmpty())
        {
            setId(id);
        }

        if(classes != null && !classes.isEmpty())
        {
            setClasses(classes);
        }

        if(value != null && !value.isEmpty())
        {
            setValue(value);
        }

    }

    /**
     * Just renders the button. DOES NOT render any children elements.
     * @return The string representation of the submit button.
     */
    @Override
    public String render()
    {
        return "<input id=\""+getId()+"\" class=\""+getClasses()+"\" type=\""+getInputType()+"\" value=\""+getValue()+"\" />";
    }

}
