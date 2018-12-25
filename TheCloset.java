/* TheCloset.java
 * Sharell Scott
 * Section 1
 * sscott05 
 * Final Project */

/***** Copyright 2016, Sharell Scott, All rights reserved. *****/

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class TheCloset 
{
  public static void main (String [] args) throws Exception //was throws IOException
  {
    //variables used in main
    String name, temp;
    int option;
    
    //arrays created to take in information from files
    String[] colors;
    String[] womenclothes;
    String[] menclothes;
    String[] unisexclothes;
    String[] clothes;
    String[] names;
    String[] greeting;
    String[] laundry;
    
    File c = new File("colors.txt"); // I/O, input
    File n = new File("names.txt"); // I/O, input and output
    File wc = new File("women clothes.txt"); // I/O, input and output
    File mc = new File("men clothes.txt"); // I/O, input and output
    File uc = new File("unisex clothes.txt"); // I/O, input and output
    File i = new File("items.txt"); //I/O input
    File g = new File("greetings.txt"); //I/O input
    File lF = new File("Laundry List.txt"); //I/O, input and output
    
    //These scanners are used to read information from a file into arrays.
    Scanner colorScan = new Scanner(c);
    Scanner nameScan = new Scanner(n);
    Scanner womenScan = new Scanner(wc);
    Scanner menScan = new Scanner(mc);
    Scanner unisexScan = new Scanner(uc);
    Scanner scanclothes = new Scanner(i);
    Scanner greetings = new Scanner(g);
    Scanner laundryScan = new Scanner(lF);
    
    //These FileWriters PrintWriters are all used to
    //log a new name / clothing item to an existing file
    FileWriter namefile = new FileWriter ("names.txt", true);
    PrintWriter namePrint = new PrintWriter(namefile);
    FileWriter womenfile = new FileWriter("women clothes.txt", true);
    PrintWriter womenPrint = new PrintWriter(womenfile);
    FileWriter menfile = new FileWriter("men clothes.txt", true);
    PrintWriter menPrint = new PrintWriter(menfile);
    FileWriter unisexfile = new FileWriter("unisex clothes.txt", true);
    PrintWriter unisexPrint = new PrintWriter(unisexfile);
    FileWriter laundryfile = new FileWriter ("Laundry List.txt", true);
    PrintWriter laundryPrint = new PrintWriter(laundryfile);
    
    //this bit of code reads the colors from the color file into the color array
    //This array is used to show the user what colors they're allowed to enter 
    int sum = 0;
    while (colorScan.hasNext())
    {
      String temp2 = colorScan.nextLine();
      sum++;
    }
    
    colors = new String[sum];
    
    colorScan.close();
    colorScan = new Scanner(c);
    
    for (int x = 0; x<colors.length; x++)
    {
      colors[x] = colorScan.nextLine();
    }
    
    //this bit of code reads the clothing from the women's clothing file into
    //the women's clothing array
    int sumw = 0;
    while (womenScan.hasNext())
    {
      String temp2 = womenScan.nextLine();
      sumw++;
    }
    
    womenclothes = new String[sumw];
    
    womenScan.close();
    womenScan = new Scanner (wc);
    
    for (int x = 0; x<womenclothes.length; x++)
    {
      womenclothes[x] = womenScan.nextLine();
    }
    
    //this bit of code reads the clothing from the men's clothing file into
    //the men's clothing array
    int totalm = 0;
    while (menScan.hasNext())
    {
      String temp2 = menScan.nextLine();
      totalm++;
    }
    
    menclothes = new String[totalm];
    
    menScan.close();
    menScan = new Scanner (mc);
    
    for (int x = 0; x<menclothes.length; x++)
    {
      menclothes[x] = menScan.nextLine();
    }
    
    //this bit of code reads the clothing from the unisex clothing file into
    //the unisex clothing array
    int sumu = 0;
    while (unisexScan.hasNext())
    {
      String temp2 = unisexScan.nextLine();
      sumu++;
    }
    
    unisexclothes = new String[sumu];
    
    unisexScan.close();
    unisexScan = new Scanner (uc);
    
    for (int x = 0; x<unisexclothes.length; x++)
    {
      unisexclothes[x] = unisexScan.nextLine();
    }
    
    //this bit of code reads the items file into the items array. This array
    //is used to show the user what type of clothing they're allowed to input
    int sumc = 0;
    while (scanclothes.hasNext())
    {
      String temp2 = scanclothes.nextLine();
      sumc++;
    }
    
    clothes = new String[sumc];
    
    scanclothes.close();
    scanclothes = new Scanner (i);
    
    for (int x = 0; x<clothes.length; x++)
    {
      clothes[x] = scanclothes.nextLine();
    }
    
    //this bit of code reads info from the name file and puts it into
    //the name array. This array is used to see whether or not the name 
    //entered is already on the file/ in the array or not
    int totaln = 0;
    while (nameScan.hasNext())
    {
      String temp2 = nameScan.nextLine();
      totaln++;
    }
    
    names = new String[totaln];
    
    nameScan.close();
    nameScan = new Scanner(n);
    
    for (int x = 0; x<names.length; x++)
    {
      names[x] = nameScan.nextLine();
    }
    
    //this bit of code reads in information from the laundry file into the
    //laundry array. This is used when the user adds something to the laundry list
    int sumL = 0;
    while (laundryScan.hasNext())
    {
      String temp2 = laundryScan.nextLine();
      sumL++;
    }
    
    laundry = new String[sumL];
    
    laundryScan.close();
    laundryScan = new Scanner(lF);
    
    for (int x = 0; x<laundry.length; x++)
    {
      laundry[x] = laundryScan.nextLine();
    }
    
    //this code reads info from the greeting file into the greeting array.
    //This array is used as a source of the random greeting messages.
    int sumg = 0;
    while (greetings.hasNext())
    {
      String temp2 = greetings.nextLine();
      sumg++;
    }
    
    greeting = new String[sumg];
    
    greetings.close();
    greetings = new Scanner(g);
    
    for (int x = 0; x<greeting.length; x++)
    {
      greeting[x] = greetings.nextLine();
    }
    
    
    //this object are used to call methods within the TheClosetHelper class
    TheClosetHelper helpmethod = new TheClosetHelper();
    
    
    //these objects are used to ensure that the gender that the user inputs is one
    //of the valid genders within these objects
    Gender [] genderarray = new Gender[3]; //AR
    genderarray[0] = new Gender("women's");
    genderarray[1] = new Gender("men's");
    genderarray[2] = new Gender("unisex");
    
    //this object is used to call methods within the ClosetMethods class
    ClosetMethods helper = new ClosetMethods();
    
    //this object are used to call methods within the Conditionals class
    Conditionals conditions = new Conditionals();
    
    //this line of code calls to a method in ClosetMethods that handles greetings
    //the method has a string as a return value (their name) so I saved it in order to use it
    name = helper.welcome(greeting, names, sumg, nameScan, greetings);
    
    //searches name array to see if the name they entered is there already
    int nameindex = search(names, name);
    
    //if their name isn't there, it is added to the list
    if (nameindex == -1)
    {
    namePrint.print("\n" + name);
    }
    
    //this method of the ClosetMethods class has the user handle the different actions
    option = helper.action();
    
    
    //depending on the number they inserted, certain methods are called and certain 
    //actions are made
    if (option == 1)
    {
      number1(helpmethod, helper, conditions, colors, clothes, genderarray, womenPrint, menPrint, unisexPrint,
              womenclothes, menclothes, unisexclothes);
    }
    
    else if (option == 2)
    {
      number2(helpmethod, helper, conditions, colors, clothes, genderarray, womenPrint, menPrint, unisexPrint,
              womenclothes, menclothes, unisexclothes);
    }
    
    
    else if (option == 3) 
    {
      number3(helpmethod, womenclothes, menclothes, unisexclothes, sumw, totalm, sumu, genderarray,
              womenScan, menScan, unisexScan);
    }
    
    else if (option == 4)
    {
      number4(helpmethod, colors, clothes, genderarray, laundryPrint);
    }
    
    //closing all scanners and PrintWriters
    nameScan.close();
    namePrint.close();
    womenScan.close();
    womenPrint.close();
    menScan.close();
    menPrint.close();
    unisexScan.close();
    unisexPrint.close();
    laundryScan.close();
    laundryPrint.close();
  } 
  
  /*I have a lot of methods with object parameters, array parameters, etc. Whenever I use an array 
   parameter, I am using it in order to search that array for its index. When I am using a 
   PrintWriter parameter, I am using it to write a new piece of information to an existing file.
   When I am using the "TheClosetHelper" object, I am calling methods of that class. The objects 
   of this class are there for the sole reason of reducing the amount of space used in main. The same can
   be said for Conditionals objects, but this class has a bunch of "else if" statements. ClosetDisplay is used
   as a display class. Gender objects are used to see if the user is using the gender choices provided. 
   ClosetMethods has the same purpose as TheClosetHelper*/
  
  //this method is the method that is called when somewhen enters "1"
  public static void number1(TheClosetHelper numberone, ClosetMethods opt1, Conditionals c1, String[] colors2, String[] clothes2,
                             Gender[] gendarray, PrintWriter w, PrintWriter m, PrintWriter u, String[] womenclothes,
                             String[] menclothes, String[] unisexclothes) //MYMETH(O)
  {
    //the method in this class handles their gender, clothing item, and color selection. 
    //These selections are put onto a string and then returned as a value, which I use in this method
    String selection = opt1.option1helper(c1, colors2, clothes2, gendarray);
    
    //they are asked whether or not they are okay with their selection
    String confirmation = JOptionPane.showInputDialog("You have added the " + selection
                                                     + ". Is this okay? (yes or no)");
    
    //protects against bad input
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    }
    
    //if the user enters no, a method of the Conditionals class is called.
    if (confirmation.compareToIgnoreCase("no")==0)
    {
      c1.ifnot1(colors2, clothes2, w, m, u); 
    }
    
    //if the answer is yes, their selection is added to a text file depending on the gender entered
    else if (confirmation.compareToIgnoreCase("yes")==0)
    {
      //since the return value was a string with many parts, I had to use the split method
      String [] section = selection.split(" ");
      String section1 = section[0];
      
      if (section1.compareToIgnoreCase("women's")==0)
      {
        w.print("\n" + selection);
      }
      
      else if (section1.compareToIgnoreCase("men's")==0)
      {
        m.print("\n" + selection);
      }
      
      else if (section1.compareToIgnoreCase("unisex")==0)
      {
        u.print("\n" + selection);
      }
      JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
  }
  
  
  //this is called when the user enters the number 2
  public static void number2(TheClosetHelper numbertwo, ClosetMethods opt2, Conditionals c2, String[] colors2, String[] clothes2,
                             Gender[] gendarray, PrintWriter w, PrintWriter m, PrintWriter u, String[] womenclothes,
                             String[] menclothes, String[] unisexclothes) //MYMETH(O)
  {
    String selection = opt2.option1helper(c2, colors2, clothes2, gendarray);
    
    String confirmation = JOptionPane.showInputDialog("You are adding a new " + selection 
                                                        + " to the closet. Is this okay? (Yes or no)");
    
    while (!(confirmation.compareToIgnoreCase("yes")==0 || confirmation.compareToIgnoreCase("no")==0))
    {
      confirmation = JOptionPane.showInputDialog("Please enter yes or no");
    }
    
    if (confirmation.compareToIgnoreCase("yes")==0)
    {
      String [] section = selection.split(" ");
      String section1 = section[0];
      String section2 = section[1];
      String section3 = section[2];
      
      //Since the clothes added are supposed to be new for this option, I just simply put "new"
      if (section1.compareToIgnoreCase("women's")==0)
      {
        w.print("\n*NEW* " + selection);
      }
      
      else if (section1.compareToIgnoreCase("men's")==0)
      {
        m.print("\n*NEW* " + selection);
      }
      
      else if (section1.compareToIgnoreCase("unisex")==0)
      {
        u.print("\n*NEW* " + selection);
      }
      JOptionPane.showMessageDialog(null, "Great! Enjoy your day!");
    }
    
    
    else if (confirmation.compareToIgnoreCase("no")==0)
    {
      c2.ifnot2(colors2, clothes2, w, m, u); 
    }
    
  }
  
  //this is called when the user enters the number 3
  public static void number3(TheClosetHelper numberthree, String[] wc2, String[] mc2, String[] uc2,
                             int sumw2, int totalm2, int sumunisex, Gender[] gendarray, Scanner w, Scanner m, Scanner u) //MYMETH(O)
  {
    sort(gendarray);
    String result = "";
    for (Gender every: gendarray)
    {
      result +=every + "\n";
    }
    
    JOptionPane.showMessageDialog(null, "Your options for gender: \n"+ result);
    String gender = JOptionPane.showInputDialog("Which gender of clothing would you prefer? (Men�s, women�s, unisex)");
    int gen = searchObject(gendarray, new Gender(gender));
    
    while (gen == -1)
    {
      JOptionPane.showMessageDialog(null, "Your options for gender: \n"+ result);
      gender = JOptionPane.showInputDialog("Please enter Women's, Men's, or unisex"); 
      gen = searchObject(gendarray, new Gender(gender));
    }
    
    
    //if the user entered women's, the method of this TheClosetHelper class is called
    if (gender.compareToIgnoreCase("Women's")==0) 
    {
      numberthree.women(wc2, mc2, uc2, sumw2, totalm2, sumunisex, w, m, u); 
    }
    
    //if the user entered men's, the method of this TheClosetHelper class is called
    else if (gender.compareToIgnoreCase("Men's")==0)
    {
      numberthree.men(wc2, mc2, uc2, sumw2, totalm2, sumunisex, w, m, u); 
    }
    
    //if the user entered unisex, the method of this TheClosetHelper class is called
    else if (gender.compareToIgnoreCase("Unisex")==0)
    {
      numberthree.unisex(wc2, mc2, uc2, sumw2, totalm2, sumunisex, w, m, u); 
    }
  }
  
  //this is called when the user enters the number 4
  public static void number4(TheClosetHelper numberfour, String[] color2, String[] clothes2, Gender[] gendarray, 
                             PrintWriter laundry2) //MYMETH(O)
    
    //when the user enters 4, this method of the TheClosetHelper class is called
  {
    numberfour.add(color2, clothes2, laundry2); 
  }
  
  
  //this method is used to search an array of strings for an string that will
  //correspond with the user's input of clothing items or colors
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
  
  
  //this method is used to search an array of objects for an object that will
  //correspond with the user's input of gender
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
    
    
    
  
  
  
  //this method is used to sort an array of objects in order to present an 
  //alphabetically ordered list of the genders the user is allowed to input 
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