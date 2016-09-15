package app.security;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for {@link PasswordHasher}.
 *
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
@Test(groups = {"unit"})
public class PasswordHasherTest
{
    
    String _pass = "m";
    String _salt = "D0A2C3830561BF82F4BE7FD873D527BD4006785199FA639D5BFB70E80B665EABD330506AFF626C50EC5CA8AEC784B151CB80723EE74DB8FB0E2E9255879842DD23DDF5A80DA35F9DBA1B47E92ABAB1FCF381AA550ABA565A5E1133C5F428EA4C30D9EA663443366A727DB02142825D02AD01C8AB57B136057733ED20106573F4";
    String _hashed = "42965D79540196F542613B5A3F5D406B378399E69F6F77A57DE57BA1A7FECB86E04ABFCCA521299C1C5A3DB8F2D0372575A5595F5A270FEF4B6DF202983C38BE";
    
    @Test
    public void testHashPassword() throws Exception
    {
        PasswordHasher hasher = new PasswordHasher();
        hasher.hashPassword(_pass, _salt);
        
        Assert.assertEquals(_hashed, hasher.getHash());
    }
    
    @Test
    public void testHashPasswordGenSalt() throws Exception
    {
        PasswordHasher hasher = new PasswordHasher();
        hasher.hashPassword(_pass);
    
        Assert.assertNotNull(hasher.getHash());
        Assert.assertNotNull(hasher.getSalt());
    }
    
    //TODO test hashpassword lower level method
    //TODO test parseHex method
}