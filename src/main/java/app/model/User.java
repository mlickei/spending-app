package app.model;

import app.database.UserDatabaseManager;

/**
 * This class represents a User object, including
 * all relevant details
 */
public class User {

    /** User ID */
    private int _userID;
    /** User name */
    private String _userName;
    /** Password Hash */
    private String _passwordHash;
    /** Salt */
    private String _salt;
    /** Email */
    private String _email;
    /** Avatar path */
    private String _avatarPath;
    /** First Name */
    private String _firstName;
    /** Last Name */
    private String _lastName;

    /**
     * Constructor for User class
     *
     * @param userName The username
     * @param passwordHash The password hash
     * @param salt The salt
     * @param email The email
     * @param avatarPath The avatar path
     */
    public User(String userName, String passwordHash, String salt, String email, String avatarPath)
    {
        _userID = -1;
        _userName = userName;
        _passwordHash = passwordHash;
        _salt = salt;
        _email = email;
        _avatarPath = avatarPath;
    }

    /**
     * Alternate constructor for User class, including user_id parameter
     *
     * @param userID The user id
     * @param userName The username
     * @param passwordHash The password hash
     * @param salt The salt
     * @param email The email
     * @param avatarPath The avatar path
     */
    public User(int userID, String userName, String passwordHash, String salt, String email, String avatarPath)
    {
        _userID = userID;
        _userName = userName;
        _passwordHash = passwordHash;
        _salt = salt;
        _email = email;
        _avatarPath = avatarPath;
    }
    
    /**
     * Get the user id.
     *
     * @return The user id.
     */
    public int getUserID() {
        return _userID;
    }
    
    /**
     * Set the user id.
     *
     * @param userID The user id.
     */
    public void setUserID(int userID) {
        _userID = userID;
    }
    
    /**
     * Get the user name.
     *
     * @return The user name.
     */
    public String getUserName() {
        return _userName;
    }
    
    /**
     * Set the user name.
     *
     * @param userName The user name.
     */
    public void setUserName(String userName) {
        _userName = userName;
    }
    
    /**
     * Get the password hash.
     *
     * @return The password hash.
     */
    public String getPasswordHash() {
        return _passwordHash;
    }
    
    /**
     * Set the password hash.
     *
     * @param passwordHash The password hash.
     */
    public void setPasswordHash(String passwordHash) {
        _passwordHash = passwordHash;
    }
    
    /**
     * Get the email.
     *
     * @return The email.
     */
    public String getEmail() {
        return _email;
    }
    
    /**
     * Set the email.
     *
     * @param email The email.
     */
    public void setEmail(String email) {
        _email = email;
    }
    
    /**
     * Get the avatar path.
     *
     * @return The avatar path.
     */
    public String getAvatarPath() {
        return _avatarPath;
    }
    
    /**
     * Set the avatar path.
     *
     * @param avatarPath The avatar path.
     */
    public void setAvatarPath(String avatarPath) {
        _avatarPath = avatarPath;
    }
    
    /**
     * Get first name.
     *
     * @return The first name.
     */
    public String getFirstName()
    {
        return _firstName;
    }
    
    /**
     * Set the first name.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName)
    {
        _firstName = firstName;
    }
    
    /**
     * Get the last name.
     *
     * @return The last name.
     */
    public String getLastName()
    {
        return _lastName;
    }
    
    /**
     * Set the last name.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName)
    {
        _lastName = lastName;
    }
}
