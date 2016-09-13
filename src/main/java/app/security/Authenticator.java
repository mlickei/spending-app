package app.security;

import app.database.UserDatabaseManager;
import app.model.User;

/**
 * This class is used to authenticate a user given a userName and password provided by the user for login purposes
 */
public class Authenticator
{
    
    public static boolean doesUserExist(String username)
    {
        UserDatabaseManager userManager = new UserDatabaseManager();
        User user = userManager.getUser(username);
        return user != null;
    }
    
    /**
     * This method is used to check a username-password pair against database values.
     * @param userName The username provided by the user.
     * @param inPassword The password provided by the user.
     * @return Returns true if the password hash matches the value in the database. Returns false otherwise.
     */
    public static boolean authenticateUser(String userName, String inPassword)
    {
        UserDatabaseManager userManager = new UserDatabaseManager();
        String hashSaltPair[] = userManager.getHashSaltPair(userName);
        String userHash = hashSaltPair[0];
        String userSalt = hashSaltPair[1];

        PasswordHasher pw = new PasswordHasher();

        pw.hashPassword(inPassword, userSalt);

        String inHash = pw.getHash();

        if(userHash.equals(inHash))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
