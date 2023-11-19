import java.util.Scanner;
import java.util.Arrays;
public class ArrayAddition {
    public static int[] array_add(int[] a, int[] b){
        int carry = 0;
        int maxLength = 0;
        int holder = 0;
        if(a.length >= b.length){
            maxLength = a.length;
        }else{
            maxLength = b.length;
        }
        int[] output = new int[maxLength];
        for(int i = 0; i < maxLength; i++){
            if(i >= a.length){
                output[i] = carry + b[i];
                carry = 0;
            }else if(i >= b.length){
                output[i] = carry + a[i];
                carry = 0;
            }else if(a[i] + b[i] + carry <= 9){
                output[i] = a[i] + b[i] + carry;
                carry = (a[i] + b[i] + carry) / 10;
            }else if(a[i] + b[i] + carry > 9){
                holder = (a[i] + b[i] + carry) % 10;
                output[i] = holder;
                carry = (a[i] + b[i] + carry) / 10;
            }
        }
        if(output[output.length-1] == 0){
            int[] returnArray = new int[output.length - 1];
            for(int j = output.length - 2; j >= 0; j--){
                returnArray[output.length - j - 2] = output[j];
            }
            return returnArray;
        }else{
            int[] returnArray = new int[output.length];
            for(int j = output.length - 1; j >= 0; j--){
                returnArray[output.length - j - 1] = output[j];
            }
            return returnArray;
        }
    }
    public static void main(String[] args){
        Scanner inputChoose = new Scanner(System.in);
        int firstArrayLength = 0;
        int secondArrayLength = 0;
        System.out.print("Input First Array Length: ");
        Scanner in = new Scanner(System.in);
        firstArrayLength = in.nextInt();
        int[] firstArray = new int[firstArrayLength + 1];
        for(int i = 0; i < firstArrayLength; i++){
            System.out.print("Input the " + i + " LSD: ");
            firstArray[i] = in.nextInt();
        }
        System.out.print("Input Second Array Length: ");
        secondArrayLength = in.nextInt();
        int[] secondArray = new int[secondArrayLength + 1];
        for(int i = 0; i < secondArrayLength; i++){
            System.out.print("Input the " + i + " LSD: ");
            secondArray[i] = in.nextInt();
        }
        System.out.println("The array addition is " + Arrays.toString(array_add(firstArray, secondArray)));
        in.close();
        inputChoose.close();
    }
}
