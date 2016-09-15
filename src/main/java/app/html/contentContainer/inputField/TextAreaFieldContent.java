package app.html.contentContainer.inputField;

/**
 * A text area field which is it's own special html element.
 */
public class TextAreaFieldContent extends InputFieldContent
{

    private int rows = 5;
    private int cols =15;

    /**
     * Nice method to create a text area field object with attributes. Sets rows to 5 by default and cols to 15 by default.
     * @param id Id for text area
     * @param classes Class(es) for text area
     * @param rows Rows for text area. Default = 5
     * @param cols Cols for text area. Dfeault = 15
     */
    public TextAreaFieldContent(String id, String classes, int rows, int cols)
    {

        if(id != null && !id.isEmpty())
        {
            setId(id);
        }

        if(classes != null && !classes.isEmpty())
        {
            setClasses(classes);
        }

        if(rows > -1)
        {
            setRows(rows);
        }

        if(cols > -1)
        {
            setCols(cols);
        }

    }

    /**
     * Renders the text area as it's html content. DOES NOT render any children content containers.
     * @return String representation of text area field.
     */
    @Override
    public String render() {
        addContent("<textarea id=\""+getId()+"\" class=\""+getClasses()+"\" rows=\""+getRows()+"\" cols=\""+getCols()+"\">");
        addContent(getValue());
        addContent("</textarea>");
        return getContent();
    }

    /**
     * Gets rows of text area
     * @return Rows of text area
     */
    public int getRows() {
        return rows;
    }

    /**
     * Sets rows for text area
     * @param rows Rows for text area
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Gets cols of text area
     * @return Cols of text area
     */
    public int getCols() {
        return cols;
    }

    /**
     * Sets cols for text area
     * @param cols Cols for text area
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

}
