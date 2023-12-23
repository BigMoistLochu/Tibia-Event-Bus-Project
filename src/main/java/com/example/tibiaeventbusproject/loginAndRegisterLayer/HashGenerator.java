package com.example.tibiaeventbusproject.loginAndRegisterLayer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashGenerator {


    private static Logger logger = LoggerFactory.getLogger(HashGenerator.class);


    public static String getHashPasswordUsingMD5(String email)
    {
        if(email!=null)
        {
            try {
                String hashThePassword = new BigInteger(1, MessageDigest.getInstance("MD5").
                        digest(email.getBytes())).toString(16);

                return hashThePassword;
            }
            catch (NoSuchAlgorithmException e)
            {
                logger.error("error with algorithm, MD5 not found", e);
            }
        }
        return null;
    }

    public static boolean verifyHashPassword(String hashedemail,String hash)
    {
        if(hashedemail!=null&&hash!=null)
        {
            return hash.equals(hashedemail);
        }
        return false;
    }






}
