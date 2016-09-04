package app.resource.image;

import app.resource.Resource;

/**
 * Image resource that renders as an image tag with a path and alt text.
 */
public class ImageResource implements Resource
{

    private String path;
    private String alt;
    private final String BASE_IMAGE_RESOURCE_PATH = "/resources/images";

    /**
     * Constructor for image resources. Allows you to set a path and alt text attribute
     * @param path The image file path
     * @param alt The image alt text
     */
    public ImageResource(String path, String alt)
    {
        this.path = this.BASE_IMAGE_RESOURCE_PATH + path;
        this.alt = alt;
    }

    @Override
    public String getPath()
    {
        return this.path;
    }

    @Override
    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * Gets the alt text.
     * @return Alt text.
     */
    public String getAlt()
    {
        return this.alt;
    }

    /**
     * Sets the alt text.
     * @param alt New alt text.
     */
    public void setAlt(String alt)
    {
        this.alt = alt;
    }

    @Override
    public String buildLink()
    {
        return "<img src=\""+getPath()+"\" alt=\""+getAlt()+"\" />";
    }

}
