/* TheCloset
 * TheClosetHelper.java
 * Sharell Scott
 * sscott05
 * Final Project
 * Section 1 */

//CL
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class TheClosetHelper 
{
  
  //objects used to call methods in the Conditionals class
  Conditionals conditions = new Conditionals();
  
  //objects used to call methods in the ClosetMethods
  //and ClosetDisplay class
  ClosetDisplay display = new ClosetDisplay();
  ClosetMethods helper = new ClosetMethods();
  
  //method called in main when the user enters men's for option 3
  public void men(String[] list, String[] list2, String[] list3, int womenRange, int menRange, int uniRange, 
                  Scanner w, Scanner m, Scanner u)  //MYMETH
  {
    //the user enters either I'll pick or randomize as a way to pick outfits
    String random_custom = JOptionPane.showInputDialog("Would you like me to pick a random"
                                                         + " outfit for you or would you like to pick one for yourself? "
                                                         + "Enter 'I'll pick' or 'randomize'");
    
    //protects against bad input
    while (!(random_custom.compareToIgnoreCase("randomize")==0 ||
             random_custom.compareToIgnoreCase("I'll pick")==0))
    {
      random_custom = JOptionPane.showInputDialog("Please enter either 'randomize' or "
                                                    + "I'll pick.");
    }
    
    //if the user enters I'll pick, they are shown what they have from the 
    //Array that corresponds to the gender. They then enter which thing they want
    //and if it's on the list, they are told what they picked and then the program ends. If not, 
    //they enter a while loop
    if (random_custom.compareToIgnoreCase("I'll pick")==0)
    {
      String result =  "";
      for (String every : list2)
      {
        result += every + "\n";
      }
      String answer = JOptionPane.showInputDialog("Here's what you have: \n" + result
                                 + "Please enter your choice.");
      
      int menindex = search(list2, answer);
      
      while (menindex == -1)
      {
        answer = JOptionPane.showInputDialog("Please enter something that's on the list\n" + result);
        menindex = search(list2, answer);
      }
      JOptionPane.showMessageDialog(null, "You have picked the " + answer + ". Enjoy your Day!");
    }
    
    //otherwise, if the user picks random a method in Conditionals is called
    else if (random_custom.compareToIgnoreCase("randomize")==0)
    {
      conditions.menElseIf(list, list2, list3, womenRange, menRange, uniRange, w, m, u);
    }
  }
  
  //method called in main when the user picks women's for option 3
  public void women(String[] list, String[] list2, String[] list3, int womenRange, int menRange, int uniRange, 
                    Scanner w, Scanner m, Scanner u) //MYMETH
  {
    String random_custom = JOptionPane.showInputDialog("Would you like me to pick a random"
                                                         + " outfit for you or would you like to pick one for yourself? "
                                                         + "Enter 'I'll pick' or 'randomize'");
    
    while (!(random_custom.compareToIgnoreCase("randomize")==0 ||
             random_custom.compareToIgnoreCase("I'll pick")==0))
    {
      random_custom = JOptionPane.showInputDialog("Please enter either 'randomize' or "
                                                    + "I'll pick.");
    }
    
    
    if (random_custom.compareToIgnoreCase("I'll pick")==0)
    {
      String result =  "";
      for (String every : list)
      {
        result += every + "\n";
      }
      String answer = JOptionPane.showInputDialog("Here's what you have: \n" + result
                                 + "Please enter your choice.");
      
      int womenindex = search(list, answer);
      
      while (womenindex == -1)
      {
        answer = JOptionPane.showInputDialog("Please enter something that's on the list\n" + result);
        womenindex = search(list, answer);
      }
      JOptionPane.showMessageDialog(null, "You have picked the " + answer + ". Enjoy your Day!");
    }
    
    else if (random_custom.compareToIgnoreCase("randomize")==0)
    {
      conditions.womenElseIf(list, list2, list3, womenRange, menRange, uniRange, w, m, u);
    }
  }
  
  //method called in main when the user picks unisex in option 3
  public void unisex(String[] list, String[] list2, String[] list3, int womenRange, int menRange, int uniRange, 
                     Scanner w, Scanner m, Scanner u) //MYMETH
  {
    String random_custom = JOptionPane.showInputDialog("Would you like me to pick a random"
                                                         + " outfit for you or would you like to pick one for yourself? "
                                                         + "Enter 'I'll pick' or 'randomize'");
    
    while (!(random_custom.compareToIgnoreCase("randomize")==0 ||
             random_custom.compareToIgnoreCase("I'll pick")==0))
    {
      random_custom = JOptionPane.showInputDialog("Please enter either 'randomize' or "
                                                    + "I'll pick.");
    }
    
    if (random_custom.compareToIgnoreCase("I'll pick")==0)
    {
      String result =  "";
      for (String every : list3)
      {
        result += every + "\n";
      }
      String answer = JOptionPane.showInputDialog("Here's what you have: \n" + result
                                 + "Please enter your choice.");
      
      int unisexindex = search(list3, answer);
      
      while (unisexindex == -1)
      {
        answer = JOptionPane.showInputDialog("Please enter something that's on the list\n" + result);
        unisexindex = search(list3, answer);
      }
      JOptionPane.showMessageDialog(null, "You have picked the " + answer + ". Enjoy your Day!");
    }
    
    else if (random_custom.compareToIgnoreCase("randomize")==0)
    {
      conditions.unisexElseIf(list, list2, list3, womenRange, menRange, uniRange, w, m, u); 
    }
  }
  
  //method called in main when the user picks option 4
  //this method makes the the same actions as the methods option1helper 
  //and option2helper (of ClosetMethods)
  public void add(String[] list, String[] list2, PrintWriter laundry2) //MYMETH
  {
    display.showitems();
    String item = JOptionPane.showInputDialog("What piece of clothing are you "
                                                + "adding to the list? (ex. Shirt, pants)");
    int k = search(list2, item);
    
    while (k == -1)
    {
      display.showitems();
      item = JOptionPane.showInputDialog("Please enter an item from the list previously shown.");
      k = search(list2, item);
    }
    
    String gender = JOptionPane.showInputDialog("What is the gender of the clothing? (Women's, men's or unisex)");
    
    while (!(gender.compareToIgnoreCase("Women's")==0 || gender.compareToIgnoreCase("Men's")==0 
          || gender.compareToIgnoreCase("unisex")==0))
    {
      gender = JOptionPane.showInputDialog("Please enter Women's, Men's, or unisex");
    }
    
    display.showcolors();
    String color = JOptionPane.showInputDialog("What is the color of the clothing?");
    int n = search(list, color);
    
    while (n==-1)
    {
      display.showcolors();
      color = JOptionPane.showInputDialog("Please enter a color that is on the list.");
      n = search(list, color);
    }
    
    String confirmation = JOptionPane.showInputDialog("You are adding a " + gender + " " + color  
                                                        + " " + item + " to the laundry list. Is that okay?");
    
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    } 
    
    //if the user enters yes for confirmation, their selection is added to the Laundry List
    if (confirmation.compareToIgnoreCase("yes")==0)
    {
        laundry2.print("\n" + gender + " " + color + " " + item);
        JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
    //options for when the user enters no
    else if (confirmation.compareToIgnoreCase("no")==0)
    {
      String cancel_continue = JOptionPane.showInputDialog("Would you like to cancel or continue? "
                                                             + "(Enter 'cancel' or 'continue'");
      
      while (!(cancel_continue.compareToIgnoreCase("cancel")==0 ||
               cancel_continue.compareToIgnoreCase("continue")==0))
      {
        cancel_continue = JOptionPane.showInputDialog("Please enter either 'cancel' or 'continue'");
      }
      
      if (cancel_continue.compareToIgnoreCase("cancel")==0)
      {
        JOptionPane.showMessageDialog(null, "Great! Enjoy your Day!");
      }
      
      //if the user enters continue, a method of the Conditionals class will be called
      else if (cancel_continue.compareToIgnoreCase("continue")==0)
      {
          conditions.add2(list, list2, laundry2); 
      }
    }
  }
  
  //method used to search arrays of clothes and colors to protect against bad input
  public static int search(String[] theArray, String target)
  {
    for (int x = 0; x<theArray.length; x++)
    {
      if (theArray[x].compareToIgnoreCase(target)==0)
      {
        return x;
      }    
    }
    return -1;
  }
}


