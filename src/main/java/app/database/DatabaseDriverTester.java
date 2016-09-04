package app.database;

/**
 * Created by anthony on 7/20/15.
 */
public class DatabaseDriverTester {

    public static void main(String args[])
    {
        System.out.println("Testing database...");

        UserDatabaseManager.initializeStrings();
        UserDatabaseManager.insertUser("Test","test","test","test","test");
    }
}
