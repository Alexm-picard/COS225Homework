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
}
