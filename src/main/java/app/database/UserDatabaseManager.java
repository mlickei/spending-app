package app.database;

import app.model.User;
import app.security.PasswordHasher;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.*;

/**
 * This class is used to manage connections to the user database
 */
public class UserDatabaseManager {

    private static String url;
    private static String db_user;
    private static String db_password;

    /**
     * This method is used to initialize the database
     * details, including url, user, and password
     */
    public UserDatabaseManager()
    {
        url = "jdbc:mysql://localhost:3306/spendingapp";
        db_user = "admin";
        db_password = "af9fsxFO";
    }

    /**
     * This method is used to insert a user into the user database
     * @param userName The users username
     * @param password The users password
     * @param email The users email address
     * @return The user_id of the newly inserted user, fetched from the database. Returns -1 if the insertion failed.
     */
    public int insertUser(String userName, String password, String email, String avatarPath)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int newID = -1;

        try
        {
            PasswordHasher hasher = new PasswordHasher();
            hasher.hashPassword(password);
            String salt = hasher.getSalt();
            String hash = hasher.getHash();
            
            conn = DriverManager.getConnection(url, db_user, db_password);
            pst = conn.prepareStatement("INSERT INTO user (user_name, password, salt, email, filepath) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, userName);
            pst.setString(2, hash);
            pst.setString(3, salt);
            pst.setString(4, email);
            pst.setString(5, avatarPath);

            pst.executeUpdate();

            pst = conn.prepareStatement("SELECT user_id FROM user WHERE user_name = ?");
            pst.setString(1, userName);

            rs = pst.executeQuery();

            newID = rs.getInt("user_id");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return newID;
    }

    /**
     * This method is used to get the unique user_id for a user.
     * The user_id is used for deleting user records in other tables
     * @param userName The username of the user
     * @return The user_id of the corresponding userName. Returns -1 if the user does not exist.
     */
    public int getUserID(String userName)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int newID = -1;

        try
        {
            conn = DriverManager.getConnection(url, db_user, db_password);

            pst = conn.prepareStatement("SELECT user_id FROM user WHERE user_name = ?");
            pst.setString(1, userName);

            rs = pst.executeQuery();

            newID = rs.getInt("user_id");

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return newID;
    }

    /**
     * This method is used to delete a user from the system,
     * including all related data
     * @param userID The user_id to delete
     */
    public void deleteUser(int userID)
    {
        Connection conn = null;
        PreparedStatement pst = null;

        try
        {
            conn = DriverManager.getConnection(url, db_user, db_password);

            /* Delete user ratings */
            pst = conn.prepareStatement("DELETE FROM user_rating WHERE user_id = ?");
            pst.setInt(1, userID);

            pst.executeUpdate();

            /* Delete the user watchlist */
            pst = conn.prepareStatement("DELETE FROM user_watchlist WHERE user_id = ?");
            pst.setInt(1, userID);

            pst.executeUpdate();

            /* finally, delete the user */
            pst = conn.prepareStatement("DELETE FROM user WHERE user_id = ?");
            pst.setInt(1, userID);

            pst.executeUpdate();

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method is used to update the password and salt for a user.
     * @param userID The user_id to update
     * @param newHash The new hash for the user
     * @param newSalt The new salt for the user
     */
    public void updatePassword(int userID, String newHash, String newSalt)
    {
        Connection conn = null;
        PreparedStatement pst = null;

        try
        {
            conn = DriverManager.getConnection(url, db_user, db_password);

            pst = conn.prepareStatement("UPDATE user SET password = ?, salt = ? WHERE user_id = ?");
            pst.setString(1, newHash);
            pst.setString(2, newSalt);
            pst.setInt(3, userID);

            pst.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method is used to update the avatar filepath of a user
     * @param userID The user_id to update
     * @param newPath The new filepath to the avatar
     */
    public void updateAvatar(int userID, String newPath)
    {
        Connection conn = null;
        PreparedStatement pst = null;

        try
        {
            conn = DriverManager.getConnection(url, db_user, db_password);

            pst = conn.prepareStatement("UPDATE user SET filepath = ? WHERE user_id = ?");
            pst.setString(1, newPath);
            pst.setInt(2, userID);

            pst.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public User getUser(String userName)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        int userID = -1;
        String passwordHash = null;
        String salt = null;
        String email = null;
        String avatarPath = null;

        try
        {
            conn = DriverManager.getConnection(url, db_user, db_password);

            pst = conn.prepareStatement("SELECT user_id, password, salt, email, filepath FROM user WHERE user_name = ?");
            pst.setString(1, userName);

            rs = pst.executeQuery();

            if(rs.next())
            {
                userID = rs.getInt("user_id");
                passwordHash = rs.getString("password");
                salt = rs.getString("salt");
                email = rs.getString("email");
                avatarPath = rs.getString("filepath");
    
                user = new User(userID, userName, passwordHash, salt, email, avatarPath);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return user;
    }

    public String[] getHashSaltPair(String userName)
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String hashSaltPair[] = new String[2];

        try
        {
            conn = DriverManager.getConnection(url, db_user, db_password);

            pst = conn.prepareStatement("SELECT password, salt FROM user WHERE user_name = ?");
            pst.setString(1, userName);

            rs = pst.executeQuery();
            
            rs.next();

            hashSaltPair[0] = rs.getString("password");
            hashSaltPair[1] = rs.getString("salt");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            try
            {
                if(pst != null)
                {
                    pst.close();
                }
                if(conn != null)
                {
                    conn.close();
                }
                if(rs != null)
                {
                    rs.close();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return hashSaltPair;
    }
}
