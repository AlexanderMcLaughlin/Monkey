package monkey;

import java.util.Scanner;

public class monkey 
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        
        for(int i=1; i<=n; i++)
        {
            String s = in.nextLine();
            
            System.out.println(i+" "+solve(s));
        }
        
    }
    
    static int solve(String s)
    {
        if(s.equals("")) return 1;
        if(s.equals("[]")) return 2;
        
        return solve(s, 0, s.length()-1);
    }
    
    static int solve(String s, int sI, int eI) 
    {   
        if((sI+1)==eI) return 2;
        if(sI>=eI) return 0;
        
        int i=sI;
        int sum=0;
        
        do
        {            
            i++;
            
            if(s.charAt(i)=='[') sum++;
            else if(s.charAt(i)==']') sum--;
            
        }while(sum!=0);
        
        return 2 * max(solve(s, sI+1, i), solve(s, i+1, eI-1));
    }
    
    static int max(int a, int b)
    {
        if(a>b) return a;
        return b;
    }
    
}
