import java.util.Scanner;
public class leapYear {
    public static void main(String[] args){
        Scanner inputYear = new Scanner(System.in);
        System.out.print("Input year: ");
        int number = inputYear.nextInt();
        if(number % 4 == 0 && (number % 100 != 0 || number % 400 == 0)){
            System.out.println("The year is a leap year.");
        }else{
            System.out.println("The year is not a leap year.");
        }
        inputYear.close();
    }
}
