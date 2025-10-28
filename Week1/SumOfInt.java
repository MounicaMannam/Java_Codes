import java.util.Scanner;

public class SumOfInt{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter 5 numbers:");
        int sum=0;
        for (int i = 0; i < 5; i++){
            int number=input.nextInt();
            sum+=number;
        }
        System.out.println("The sum is: "+sum);
        input.close();
    }
}
