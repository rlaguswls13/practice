package practice1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Practice5 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// gradingMethod(sc);
			// calculateDicePoints(sc);
			calculateFee(sc);
        }
	}
	
	
	
	// 0점부터 100점 사이의 정수를 입력받아 아래 조건에 따라 등급(학점)을 출력하는 프로그램을 작성하세요.
	private static void gradingMethod(Scanner sc) {
		System.out.print("점수를 입력하세요: ");
	    int score = sc.nextInt();
	    System.out.printf("당신의 성적은 %s 입니다.\n", getGrade(score));
	}
	
	
	// java 12 이상에서는 Switch Expression 활용 !!
	private static String getGrade(int score) {
	    return switch (score / 10) {
	        case 10, 9 -> "A";
	        case 8 -> "B";
	        case 7 -> "C";
	        case 6 -> "D";
	        default -> "F";
	    };
	}
	
	/***********************************************************/
	private static final int ALL_SAME_BONUS = 10000;
    private static final int TWO_SAME_BONUS = 1000;

    private static void calculateDicePoints(Scanner sc) {
        System.out.print("입력 : ");
        int[] dice = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        Arrays.sort(dice);
        int totalPoints = getScore(dice);
        System.out.println(totalPoints);
    }

    private static int getScore(int[] dice) {
        if (dice[0] == dice[2]) {
            return ALL_SAME_BONUS + dice[0] * 1000;
        }       
        if (dice[0] == dice[1] || dice[1] == dice[2]) {
            return TWO_SAME_BONUS + dice[1] * 100;
        }
        return dice[2] * 100;
    }
	
	
	/***********************************************************/
	// 어린이, 청소년, 성인의 구분에 따라 입장료가 다르게 부과되는 **놀이공원 요금 계산기**를 만들어보세요.
    // 또한, 주말에는 20% 할인이 적용됩니다.
    private static final int FEE_ADULT = 10000;
    private static final int FEE_TEEN = 7000;
    private static final int FEE_CHILD = 5000;
    private static final double WEEKEND_DISCOUNT_RATE = 0.8;

    private static void calculateFee(Scanner sc) {
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();
        
        System.out.print("요일을 입력하세요(월~일) : ");
        String day = sc.next();
        
        String group = getGroup(age);
        int baseFee = getFeeByGroup(group);
        boolean isWeekend = isWeekend(day);

        int finalFee = applyDiscount(baseFee, isWeekend);

        System.out.printf("%s 요금입니다. %s\n", group, isWeekend ? "(주말 20% 할인 적용)" : "");
        System.out.printf("최종 요금은 %d원 입니다.\n", finalFee);
    }

    private static String getGroup(int age) {
        if (age >= 19) return "성인";
        if (age >= 13) return "청소년";
        return "어린이";
    }

    private static int getFeeByGroup(String group) {
        return switch (group) {
            case "성인" -> FEE_ADULT;
            case "청소년" -> FEE_TEEN;
            default -> FEE_CHILD;
        };
    }

    private static boolean isWeekend(String day) {
        List<String> weekends = List.of("토", "일", "토요일", "일요일");
        return weekends.contains(day);
    }

    private static int applyDiscount(int fee, boolean isWeekend) {
        if(isWeekend) return (int) (fee * WEEKEND_DISCOUNT_RATE);
        return fee;
    }
}
