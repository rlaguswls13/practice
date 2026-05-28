package practice1;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        System.out.print("가로(a) 입력: ");
        double a = sc.nextDouble();
        System.out.print("세로(b) 입력: ");
        double b = sc.nextDouble();
        
        double area = a * b;            
        double perimeter = 2 * (a + b);

        System.out.printf("면적 : %.2f\n", area);
        System.out.printf("둘레 : %.2f\n", perimeter);
        
        sc.close();
	}
}
