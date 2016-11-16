// Assignment #: 11
// Arizona State University CSE205
// Name: Trenton Gailey
// StudentID: 1211386693
// Lecture: Monday Wednesday Friday 9:40 - 10:30
// Description: Checks each part of an entered string (can be separated by #) and sees
//				if given part is a palindrome. If not, the display will tell the user
//				what characters do not match

import java.util.Stack;
import java.util.LinkedList;

public class PalindromeChecker
 {
  private Stack<Character> charStack; //stack can contain characters
  private LinkedList<Character> charQueue; //queue can contain characters
  private String inputString;

  //Constructor to initialize member variables
  public PalindromeChecker(String inputString)
    {
        charStack = new Stack<Character>();
        charQueue = new LinkedList<Character>();
        this.inputString = inputString;
    }

  //The check method checks if an input string is a palindrome or not,
  //and prints its result.
  public void check()
   {
     boolean success = true; //success indicates whether palindrome or not
     boolean done = false; //it is used to stop the while loop
     int i = 0; //i wil be used as an index of the inputString

     while (!done)
      {
         //until the end of inputString or it encounters '#' character
         //take each character in inputString from left and add it to charStack and charQueue
          while (i != inputString.length() && inputString.charAt(i) != '#') {
        	  charStack.push(inputString.charAt(i));
        	  charQueue.add(inputString.charAt(i));
        	  i++;
          }
          
         //prints out the substring extracted from the input string using queue's toString method
         System.out.print("The input " + charQueue.toString());
          
          //until the charQueue or charStack becomes empty
          //remove a character from each of charStack and charQueue, and check if they are same.
          //If they are different, then print out the approproate message (" is not a palindrome\n")
          //and also print which first set of two characters are different
          //("The characters ' ' and ' ' do not match\n\n") -- note that you need to print
          //two such characters inbetween ' '
          //Also set success to false, so that the following "if" statement will be skipped
         
         while (!charStack.isEmpty()) {
        	 char tempStackChar = charStack.pop();
        	 char tempQueueChar = charQueue.remove();
        	 if (tempStackChar != tempQueueChar && success) {
        		 success = false;
        		 System.out.print(" is not a palindrome\n");
        		 System.out.print("The characters '" + tempQueueChar + "' and '" + tempStackChar + "' do not match\n\n");
        	 }
         }
          

        if (success == true)
            System.out.print(" is a palindrome\n\n");
        
        //i reaches the end of string, it is done processing the inputString
        if (i == inputString.length())
            done = true;
        else
        {
            i++;
            success = true; //set it back to true for the next substring to check
        }
      } //end of while loop
    } //end of check( ) method
 } // end of PalindromeChecker class
