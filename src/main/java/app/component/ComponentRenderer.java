package app.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to render components for the ui.
 *
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
public class ComponentRenderer
{
    
    private List<IComponent> _components = new ArrayList<>();
    
    public String renderComponents()
    {
        StringBuilder sb = new StringBuilder();
        
        for (IComponent component : _components)
        {
            sb.append(component.render());
        }
    
        return sb.toString();
    }
    
    public List<IComponent> getComponents()
    {
        return _components;
    }
    
    public void addComponent(IComponent component)
    {
        getComponents().add(component);
    }
    
    public void setComponents(List<IComponent> components)
    {
        _components = components;
    }
}
