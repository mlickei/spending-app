package app.resource.css;

import app.resource.Resource;

/**
 * CSS resource. Has own path where all css is stored.
 * Renders with it's own special link string.
 */
public class CSSResource implements Resource
{

    private String path;
    private final String BASE_CSS_RESOURCE_PATH = "/resources/css/build";

    /**
     * Typically you'll always use this to make a new resource. Will append the base resource path for all css.
     * @param path Relative path of resource for it's base directory.
     */
    public CSSResource(String path)
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
            return "<link rel=\"stylesheet\" type=\"text/css\" href=\""+getPath()+"\">";
    }

}
