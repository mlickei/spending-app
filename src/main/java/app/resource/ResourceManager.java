package app.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all resources for a page. You should only need one per page and
 * it'll provide you with the necessary string representation to use in the
 * header by calling renderResourceLinks().
 */
public class ResourceManager
{

    private List<Resource> resources = new ArrayList<>();

    /**
     * Adds resource to the list of resources maintained
     * @param resource New resource to add
     */
    public void addResource(Resource resource)
    {
        this.resources.add(resource);
    }

    /**
     * Sets and overrides the list of resources being maintained
     * @param resources New list of resources
     */
    public void setResources(List<Resource> resources)
    {
        this.resources = resources;
    }

    /**
     * Gets list of managed resources
     * @return List of managed resources
     */
    public List<Resource> getResources()
    {
        return this.resources;
    }

    /**
     * Provides string representation of managed resource as link tags. To be used in header/body.
     * @return String representatin of managed resources.
     */
    public String renderResourceLinks()
    {
        StringBuilder sb = new StringBuilder();
        for(Resource resource:this.resources)
        {
            sb.append(resource.buildLink());
        }
        return sb.toString();
    }

}
