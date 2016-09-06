package app.model;

import java.util.Date;

/**
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
public class Transaction
{
    
    private int _id;
    private Category _category;
    private float _amount;
    private String _name;
    private String _description;
    private Date _dateTime;
    private Date _createTime;
    private User _user;
    
    public int getId()
    {
        return _id;
    }
    
    public void setId(int id)
    {
        _id = id;
    }
    
    public Category getCategory()
    {
        return _category;
    }
    
    public void setCategory(Category category)
    {
        _category = category;
    }
    
    public float getAmount()
    {
        return _amount;
    }
    
    public void setAmount(float amount)
    {
        _amount = amount;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public void setName(String name)
    {
        _name = name;
    }
    
    public String getDescription()
    {
        return _description;
    }
    
    public void setDescription(String description)
    {
        _description = description;
    }
}
