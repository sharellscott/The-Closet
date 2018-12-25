/* TheCloset
 * ClosetDisplay.java
 * Sharell Scott
 * sscott05
 * Final Project
 * Section 1 */

//CL
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class ClosetDisplay
{
  //this method is used to show the user the colors they are allowed to enter
  public void showcolors() //MYMETH
  {
    JOptionPane.showMessageDialog(null, "Color Options:\nRed\nOrange\nYellow\nGreen\nBlue\nPurple"
                                  + "\nPink\nBlack\nWhite\nBrown\nGold\nSilver\nStriped"
                                  + "\nPlaid\nFuchsia\nApricot\nLavender\nBurgundy\nGray\nViolet");
  }
  
  //this method is used to show the user the clothing items they are allowed to enter
  public void showitems() //MYMETH
  {
    JOptionPane.showMessageDialog(null, "Clothing Item Options:\nShirt\nPants\nSweater\nScarf\nCoat\nJacket"
                                  + "\nDress\nSkirt\nHat\nJeans\nShorts\nBlouse\nT-Shirt\nBra\nSweatpants"
                                    +"\nPullover\nBoots\nSneakers\nCardigan");
  }
}