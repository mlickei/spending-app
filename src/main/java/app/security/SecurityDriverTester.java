package app.security;

/**
 * Created by anthony on 7/21/15.
 */
public class SecurityDriverTester {

    public static void main(String args[])
    {
        PasswordHasher ph = new PasswordHasher();

        String pw = "GAAY";
        String old_salt = "0D0DDF6995330E858271761B308AAE340BCE93BF2A59F166A497C8A6119448C07B22F377508215451188DB256AB4E104D539AF537B211ED46A6EC6F0D39AD3C8BDF7FC9AB3D7F408AD69B48242CAE7BFEE5485421E8CB9EEC7780C813009ED326176B5740979A44E5B9CB5F618E0CC2E9CE26FF28964CBF850BF102AE4EED855";

        ph.hashPassword(pw, old_salt);

        String hash = ph.getHash();
        String salt = ph.getSalt();

        System.out.println("Password: " + pw);
        System.out.println("Hash: " + hash);
        System.out.println("Salt: " + salt);
    }
}
