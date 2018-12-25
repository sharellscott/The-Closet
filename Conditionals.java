/* TheCloset
 * Conditionals.java
 * Sharell Scott
 * sscott05
 * Final Project
 * Section 1 */

//CL
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Conditionals
{
  //these objects are used to call methods within the ClosetDisplay
  // and ClosetMethodsclass
  ClosetDisplay display = new ClosetDisplay();
  ClosetMethods helper = new ClosetMethods();
  
  //this method is called when the user inputs 1 in the beginning and then
  //enters no as a confirmation
  public void ifnot1(String[]list, String[]list2, PrintWriter w, PrintWriter m, PrintWriter u) //MYMETH
  {
    String cancel_continue = JOptionPane.showInputDialog("Would you like to cancel this request? (cancel or continue)");
    
    //protects against bad input
    while (!(cancel_continue.compareToIgnoreCase("cancel")==0 ||
             cancel_continue.compareToIgnoreCase("continue")==0))
    {
      cancel_continue = JOptionPane.showInputDialog("Please enter either 'cancel' or 'continue'");
    }
    
    //if the user enters cancel, they are told goodbye and the system shuts down
    if (cancel_continue.compareToIgnoreCase("cancel")==0)
    {
      JOptionPane.showMessageDialog(null, "No problem! Enjoy your day!");
    }
    
    //if the user enters continue, they are once again asked about which
    //gender, item, and color they prefer
    else if (cancel_continue.compareToIgnoreCase("continue")==0)
    {
      
      display.showitems();
      String item = JOptionPane.showInputDialog("What piece of clothing are you adding? (Enter clothing type, ex. 'Shirt')");
      int n = search(list2, item);
      
      while (n == -1)
      {
        //this is used to show their options of clothing items
        display.showitems();
        item = JOptionPane.showInputDialog("Please enter an item from the list previously shown.");
        
        //this is used to see if that item of clothing is there
        n = search(list2, item);
      }
      
      String gender = JOptionPane.showInputDialog("What is the gender of the clothing? (Women's men's, unisex)");
      
      //protects against bad input
      while (!(gender.compareToIgnoreCase("Women's")==0 || gender.compareToIgnoreCase("Men's")==0 ||
             gender.compareToIgnoreCase("unisex")==0))
      {
        gender = JOptionPane.showInputDialog("Please enter Women's, Men's, or unisex");
      }
      
      //used to show their options of colors
      display.showcolors();
      String color = JOptionPane.showInputDialog("What is the color of the clothing?");
      
      //used to check if the color is in the array
      int k = search(list, color);
      
      //protects against bad input. user is told to enter a valid color when the 
      //return value is -1 or if the spot is empty
      while (k == -1)
      {
        display.showcolors();
        color = JOptionPane.showInputDialog("Please enter a color from the list previously shown.");
        k = search(list, color);
      }
      
      String confirmation = JOptionPane.showInputDialog("You have added the " + color + " " + gender
                                                          + " " + item + ". Is this okay? (yes or no)");
      
      
      while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
      {
        confirmation = JOptionPane.showInputDialog("Please enter yes or no");
      }
      
      
      if (confirmation.compareToIgnoreCase("yes")==0)
      {
        if (gender.compareToIgnoreCase("women's")==0)
        {
          w.println("\n" + gender + " " + color + " " + item);
        }
        
        else if (gender.compareToIgnoreCase("men's")==0)
        {
          m.println("\n" + gender + " " + color + " " + item);
        }
        
        else if (gender.compareToIgnoreCase("unisex")==0)
        {
          u.println("\n" + gender + " " + color + " " + item);
        }
        JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
      }
      
      //if the user enters no, they are told to start the app over if they want. 
      //their closet modifications are shown and the system shuts down
      else if (confirmation.compareToIgnoreCase("no")==0)
      {
        JOptionPane.showMessageDialog(null, "Sorry to hear that! If you would like to start over, "
                                        + "you will have to restart the app. Enjoy your day!");
      }
      
    }
  }
  
  //this method is called when the user inputs 2 in the beginning and then
  //enters no as a confirmation
  public void ifnot2(String[] list, String[] list2, PrintWriter w, PrintWriter m, PrintWriter u) //MYMETH
  {
    String cancel_continue = JOptionPane.showInputDialog("Would you like to cancel this request? (cancel or continue)");
    
    while (!(cancel_continue.compareToIgnoreCase("cancel")==0 ||
             cancel_continue.compareToIgnoreCase("continue")==0))
    {
      cancel_continue = JOptionPane.showInputDialog("Please enter either 'cancel' or 'continue'");
    }
    
    
    if (cancel_continue.compareToIgnoreCase("cancel")==0)
    {
      JOptionPane.showMessageDialog(null, "No problem! Enjoy your day!");
    }
    else if (cancel_continue.compareToIgnoreCase("continue")==0)
    {
      display.showitems();
      String item = JOptionPane.showInputDialog("What are you adding to the closet? (Enter clothing type)");
      
      int n = search(list2, item);
      
      while (n == -1)
      {
        display.showitems();
        item = JOptionPane.showInputDialog("Please enter an item from the list previously shown.");
        n = search(list2, item);
      }
      
      
      String gender = JOptionPane.showInputDialog("What is the gender of the clothing? (Women�s, men�s or unisex)");
      
      while (!(gender.compareToIgnoreCase("Women's")==0 || gender.compareToIgnoreCase("Men's")==0
              || gender.compareToIgnoreCase("Unisex")==0))
      {
        gender = JOptionPane.showInputDialog("Please enter Women's, Men's, or unisex");
      }
      
      display.showcolors();
      String color = JOptionPane.showInputDialog("What is the color of the clothing?");
      
      int k = search(list, color);
      
      while (k == -1)
      {
        display.showcolors();
        color = JOptionPane.showInputDialog("Please enter a color from the list previously shown.");
        k = search(list, color);
      }
      
      String confirmation = JOptionPane.showInputDialog("You are adding a new " + color + " " + gender + " " + item 
                                                          + " to the closet. Is this okay? (Yes or no)");
      
      while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
      {
        confirmation = JOptionPane.showInputDialog("Please enter yes or no");
      }
      
        if (confirmation.compareToIgnoreCase("yes")==0)
      {
        if (gender.compareToIgnoreCase("women's")==0)
        {
          w.print("\n*NEW* " + gender + " " + color + " " + item);
        }
        
        else if (gender.compareToIgnoreCase("men's")==0)
        {
          m.print("\n*NEW* " + gender + " " + color + " " + item);
        }
        
        else if (gender.compareToIgnoreCase("unisex")==0)
        {
          u.print("\n*NEW* " + gender + " " + color + " " + item);
        }
        JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
      }
      
      else if (confirmation.compareToIgnoreCase("no")==0)
      {
        JOptionPane.showMessageDialog(null, "Sorry to hear that! If you would like to start over, "
                                        + "you will have to restart the app. Enjoy your day!");
        
      }
    }
  }
  
  //this method is called in the TheClosetHelper class when the user picks "randomize"
  public void menElseIf(String[] list, String[] list2, String[] list3, int w, int m, int u,
                        Scanner a, Scanner b, Scanner c) //MYMETH
  {
    //random generator used to randomly select an item off of a list based on the gender they entered
    Random rand = new Random(); //RANDOM
    int randomitem = rand.nextInt(m); //RANDOM
    
    String confirmation = JOptionPane.showInputDialog("I've picked a " + list2[randomitem]
                                                        + " for you. Is that okay? (yes or no)");
    
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    }
    
    
    if (confirmation.compareToIgnoreCase("yes")==0)
    {
      JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
    
    else if (confirmation.compareToIgnoreCase("no")==0)
    {
      String cancel_continue = JOptionPane.showInputDialog("Would you like to cancel or continue " 
                                                             + "(enter cancel or continue)");
      
      while (!(cancel_continue.compareToIgnoreCase("cancel")==0 || 
               cancel_continue.compareToIgnoreCase("continue")==0))
      {
        cancel_continue = JOptionPane.showInputDialog("Please enter either cancel or continue.");
      }
      
      if (cancel_continue.compareToIgnoreCase("cancel")==0)
      {
        JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
      }
      
      else if (cancel_continue.compareToIgnoreCase("continue")==0)
      {
        String random_custom2 = JOptionPane.showInputDialog("Would you like me to pick a random "
                                                              + "outfit for you or would you like to pick one for yourself? "
                                                              + "Enter 'I'll pick' or 'randomize'");
        
        while (!(random_custom2.compareToIgnoreCase("randomize")==0 ||
                 random_custom2.compareToIgnoreCase("I'll pick")==0))
        {
          random_custom2 = JOptionPane.showInputDialog("Please enter either 'randomize' or "
                                                         + "I'll pick.");
        }
        
        if (random_custom2.compareToIgnoreCase("I'll pick")==0)
        {
          String result =  "";
          for (String every : list2)
          {
            result += every + "\n";
          }
          String answer = JOptionPane.showInputDialog("Here's what you have: \n" + result
                                                        + "Please enter your choice.");
          
          int unisexindex = search(list2, answer);
          
          while (unisexindex == -1)
          {
            answer = JOptionPane.showInputDialog("Please enter something that's on the list\n" + result);
            unisexindex = search(list2, answer);
          }
          JOptionPane.showMessageDialog(null, "You have picked the men's " + answer + ". Enjoy your Day!");
        }
        
        
        else if (random_custom2.compareToIgnoreCase("randomize")==0)
        {
          int randomitem2 = rand.nextInt(m); 
          String confirmation2 = JOptionPane.showInputDialog("I've picked a " + list2[randomitem2]  
                                                               + " for you. Is that okay? (yes or no)");
          
          while (!(confirmation2.compareToIgnoreCase("yes")==0 || confirmation2.compareToIgnoreCase("no")==0))
          {
            confirmation2 = JOptionPane.showInputDialog("Please enter yes or no");
          }
          
          if (confirmation2.compareToIgnoreCase("yes")==0) 
          {
            
            JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
          }
          
          else if (confirmation2.compareToIgnoreCase("no")==0)
          {
            JOptionPane.showMessageDialog(null, "Sorry to hear that! If you would like to start over, "
                                            + "you will have to restart the app. Enjoy your day!");
          }
        }
      }
    }
  }
  
  //this method is called in the TheClosetHelper class when the user picks randomize
  public void womenElseIf(String[] list, String[] list2, String[] list3, int w, int m, int u,
                          Scanner a, Scanner b, Scanner c) //MYMETH
  {
    //this random generator is used to randomly select an item from a list based on the gender they entered
    Random rand = new Random(); //RANDOM
    int randomitem = rand.nextInt(w); //RANDOM
    String confirmation = JOptionPane.showInputDialog("I've picked a " + list[randomitem]
                                                        + " for you. Is that okay? (yes or no)");
    
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    }
    
    if (confirmation.compareToIgnoreCase("yes")==0)
    {
      JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
    
    else if (confirmation.compareToIgnoreCase("no")==0)
    {
      String cancel_continue = JOptionPane.showInputDialog("Would you like to cancel or continue " 
                                                             + "(enter cancel or continue)");
      
      while (!(cancel_continue.compareToIgnoreCase("cancel")==0 || 
               cancel_continue.compareToIgnoreCase("continue")==0))
      {
        cancel_continue = JOptionPane.showInputDialog("Please enter either cancel or continue.");
      }
      
      if (cancel_continue.compareToIgnoreCase("cancel")==0)
      {
        JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
      }
      
      else if (cancel_continue.compareToIgnoreCase("continue")==0)
      {
        String random_custom2 = JOptionPane.showInputDialog("Would you like me to pick a random "
                                                              + "outfit for you or would you like to pick one for yourself? "
                                                              + "Enter 'I'll pick' or 'randomize'");
        
        while (!(random_custom2.compareToIgnoreCase("I'll pick")==0 ||
                 random_custom2.compareToIgnoreCase("randomize")==0))
        {
          random_custom2 = JOptionPane.showInputDialog("Please enter either 'I'll pick' or 'randomize'.");
        }
        
        if (random_custom2.compareToIgnoreCase("I'll pick")==0)
        {
          String result =  "";
          for (String every : list)
          {
            result += every + "\n";
          }
          String answer = JOptionPane.showInputDialog("Here's what you have: \n" + result
                                                        + "Please enter your choice.");
          
          int unisexindex = search(list, answer);
          
          while (unisexindex == -1)
          {
            answer = JOptionPane.showInputDialog("Please enter something that's on the list\n" + result);
            unisexindex = search(list, answer);
          }
          JOptionPane.showMessageDialog(null, "You have picked the Women's " + answer + ". Enjoy your Day!");
        }
        
        else if (random_custom2.compareToIgnoreCase("randomize")==0)
        {
          int randomitem2 = rand.nextInt(w);
          String confirmation2 = JOptionPane.showInputDialog("I've picked a " + list[randomitem2]  
                                                               + " for you. Is that okay? (yes or no)");
          
          while (!(confirmation2.compareToIgnoreCase("yes")==0 || confirmation2.compareToIgnoreCase("no")==0))
          {
            confirmation2 = JOptionPane.showInputDialog("Please enter yes or no");
          }
          
          if (confirmation2.compareToIgnoreCase("yes")==0) 
          {
            
            JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
          }
          
          else if (confirmation2.compareToIgnoreCase("no")==0)
          {
            JOptionPane.showMessageDialog(null, "Sorry to hear that! If you would like to start over, "
                                            + "you will have to restart the app. Enjoy your day!");
          }
          
        }
      }
    }
  }
  
  //this method is called in the TheClosetHelper class when the user picks randomize
  public void unisexElseIf(String[] list, String[] list2, String[] list3, int w, int m, int u, Scanner a,
                           Scanner b, Scanner c) //MYMETH
  {
    //random generator used to randomly selct an item from the list dependent on the gender they entered
    Random rand = new Random(); //RANDOM
    int randomitem = rand.nextInt(u); //RANDOM
    String confirmation = JOptionPane.showInputDialog("I've picked a " + list3[randomitem]
                                                        + " for you. Is that okay? (yes or no)");
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    }
    
    if (confirmation.compareToIgnoreCase("yes")==0)
    {
      JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
    
    else if (confirmation.compareToIgnoreCase("no")==0)
    {
      String cancel_continue = JOptionPane.showInputDialog("Would you like to cancel or continue " 
                                                             + "(enter cancel or continue)");
      
      while (!(cancel_continue.compareToIgnoreCase("cancel")==0 || 
               cancel_continue.compareToIgnoreCase("continue")==0))
      {
        cancel_continue = JOptionPane.showInputDialog("Please enter either cancel or continue.");
      }
      
      if (cancel_continue.compareToIgnoreCase("cancel")==0)
      {
        JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
      }
      
      else if (cancel_continue.compareToIgnoreCase("continue")==0)
      {
        String random_custom2 = JOptionPane.showInputDialog("Would you like me to pick a random "
                                                              + "outfit for you or would you like to pick one for yourself? "
                                                              + "Enter 'I'll pick' or 'randomize'");
        
        while (!(random_custom2.compareToIgnoreCase("I'll pick")==0 ||
                 random_custom2.compareToIgnoreCase("randomize")==0))
        {
          random_custom2 = JOptionPane.showInputDialog("Please enter either 'I'll pick' or 'randomize'.");
        }
        
        
        if (random_custom2.compareToIgnoreCase("I'll pick")==0)
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
          JOptionPane.showMessageDialog(null, "You have picked the unisex " + answer + ". Enjoy your Day!");
        }
        
        else if (random_custom2.compareToIgnoreCase("randomize")==0)
        {
          int randomitem2 = rand.nextInt(u);
          String confirmation2 = JOptionPane.showInputDialog("I've picked a " + list3[randomitem2]  
                                                               + " for you. Is that okay? (yes or no)");
          
          while (!(confirmation2.compareToIgnoreCase("yes")==0 || confirmation2.compareToIgnoreCase("no")==0))
          {
            confirmation2 = JOptionPane.showInputDialog("Please enter yes or no");
          }
          
          
          if (confirmation2.compareToIgnoreCase("yes")==0) 
          {
            
            JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
          }
          
          else if (confirmation2.compareToIgnoreCase("no")==0)
          {
            JOptionPane.showMessageDialog(null, "Sorry to hear that! If you would like to start over, "
                                            + "you will have to restart the app. Enjoy your day!");
          }
        }
      }
    }
  }
  
  //this method is called in the TheClosetHelper class when the user enters
  //continue
  public void add2(String[] colors2, String[] clothes2, PrintWriter a) //MYMETH
  {
    display.showitems();
    String item = JOptionPane.showInputDialog("What piece of clothing are you "
                                                + "adding to the list? (ex. Shirt, pants)");
    int n = search(clothes2, item);
    
    while (n == -1)
    {
      display.showitems();
      item = JOptionPane.showInputDialog("Please enter an item from the list previously shown.");
      n = search(clothes2, item);
    }
    
    
    String gender = JOptionPane.showInputDialog("What is the gender of the clothing? (Women�s, men�s or unisex)");
    
    while (!(gender.compareToIgnoreCase("Women's")==0 || gender.compareToIgnoreCase("Men's")==0
            || gender.compareToIgnoreCase("unisex")==0))
    {
      gender = JOptionPane.showInputDialog("Please enter Women's, Men's, or unisex");
    }
    
    
    display.showcolors();
    String color = JOptionPane.showInputDialog("What is the color of the clothing?");
    
    int k = search(colors2, color);
    
    while (k == -1)
    {
      display.showcolors();
      color = JOptionPane.showInputDialog("Please enter a color that is on the list.");
      k = search(colors2, color);
    }
    
    String confirmation = JOptionPane.showInputDialog("You are adding a " + gender + " " + color  
                                                        + " " + item + " to the laundry list. Is that okay?");
    
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    }
    
    if (confirmation.compareToIgnoreCase("yes")==0)
    {
      a.print("\n" + gender + " " + color + " " + item);
      JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
    
    //if the user enters no, they are told to restart the app and the system shuts down
    else if (confirmation.compareToIgnoreCase("no")==0)
    {
      JOptionPane.showMessageDialog(null, "Sorry to hear that! If you would like to start over, "
                                      + "you will have to restart the app. Enjoy your day!");
    } 
  }
  
  //this method is used to search an array of colors and clothing items
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
  
  public static void sort (Gender[] list) //SORT
  {
    Gender temp = new Gender("");
    int min;
    
    for(int index = 0; index<list.length-1; index++)
    {
      min = index;
      for (int j = index+1; j<list.length; j++)
        if (list[j].compareTo(list[min])<0)
        min = j;
      
      temp = list[min];
      list[min] = list[index];
      list[index] = temp;
    }
  }
  
}



