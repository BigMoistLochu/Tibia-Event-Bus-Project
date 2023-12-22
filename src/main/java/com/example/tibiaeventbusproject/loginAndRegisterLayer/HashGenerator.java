package com.example.tibiaeventbusproject.loginAndRegisterLayer;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashGenerator {


    //potrzebujesz HashGenerator oraz HashVeryfikator

    //chcesz uzywac tej funkcji tylko do hashowania wiec nie potrzebujesz kilku instancji

    public static String getBcryptHashString(String email)
    {
        //$2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6 przykladowy hash
        if(email instanceof String && email!=null)
        {
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, email.toCharArray());
            return bcryptHashString;
        }

        return null;
    }

    public static boolean verifyBcryptHashString(String email,String bcryptHashString)
    {
        BCrypt.Result result = BCrypt.verifyer().verify(email.toCharArray(), bcryptHashString);
        return result.verified;
    }






}
