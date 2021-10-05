import java.util.*;
class Soundex
{

  static String s1="",s,s2="";             //s2=Output String , s=Input String


   void AssignCode()                      //Function to Assign Codes to Letters and Storing it in String s1
  {
    for(int i=0;i<s.length();i++)
    {
      if(s.charAt(i)=='b'||s.charAt(i)=='f'||s.charAt(i)=='p'||s.charAt(i)=='v')  
       s1=s1+"1";
     else if(s.charAt(i)=='c'||s.charAt(i)=='g'||s.charAt(i)=='j'||s.charAt(i)=='k'||s.charAt(i)=='q'||s.charAt(i)=='s'||s.charAt(i)=='x'||s.charAt(i)=='z')  
       s1=s1+"2";
     else if(s.charAt(i)=='d'||s.charAt(i)=='t')
       s1=s1+"3";
     else if(s.charAt(i)=='l') 
       s1=s1+"4";
     else if(s.charAt(i)=='m'||s.charAt(i)=='n')
       s1=s1+"5";
     else if(s.charAt(i)=='r')
       s1=s1+"6";
     else 
       s1=s1+"0"; 
    }
  }

  
  void RuleCheck()                             //Function to Check For Conditions
  {
    for(int i=1;i<s.length();i++)
    {
     if(s1.charAt(i)!=s1.charAt(i-1) && s1.charAt(i)!='0')
       {
        s2=s2+s1.charAt(i); 
       }
    }
    if(s2.length()<4)
    {
     int x=4-s2.length();
   
     while(x>0)
     {
      s2=s2+"0";   
       x--;
     }

    }

    else

    s2=s2.substring(0,4);

    System.out.println("Soundex Code :"+s2);
  } 

  public static void main(String args[])                        //Main Function   
  {
    System.out.println("Enter a Word");  //Taking input

    Scanner sc=new Scanner(System.in);  

    s=sc.nextLine();

    s2=s2+s.charAt(0);                   //Adding First Letter to output string

    s=s.toLowerCase();

    Soundex obj=new Soundex();           //Objection Creation

    obj.AssignCode();                    //Calling Function to Assign Code 

    obj.RuleCheck();                     //Calling Function to Check For Conditions
  }
}
      
    