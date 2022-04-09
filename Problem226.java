import java.util.Scanner;

public class Problem226 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n");
        // n is the number of case that we'll solve:
        // n == 1: The first degree equation (linear equation) with one variable. (ax+b)
        // n == 2: The system of first degree equations (linear system) with two variables. (a11x1 + a12x2 = b1a21x1 + a22x2 = b2)
        // n == 3: The second-degree equation with one variable. (ax^2 + bx +c = 0)
        Double n = scanner.nextDouble();
        if(n ==1){
            System.out.println(" ax + b: " + "Please enter a and b");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            if(a ==0){
                System.out.println("No solution");
            }
            else{
                System.out.println("Function hase solution: "+ (b/a));
            }    
        }
        if(n ==2){
            System.out.println("a1 * x1 + b1 * x2 = c1 * a2 * x1 + b2 * x2 = c2: " + "Please enter a1, b1, a2, b2, c1, c2: ");
            System.out.println("a1 :"); 
            double a1 = scanner.nextDouble();
            System.out.println("b1 :"); 
			double b1 = scanner.nextDouble();
            System.out.println("c1 :"); 
			double c1 = scanner.nextDouble();
            System.out.println("a2 :"); 
			double a2 = scanner.nextDouble();
            System.out.println("b2 :"); 
			double b2 = scanner.nextDouble();
            System.out.println("c2 :"); 
			double c2 = scanner.nextDouble();
			double D = a1*b2 - a2*b1;
			double Dx = c1*b2 - c2*b1;
			double Dy = a1*c2 - a2*c1;
			if (D != 0 ) {
				System.out.println("System of function has solution: x = "+ (Dx/D) + " and y = "+ (Dy/D));
				
			}else {
				if (Dx != 0 || Dy != 0) {
					System.out.println("No solution ");
					
				}else {
					System.out.println("Infinite solution ");
				}
			}
        }
        if(n==3){
            System.out.println("a * x^2 + b * x + c = 0"+ "Please enter a, b ,c:");
			System.out.println("a: ");
            double a = scanner.nextDouble();
            System.out.println("b: ");
			double b = scanner.nextDouble();
            System.out.println("c: ");
			double c = scanner.nextDouble();
			
			double delta = b*b - 4*a*c;
			if (delta < 0) {
				System.out.println("No solution ");
			}
			else if (delta == 0) {
				System.out.println("Function has solution: x = "+ (-b/(2*a)));
				
			}else {
				System.out.println("Function has solution x1 = "+((-b+ Math.sqrt(delta))/(2*a)) +" and x2 = "+((-b- Math.sqrt(delta))/(2*a)));
			}
		
        }



    }
}
