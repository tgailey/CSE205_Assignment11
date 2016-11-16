// Assignment #: 11
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
// Description: Assignment 11 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//      enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;

public class Assignment11
 {
  public static void main (String[] args) throws IOException
   {
       char input1;
       String line = new String();

       printMenu();

       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader stdin = new BufferedReader(isr);

       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           // matches one of the case statements
           switch (input1)
            {
             case 'E':   //Enter Problem parameters
               System.out.print("Please enter a string to check:\n");
               String inputString = stdin.readLine().trim();
  
               //create an object of PalindromeChecker using the input string
               PalindromeChecker checker = new PalindromeChecker(inputString);
               checker.check();
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
          }
         else
          {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
   }


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "E\t\tEnter String\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}