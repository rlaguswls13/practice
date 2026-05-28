package practice1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Practice4 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// runCheckLoop(sc);
			// calculateFruits(sc);
			getDaysInSelectedMonth(sc);
        }
	}
	
    private static void runCheckLoop(Scanner sc) {
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("정수를 입력하세요: ");
                int num = sc.nextInt();

                // 판별 및 출력 로직 호출
                processAndPrintGroup(num);
               
                // 성공적으로 출력되면 루프 종료 (필요 시)
                flag = false; 
            } catch (InputMismatchException e) {
                System.out.println("정수만 입력 가능합니다. 다시 입력해주세요.");
                sc.next(); // 버퍼에 남은 잘못된 입력 제거
            } catch (Exception e) {
                System.out.println("에러가 발생했습니다. 다시 입력해주세요.");
            }
        }
    }
    
    private static void processAndPrintGroup(int num) throws Exception {
    	
    	String[] pinteGroup = {"빨간색","노란색","파란색","초록색"};
    	
    	switch(num) {
    		case 1: System.out.printf("%d 입니다.\n", pinteGroup[0]); break;
    		case 5: System.out.printf("%d 입니다.\n", pinteGroup[1]); break;
    		case 2: System.out.printf("%d 입니다.\n", pinteGroup[2]); break;
    		case 3: System.out.printf("%d 입니다.\n", pinteGroup[3]);
    		case 4: System.out.printf("%d 입니다.\n", pinteGroup[4]);
    		default : throw new Exception();
    		
    	}
    }
    
    
    private static void calculateFruits(Scanner sc) {
    	System.out.print("가격을 확인할 과일을 입력하세요: ");
    	String selectedFruit = sc.next();
    	Map<String, Integer> fruits = new HashMap<>(Map.of("사과", 1000, "바나나", 2000, "수박", 3000));    	
    	
    	calculateFruitsBySwtich(selectedFruit, fruits);
    	calculateFruitsByIf(selectedFruit, fruits);
    }
    
    private static void calculateFruitsBySwtich(String selectedFruit, Map<String, Integer> fruits) {    
    	switch(selectedFruit) {
    	case "사과","바나나","수박" : System.out.printf("%s 가격은 %d원 입니다.\n", selectedFruit, fruits.get(selectedFruit)); break;
    	default : System.out.println("해당 과일은 없습니다.");
    	}
    }
    
    private static void calculateFruitsByIf(String selectedFruit, Map<String, Integer> fruits) {
    	if(fruits.containsKey(selectedFruit)) System.out.printf("%s 가격은 %d원 입니다.\n", selectedFruit, fruits.get(selectedFruit));
    	else System.out.println("해당 과일은 없습니다."); 
    }
    

    private static void getDaysInSelectedMonth(Scanner sc) {
    	System.out.print("월 입력 : ");
    	int inputMonth = sc.nextInt();
    	getDaysInSelectedMonthBySwitch(inputMonth);
    	getDaysInSelectedMonthByIf(inputMonth);
    }
    
    
    private static void getDaysInSelectedMonthBySwitch(int inputMonth) {
    	switch(inputMonth) {
	    	case 1,3,5,7,9,11 : System.out.printf("%d월은 %d일까지 있습니다.\n", inputMonth, 31); break;
	    	case 4,6,8,10,12 : System.out.printf("%d월은 %d일까지 있습니다.\n", inputMonth, 30); break;
	    	case 2 : System.out.printf("%d월은 %d일까지 있습니다.\n", inputMonth, 28); break;
	    	default : System.out.println("잘못 입력하셨습니다.");
    	}
    }
    
    
    private static void getDaysInSelectedMonthByIf(int inputMonth) {
    	if (inputMonth > 0  && inputMonth < 13) {
    		if(inputMonth % 2 == 1) {
    			System.out.printf("%d월은 %d일까지 있습니다.\n", inputMonth, 31);
    		} else if (inputMonth != 2) {
    			System.out.printf("%d월은 %d일까지 있습니다.\n", inputMonth, 30);
    		} else {
    			System.out.printf("%d월은 %d일까지 있습니다.\n", inputMonth, 28);
    		}
    	} else {
    		System.out.println("잘못 입력하셨습니다.");
    	} 
    }
    

}
