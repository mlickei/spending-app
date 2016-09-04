package app.resource;

/**
 * Provides the basic structure of all resource files
 */
public interface Resource
{

    /**
     * Gets path of resource
     * @return Path of resource
     */
    public String getPath();

    /**
     * Sets the path for resource. Will NOT contain where they are stored by default. Ex: /resource/css will not be included.
     * @param path New path for resource
     */
    public void setPath(String path);

    /**
     * Builds link for resource based on it's type.
     * @return String link tag for resource
     */
    public String buildLink();

}
