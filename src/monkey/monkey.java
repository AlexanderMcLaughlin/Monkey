package monkey;

import java.util.Scanner;

public class monkey {

    public static void main(String[] args) {
        //Read from stdin
        Scanner in = new Scanner(System.in);
        //Cycle through all the monkey tree layouts
        int n = in.nextInt();
        //Get the next line character so there are no stdin problems
        in.nextLine();
        
        for(int i=1; i<=n; i++) {
            String s = in.nextLine();
            //Simple recursive solution to find whether the left or right subtree has the 
            //most monkeys on vines and then multiply by 2 for the height of the tree from
            //the bottom up, because there can be only 2 possible subvines from each vine
            //and each subvine must be equal to its counterpart 
            System.out.println(i+" "+solve(s));
        }
        
    }
    
    static int solve(String s) {
        //Base cases if there are no monkeys on vines, or if there are only two monkeys on two vines
        if(s.equals("")) return 1;
        if(s.equals("[]")) return 2;
        
        //Implement recursion otherwise
        return solve(s, 0, s.length()-1);
    }
    
    static int solve(String s, int sI, int eI) {   
        //General base cases
        if((sI+1)==eI) return 2;
        if(sI>=eI) return 0;
        
        int i=sI;
        int sum=0;
        
        do {            
            i++;
            
            if(s.charAt(i)=='[') sum++;
            else if(s.charAt(i)==']') sum--;
            
        }while(sum!=0);
        
        //Basically, whichever subtree has the higher number of branches, left or right, 
        //will be what the other needs to be equal to for the monkeys to balance their weight
        //therefore, since there can only be 2 possible sub branches and the left must equal the
        //right, we can just say whichever is bigger multiplied by 2 is the number of monkeys needed
        //this is done from the top down to determine which subtree has more monkeys
        return 2 * max(solve(s, sI+1, i), solve(s, i+1, eI-1));
    }
    
    //Simple max function for two integers to avoid import
    static int max(int a, int b) {
        if(a>b) return a;
        return b;
    }
    
}
