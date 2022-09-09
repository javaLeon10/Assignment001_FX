package com.example.pc2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility extends Object {

    public static String str = " " ;

    public PasswordCheckerUtility() {
    }

    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {

        if (!password.equals(passwordConfirm)) throw new UnmatchedException();

    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        if (password.equals(passwordConfirm)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidLength(String password) throws LengthException {

        if (password.length() <= 6) {
            throw new LengthException("The password must be at least 6 characters long");
        } else {
            return true;
        }
    }

        public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
            int sz = password.length();
            boolean ans=false;
            char[] array = new char[sz];
            array = password.toCharArray();

            int counter = 0;
            for (int k = 0; k < array.length - 3; k++) {
                if ((array[k] == array[k + 1]) && (array[k] == array[k + 2])) counter++;
            }
            if (counter>0) throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
            //if (counter > 0) return false;
            if(counter==0) ans=true;
            return ans;
        }


    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        Boolean b1 = false;
        String regular1 = "[A-Z]";

        Pattern p = Pattern.compile(regular1);

        Matcher m1 = p.matcher(password);
        b1 = m1.find();
       if(b1==false) throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");

        return b1;


    }
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        Boolean b1 = false;
        String regular1 = "[a-z]";

        Pattern p = Pattern.compile(regular1);

        Matcher m1 = p.matcher(password);
        b1 = m1.find();
        if (b1==false) throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");

        return b1;



    }


    public static boolean hasDigit(String password) throws NoDigitException{
        Boolean b1 = false;
        String regular1 = "[0-9]";

        Pattern p = Pattern.compile(regular1);

        Matcher m1 = p.matcher(password);
        b1 = m1.find();
        if (b1==false) throw new NoDigitException("The password must contain at least one digit");

        return b1;

    }
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Boolean b1 = false;
        String regular1 = "[^A-Za-z0-9]";

        Pattern p = Pattern.compile(regular1);

        Matcher m1 = p.matcher(password);
        b1 = m1.find();

        if (b1==false) throw new NoSpecialCharacterException("The password must contain at least one special character ");

        return b1;

    }
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
       Boolean b1 = false;

        if (hasSpecialChar(password) == false ) throw new NoSpecialCharacterException("The password must contain at least one special character ");
        if (hasDigit(password) == false) throw new NoDigitException("The password must contain at least one digit");
        if (hasLowerAlpha(password) == false) throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        if (hasUpperAlpha(password) == false) throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        if (NoSameCharInSequence(password) == false) throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
        if (isValidLength(password) == false) throw new LengthException("The password must be at least 6 characters long");
        return true;
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException,LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        if (hasSpecialChar(password) == false ) throw new NoSpecialCharacterException("The password must contain at least one special character ");
        if (hasDigit(password) == false) throw new NoDigitException("The password must contain at least one digit");
        if (hasLowerAlpha(password) == false) throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        if (hasUpperAlpha(password) == false) throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        if (NoSameCharInSequence(password) == false) throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
        if (isValidLength(password) == false) throw new LengthException("The password must be at least 6 characters long");

        //if (!((password.length() >= 6) && (password.length() <= 9))) throw new WeakPasswordException("The password is OK, but weak - it contains fewer than 10 characters");
        if ((isValidLength(password) == true) && (password.length() <= 10)) {

            System.out.println("Length is "+password.length());
            throw new WeakPasswordException("The password is OK, but weak - it contains fewer than 10 characters");
        }

return true;
    }
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
        ArrayList newlist = new ArrayList<String>(10);
        int k = passwords.size();
        for (int i=0; i < k; i++) {
            try {
                isValidPassword(passwords.get(i));
            } catch (LengthException e) {
                newlist.add(passwords.get(i)+ "#->"+ e.getMessage());
                //throw new RuntimeException(e);
            } catch (NoUpperAlphaException e) {
                newlist.add(passwords.get(i)+ "#->"+ e.getMessage());
                //throw new RuntimeException(e);
            } catch (NoLowerAlphaException e) {
                newlist.add(passwords.get(i)+ "#->"+ e.getMessage());
                //throw new RuntimeException(e);
            } catch (NoDigitException e) {
                newlist.add(passwords.get(i)+ "#->"+ e.getMessage());
                //throw new RuntimeException(e);
            } catch (NoSpecialCharacterException e) {
                newlist.add(passwords.get(i)+ "#->"+ e.getMessage());
                //throw new RuntimeException(e);
            } catch (InvalidSequenceException e) {
                newlist.add(passwords.get(i)+ "#->"+ e.getMessage());
                //throw new RuntimeException(e);
            }
        }
return newlist;
    }

}
