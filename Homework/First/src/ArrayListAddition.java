import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class ArrayListAddition {
    public static ArrayList <Integer> array_list_add(ArrayList <Integer> c, ArrayList <Integer> d){
        ArrayList <Integer> output1 = new ArrayList <Integer>();
        int maxLen = 0;
        int carry1 = 0;
        int holder1 = 0;
        if(c.size() >= d.size()){
            maxLen = c.size();
        }else{
            maxLen = d.size();
        }
        for(int x = 0; x < maxLen; x++){
            if(x >= c.size()){
                output1.add(carry1 + d.get(x));
                carry1 = 0;
            }else if(x >= d.size()){
                output1.add(carry1 + c.get(x));
                carry1 = 0;
            }else if(c.get(x) + d.get(x) + carry1 <= 9){
                output1.add(c.get(x) + d.get(x) + carry1);
                carry1 = (c.get(x) + d.get(x) + carry1) / 10;
            }else if(c.get(x) + d.get(x) + carry1 > 9){
                holder1 = (c.get(x) + d.get(x) + carry1) % 10;
                output1.add(holder1);
                carry1 = (c.get(x) + d.get(x) + carry1) / 10;
            }   
        }
        Collections.reverse(output1);
        if(carry1 == 1){
                output1.add(0, carry1);
        }
        return output1;
    }
    public static void main(String[] args){
        Scanner inputChoose = new Scanner(System.in);
        int firstListLength = 0;
        int secondListLength = 0;   
        ArrayList <Integer> firstArrayList = new ArrayList <Integer>();
        ArrayList <Integer> secondArrayList = new ArrayList <Integer>();    
        System.out.print("Input First Array Length: ");
        Scanner inputList = new Scanner(System.in);
        firstListLength = inputList.nextInt();
        for(int i = 0; i < firstListLength; i++){
            System.out.print("Input the " + i + " LSD: ");
            firstArrayList.add(inputList.nextInt());
        }
        System.out.print("Input Second Array Length: ");
        secondListLength = inputList.nextInt();
        for(int i = 0; i < secondListLength; i++){
            System.out.print("Input the " + i + " LSD: ");
            secondArrayList.add(inputList.nextInt());
        }
        inputList.close();
        System.out.println("The arrayList addition is " + array_list_add(firstArrayList, secondArrayList).toString());
        inputChoose.close();
    }
}
