/* TheCloset
 * ClosetMethods.java
 * Sharell Scott
 * sscott05
 * Final Project
 * Section 1 */

//CL
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;


public class ClosetMethods
{
  //object used to call methods within the ClosetDisplay class
  ClosetDisplay displayinfo = new ClosetDisplay();
  
  //this method is used in the beginning to welcome the user. 
  public String welcome(String[] greetings2, String[] names2, int greetingrange,
                        Scanner names3, Scanner greetings3) //MYMETH
  {
    Random rand = new Random();
    String name;
    int randomgreeting = 0;
    
    //the user is greeted with a random greeting message each time
    randomgreeting = rand.nextInt(greetingrange); //RAND
    JOptionPane.showMessageDialog(null, greetings2[randomgreeting]); //RAND
    
    name = JOptionPane.showInputDialog("Please enter your name to get started.");
    int nameIndex = search(names2, name);
    
    //if the user's name isn't within names.txt (the names array), then
    //their name is added to the file. Otherwise, they're only greeted
    if (nameIndex == -1)
    {
      JOptionPane.showMessageDialog(null, "Hello " + name + ". I see you've never been here before!");
    }
    
    else
    {
      JOptionPane.showMessageDialog(null, "Welcome back " + name + "!");
    }
    
    return name;
  }
  
  //method called in main that returns the number corresponding to the action they want
  public int action()
  {
    String temp;
    int option;
    //the user inputs a number that corresponds with the actions they want. they are not allowed 
    //to enter numbers that are not between 1-4, inclusive.
    temp = JOptionPane.showInputDialog("What would you like to do? (Enter the corresponding number) :"
                                         + "\n1) Put clothes back into the closet \n2)Add new clothes to the Closet"
                                         +  "\n3) Pick an outfit \n4) Add to laundry list"); 
    option = Integer.parseInt(temp);
    
    while ((option<=0 || option>4))
    {
      temp = JOptionPane.showInputDialog("Please enter a number bewtween 1-4, inclusive.");
      option = Integer.parseInt(temp);
    }
    return option;
  }
  
  //method called in main that handles all their selections and returns it as a value
  public String option1helper(Conditionals opt1, String[]colors2, String[] clothes2, 
                              Gender[] gendarray2)
  {
    displayinfo.showitems();
    String item = JOptionPane.showInputDialog("What piece of clothing are you adding?");
    
    //this is used to see if that item of clothing is there
    int n = search(clothes2, item);
    
    //if the search method returns a value of -1, the item they entered is not there, and they need
    //to try again
    while (n == -1)
    {
      displayinfo.showitems();
      item = JOptionPane.showInputDialog("Please enter an item from the list previously shown.");
      n = search(clothes2, item);
    }
    
    //this is used to sort their gender options in alphabetical order
    sort(gendarray2);
    String result = "";
    for (Gender every: gendarray2)
    {
      result +=every + "\n";
    }
    
    JOptionPane.showMessageDialog(null, "Your options for gender: \n"+ result);
    String gender = JOptionPane.showInputDialog("What is the gender of the clothing?");
    
    //this is used to search the information within the objects of the Gender class to see if 
    //any of it matches with the user's input
    int gen = searchObject(gendarray2, new Gender(gender));
    
    //if searchObject returns a value of -1, the user is asked to input a proper answer
    while (gen == -1)
    {
      JOptionPane.showMessageDialog(null, "Your options for gender: \n"+ result);
      gender = JOptionPane.showInputDialog("Please enter a gender from the list previously shown!");
      gen = searchObject(gendarray2, new Gender(gender));
    }
    
    //this is used to show the user their options of colors
    displayinfo.showcolors();
    String color = JOptionPane.showInputDialog("What is the color of the clothing?");
    
    //this is used to make sure the color they entered is on the list
    int k = search(colors2, color);
    
    //protects against bad input. If the value returned is -1, they are told
    //to input a proper value
    while (k == -1)
    {
      displayinfo.showcolors();
      color = JOptionPane.showInputDialog("Please enter a color that is on the list.");
      k = search(colors2, color);
    }
    
    String selection = "";
    selection +=gender + " " + color + " " + item;
    return selection;
  }
  
  //method called in main that handles all their selections and returns it as a value
  public String option2helper(Conditionals opt2, String[]colors2, String[] clothes2, 
                              Gender[] gendarray2)
  {
    displayinfo.showitems();
    String item = JOptionPane.showInputDialog("What are you adding to the closet? (Enter clothing type)");
    int n = search(clothes2, item);
    
    
    while (n == -1)
    {
      displayinfo.showitems();
      item = JOptionPane.showInputDialog("Please enter an item from the list previously shown.");
      n = search(clothes2, item);
    }
    
    
    sort(gendarray2);
    String result = "";
    for (Gender every: gendarray2)
    {
      result +=every + "\n";
    }
    
    JOptionPane.showMessageDialog(null, "Your options for gender: \n"+ result);
    String gender = JOptionPane.showInputDialog("What is the gender of the clothing? (Women's, men's or unisex)");
    
    int gen = searchObject(gendarray2, new Gender(gender));
    
    
    while (gen == -1) 
    {
      JOptionPane.showMessageDialog(null, "Your options for gender: \n"+ result);
      gender = JOptionPane.showInputDialog("Please enter a gender from the list previously shown");
      gen = searchObject(gendarray2, new Gender(gender));
    }
    
    
    displayinfo.showcolors();
    String color = JOptionPane.showInputDialog("What is the color of the clothing?");
    int k = search(colors2, color);
    
    
    while (k == -1)
    {
      displayinfo.showcolors();
      color = JOptionPane.showInputDialog("Please enter a color that is on the list.");
      k = search(colors2, color);
    }
    
    String selection = "";
    selection += gender + " " + color + " " + item;
    return selection;
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
  
  
  
  public static int searchObject(Gender[] theArray, Gender target) //SEARCH 
  {
    boolean onTheList = false; //BOOL
    
    for (int x = 0; x < theArray.length; x++)
    {
    
      if (theArray[x].getGender().compareToIgnoreCase(target.getGender())==0)
      {
        onTheList = true;
        return x;
      }
      
    }
      
        onTheList = false;
        return -1;
  }
  
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


