import java.util.Scanner;
public class Fibonacci {
    public static int fib(int n){
        int output = 1;
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 0; i < n; i++){
            if(i == 0){
                prev1 = output;
            }else{output = prev1 + prev2;
            prev2 = prev1;
            prev1 = output;
            }
        }
        return output;
    }       
    
    public static int fib_r(int n){
        if(n == 0 || n == 1){
            return n;
        }      
        return fib_r(n-1) + fib_r(n-2);
    }

    public static void main(String[] args){
        int loopItter = 0;
        int recItter = 0;
        Scanner inputChoose = new Scanner(System.in);
        System.out.print("Computation choice: 1-Loop, 2-Reccursion -> ");
        switch(inputChoose.nextInt()){
            case(1):
                System.out.print("Input ittereations for loop: ");
                Scanner loopInput = new Scanner(System.in);
                loopItter = loopInput.nextInt();
                System.out.println("The " + loopItter +"-th Fibonacci number computed using loop is " + fib(loopItter));
                loopInput.close();
                break;
            case(2):
                System.out.print("Input ittereations for reccursion: ");
                Scanner recInput = new Scanner(System.in);
                recItter = recInput.nextInt();
                System.out.println("The " + recItter + "-th Fibonacci number computed using recursion is " + fib_r(recItter));
                recInput.close();
                break;
            default:
                System.out.println("Invalid computation choice");
        }
        inputChoose.close();
    }
}
