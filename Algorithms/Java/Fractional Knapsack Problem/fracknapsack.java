


import java.util.Scanner;

// prerequisites: Greedy algorithm
// here we define one class for storing value and weight of that item with ration of that val /weight which is assigned by constructor
class item{
    double val;
    double weight;
    double ratio;
    public item(double val,double weight,double ratio)
    {
        this.val=val;
        this.weight=weight;
        this.ratio=ratio;
    }
}

// main knapsack class starts
class knapsack{
    private item obj[]; //passing as data type for knapsack class
    private int n;
    private int W;
    public knapsack(item ob[],int n,int W)
    {
        this.obj=ob;
        this.n=n;
        this.W=W;
    }


    //we arer sorting that obj of item class on the basis of ration as this is greedy algo

    public void max_profit()
    {
        //sorting on basis of ratio
        item temp;
        for(int i=0;i<n;i++)
        {
           for(int j=0;j<n;j++)
           {
               if(obj[i].ratio<obj[j].ratio)
               {
                    temp=obj[j];
                    obj[j]=obj[i];
                    obj[i]=temp;
               }
           }

        }

        //knapsack solution

        int currw=0;
        double finalvalue=0.0;
        
        for(int i=n-1;i>=0;i--)
        {
            if(currw+obj[i].weight<=W) // keep adding weight and value to solution 
            {
                currw+=obj[i].weight;
                finalvalue+=obj[i].val;
            }
            else  // it will be called when we can't put whole item in answer as it exceeds limit of solution
            {
                int remaining=W-currw;
                finalvalue+=obj[i].val*((double)remaining/obj[i].weight);
            }
        }

        System.out.println("maximum profit is:"+finalvalue);
        }

    
    }   

//driver code

public class fracknapsack {

    public static void main(String[] args) {
        
       Scanner input=new Scanner(System.in);
       System.out.println("enter total n and max weight respectively:");

       int n=input.nextInt();
       int W=input.nextInt();
       
       item obj1[]=new item[n];

       double a,b,c;
       for(int i=0;i<n;i++)
       {
           System.out.println("val:");
           a=input.nextDouble();
           System.out.println("weigth:");
           b=input.nextDouble();
          c=a/b; // ratio of val/weight
          obj1[i]=new item(a,b,c);
       }

        knapsack obj=new knapsack(obj1, n,W); //new object
        obj.max_profit();
        input.close();
    }

}



/* 
Exaple:

Items as (value, weight) pairs 
arr[] = {{60, 10}, {100, 20}, {120, 30}} 
Knapsack Capacity, W = 50; 

enter total n and max weight respectively:
3
50
val:
60
weigth:
10
val:
100
weigth:
20
val:
120
weigth:
30
maximum profit is:240.0
*/