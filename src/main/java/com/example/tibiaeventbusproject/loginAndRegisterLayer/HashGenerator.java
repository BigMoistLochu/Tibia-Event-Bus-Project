package com.example.tibiaeventbusproject.loginAndRegisterLayer;



import com.example.tibiaeventbusproject.loggingInformationLayer.LoggerUtil;
import org.slf4j.LoggerFactory;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HashGenerator {


    private static Logger logger = LoggerUtil.getLogger(HashGenerator.class);


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
                logger.log(Level.SEVERE,"Bad Algoryth choosen");
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
