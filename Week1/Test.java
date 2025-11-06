import java.util.Scanner;

public class Test{

    static void EvenOdd(int num){
        if (num %2==0){
            System.out.println("Given number is Even");
        }
        else{
            System.out.println("Given number is Odd");
        }
    
    }

    static void Factorial(int num){
        if (num<0){
            System.out.println("No Factorial for negative number ");
        }
        long fact=1;
        for(int i=1;i<=num;i++){
            fact=fact*i;
        }
        System.out.println("Factorial for given num is:"+fact);

    }

    static void Reverse(int num){
        int rev=0;
        int temp=num;
        while(num !=0){
            int digit = num%10;
            rev= rev*10+digit;
            num= num/10;
        }
        System.out.println("Reverse of given number is:"+rev);
    }

    static void Palindrome(int num){
        int rev=0;
        int temp=num;
        while(num !=0){
            int digit = num%10;
            rev= rev*10+digit;
            num= num/10;
        }
        if( rev==temp){
            System.out.println("Given num is Palindrome");
        }else{
            System.out.println("Given num is no palindrome");
        }

    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choice;

        do{
            System.out.println("Calculator Menu");
            System.out.println("1.EvenOdd");
            System.out.println("2.Factorial");
            System.out.println("3.Reverse");
            System.out.println("4.Palindrome");

            System.out.println("Enter the choice(1-5):");
            choice = sc.nextInt();

            if(choice>=1 && choice<=4){
                System.out.println("Enter the number:");
                int num=sc.nextInt();

                switch(choice){

                    case 1:
                    EvenOdd(num);
                    break;

                    case 2:
                    Factorial(num);
                    break;

                    case 3:
                    Reverse(num);
                    break;

                    case 4:
                    Palindrome(num);
                    break;
                }
            
            }else if(choice==5){
                System.out.println("Exiting Program!");
            }else{
                System.out.println("Invalid option");
            }
        }while (choice !=5);
        sc.close();
    }
}