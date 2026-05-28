package snack.menu;

import snack.SnackConstants;
import snack.controller.SnackController;

import java.util.Scanner;

public class SnackMenu {
    private final Scanner sc = new Scanner(System.in);
    private final SnackController scr = new SnackController();

    public void menu() {
        System.out.println(SnackConstants.PROMPT_SNACK_INTRO);

        System.out.print(SnackConstants.PROMPT_KIND);
        String kind = sc.nextLine();

        System.out.print(SnackConstants.PROMPT_NAME);
        String name = sc.nextLine();

        System.out.print(SnackConstants.PROMPT_FLAVOR);
        String flavor = sc.nextLine();

        int numOf = readValidInteger(SnackConstants.PROMPT_NUM_OF);
        int price = readValidInteger(SnackConstants.PROMPT_PRICE);

        String saveResult = scr.saveData(kind, name, flavor, numOf, price);
        System.out.println(saveResult);

        System.out.print(SnackConstants.PROMPT_CONFIRM);
        String confirmChoice = sc.nextLine().trim().toLowerCase();
        if (confirmChoice.equals(SnackConstants.CONFIRM_YES)) {
            System.out.println(scr.confirmData());
        }
        System.out.println();
    }

    private int readValidInteger(String label) {
        while (true) {
            System.out.print(label);
            try {
                int value = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                if (value < 0) {
                    System.out.println(SnackConstants.MSG_NEGATIVE_ERROR);
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println(SnackConstants.MSG_PARSE_ERROR);
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
