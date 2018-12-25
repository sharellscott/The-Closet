/* TheCloset
 * Gender.java
 * Sharell Scott
 * sscott05
 * Final Project
 * Section 1 */

//CL
public class Gender
{
  String gender;
  
  //this constructor is used to put information into the objects of this class 
  //that uses one String parameter
  public Gender(String g)
  {
    gender = g;
  }
  
  //this method is used for the search method in main. It comapares the information
  //between two objects
  public int compareTo(Gender gend)
  {
    return this.gender.compareTo(gend.gender);
  }
  
  //this method is used to display the information within the objects of this class
  public String toString()
  {
    return gender;
  }
  
  
  //this method is used to get the information within the objects of this class
  public String getGender()
  {
    return gender;
  }
  
}