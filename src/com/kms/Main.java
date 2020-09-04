package com.kms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean isValidSSN(String str)
    {
        // Regex to check SSN (Social Security Number).
        String regex = "^(?!666|000|9\\d{2})\\d{3}(?!00)\\d{2}(?!0{4})\\d{4}$";

        Pattern p = Pattern.compile(regex);

        if (str == null) {
            return false;
        }

        Matcher m = p.matcher(str);

        return m.matches();
    }


    public static void main(String[] args) {
        Integer count = 0;
        SocialSecurityNumber ssnGen = new SocialSecurityNumber();
        while (true) {
            String ssn = ssnGen.GenerateInvaildSSN(true, true, true);
            if(isValidSSN(ssn))
                count++;
            else
                break;
        }

        System.out.println(count);
    }
}
