import java.util.Scanner;

public class Problem225 {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 2 number");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        System.out.println("Sum of two number: "+  (num1+ num2));
        System.out.println("The difference of two number: " + (num1 - num2));
        System.out.println("The product of two number: " + (num1*num2));
        if (num2 == 0){
            System.out.println("Can't solve the quotient");
        }
        else{
            System.out.println("The quotient of two number: " + (num1/num2));
        }


	}
}


