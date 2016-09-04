package app.resource.javascript;

import app.resource.Resource;

/**
 * Javascript resource. Has own path where all javascript is stored.
 * Renders with it's own special link string.
 */
public class JavascriptResource implements Resource
{

    private String path;
    private final String BASE_CSS_RESOURCE_PATH = "/resources/javascript";

    /**
     * Typically you'll always use this to make a new resource. Will append the base resource path for all javascript.
     * @param path Relative path of resource for it's base directory.
     */
    public JavascriptResource(String path)
    {
        this.path = BASE_CSS_RESOURCE_PATH + path;
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

    @Override
    public String buildLink()
    {
        return "<script src=\""+getPath()+"\" />";
    }
}
