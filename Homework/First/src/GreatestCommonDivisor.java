import java.util.Scanner;
public class GreatestCommonDivisor {
    public static int gcd(int input1, int input2){
        int output = input1;
        int x = input2;
        int temp1 = 0;
        while(x != 0){
            temp1 = x;
            x = output - output / x * x;
            output = temp1;
        }
        return output;
    }
    public static int gcd_r(int input1, int input2){
        int inputTemp = input1 - ((input1 / input2) * input2);
        if(input1 % input2 == 0){
            return input2;
        }
        return gcd_r(input2, inputTemp);
    }
    public static void main(String[] args){
        Scanner inputChoose = new Scanner(System.in);
        System.out.print("Computation choice: 1-Loop, 2-Reccursion -> ");
        int temp = inputChoose.nextInt();
        int loopFirst = 0;
        int loopSecond = 0;
        int recFirst = 0;
        int recSecond = 0;
        switch(temp){
            case(1):
                System.out.print("Input First Number: ");
                Scanner loopNum = new Scanner(System.in);
                loopFirst = loopNum.nextInt();
                System.out.print("Input Second Number: ");
                loopSecond = loopNum.nextInt();
                System.out.println("The GCD computed using loop is " + gcd(loopFirst, loopSecond));
                loopNum.close();
                break;
            case(2):
                System.out.print("Input First Number: ");
                Scanner recNum = new Scanner(System.in);
                recFirst = recNum.nextInt();
                System.out.print("Input Second Number: ");
                recSecond = recNum.nextInt();
                System.out.println("The GCD computed using recurrion is " + gcd_r(recFirst, recSecond));
                recNum.close();
                break;
            default:
                System.out.println("Invalid computation choice");
        }
        inputChoose.close();

    }
}
