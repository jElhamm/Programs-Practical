/**
 * You can use this program to generate random passwords.
 **/

import java.util.Scanner;
import java.security.SecureRandom;

public class passwordGenerator 
{
    public static void main( String[] args )
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("\n---------------------------------------------------------------");
        System.out.print("   Hello, please enter the length of the password: ");
        int passwordLength = cin.nextInt();

        String numeric   = "0123456789";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String special   = "()<>[]{}/!?*@#&$^%_-+=";  
        String password  = "";
        SecureRandom newSecureRandom = new SecureRandom();

        System.out.println("---------------------------------------------------------------");
        System.out.println("|  Choose the types of characters for the password:           |");
        System.out.println("|  1- Lowercase letters                                       |");
        System.out.println("|  2- Uppercase letters                                       |");
        System.out.println("|  3- Numeric digits                                          |");
        System.out.println("|  4- Special characters                                      |");
        System.out.println("---------------------------------------------------------------");
        System.out.print("   Enter your choices: ");
        String choices = cin.next();
        String select = "";

        if (choices.contains( "1")) {
            select += newSecureRandom;
        }
        if (choices.contains("2")) {
            select += newSecureRandom;       
        }
        if (choices.contains("3")) {
            select += newSecureRandom;
        }
        if (choices.contains("4")) {
            select += newSecureRandom;
        }
        for (int i = 0; i < passwordLength; i++) {
            int random = newSecureRandom.nextInt(select.length());
            password += select.charAt(random);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("*** Generated Password: " + password);
        System.out.println("---------------------------------------------------------------\n");
    }
}