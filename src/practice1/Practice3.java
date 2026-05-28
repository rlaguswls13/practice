package practice1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
        // Scanner를 리소스로 관리 (자동 close)
        try (Scanner sc = new Scanner(System.in)) {
            runAgeCheckLoop(sc);
        }
    }

    /**
     * 입력을 받고 예외를 처리하며 루프를 돌리는 제어 함수
     */
    private static void runAgeCheckLoop(Scanner sc) {
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("나이를 입력하세요: ");
                int age = sc.nextInt();

                // 판별 및 출력 로직 호출
                processAndPrintAgeGroup(age);
               
                // 성공적으로 출력되면 루프 종료 (필요 시)
                flag = false; 
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                sc.next(); // 버퍼에 남은 잘못된 입력 제거
            } catch (Exception e) {
                System.out.println("측정중 에러가 발생했습니다. 다시 입력해주세요.");
            }
        }
    }

    /**
     * 연령대 판별 및 결과를 출력하는 함수
     */
    private static void processAndPrintAgeGroup(int age) throws Exception {
        String ageGroup = checkAgeGroup(age);
        System.out.printf("%d세는 %s에 속합니다.%n", age, ageGroup);
    }

    /**
     * 순수 비즈니스 로직: 연령대 문자열 반환
     */
    private static String checkAgeGroup(int age) throws Exception {
        String[] ageGroupArray = {"어린이", "청소년", "성인"};
        
        int minAge = 1;
        int kidLimit = 13;
        int adultLimit = 20;
        
        if (age < minAge) throw new Exception("유효하지 않은 나이");
        if (age <= kidLimit) return ageGroupArray[0];
        if (age < adultLimit) return ageGroupArray[1];
        return ageGroupArray[2];
    }
}
