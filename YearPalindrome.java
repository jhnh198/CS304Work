package bookfiles.ch05.palindromes;

import java.util.Scanner;

public class YearPalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year to evaluate in the form of (YYYY) >> ");
        String yearString = sc.nextLine();
        
        System.out.print("Is this a valid palindromic year? ");
        if(isYearAPalindrome(yearString))
            System.out.println(" yes");
        else System.out.println(" no");
    }
    //auxilliary methods
    public static boolean isYearAPalindrome(String year){
        //precondition : year must be a string of length 4
        char[] yearChars = year.toCharArray();
        
        //build a palindromic day / month from the year string 
        String monthString = "";
        monthString += yearChars[3];
        monthString += yearChars[2];
        
        String dayString = "";
        dayString += yearChars[1];
        dayString += yearChars[0];
        
        boolean isYearAP = false;
        boolean isLeapYear = isLeapYear(year);
        
        int daysInt = Integer.parseInt(dayString);        
        int monthInt = Integer.parseInt(monthString);
        
        //check if days is valid for month and Leap Year
        if((monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 ||
                monthInt == 8 || monthInt == 10 || monthInt == 12) && daysInt <= 31){
                isYearAP = true;
        }
        else if((monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) && (daysInt <= 30)){
                isYearAP = true;
        }
        else if((isLeapYear && monthInt == 2 && daysInt <= 29) || (monthInt == 2 && daysInt <= 28))     
                isYearAP = true;
        
        return isYearAP;
    }
    public static boolean isLeapYear(String year){
        int yearInt = Integer.parseInt(year);
        if(yearInt % 4 == 0 || yearInt % 400 == 0){
            return true;
        }
        if((yearInt % 100 == 0) && (yearInt % 400 != 0))
        {
            return false;
        }
        
        return false;
    }
}
