package app.model;

import app.database.UserDatabaseManager;
import app.security.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class represents a User object, including
 * all relevant details
 */
public class User {

    private int userID;
    private String userName;
    private String passwordHash;
    private String salt;
    private String email;
    private String avatarPath;
    
    private UserDatabaseManager _userManager = new UserDatabaseManager();

    /**
     * Constructor for User class
     * @param userName
     * @param passwordHash
     * @param salt
     * @param email
     * @param avatarPath
     */
    public User(String userName, String passwordHash, String salt, String email, String avatarPath)
    {
        this.userID = -1;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.email = email;
        this.avatarPath = avatarPath;
    }

    /**
     * Alternate constructor for User class, including user_id parameter
     * @param userID
     * @param userName
     * @param passwordHash
     * @param salt
     * @param email
     * @param avatarPath
     */
    public User(int userID, String userName, String passwordHash, String salt, String email, String avatarPath)
    {
        this.userID = userID;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.email = email;
        this.avatarPath = avatarPath;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
