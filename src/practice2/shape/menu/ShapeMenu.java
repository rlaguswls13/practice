package practice2.shape.menu;

import practice2.shape.ShapeConstants;
import practice2.shape.controller.ShapeController;
import practice2.shape.type.ShapeMenuOption;

import java.util.Scanner;

public class ShapeMenu {
    private final Scanner sc = new Scanner(System.in);
    private final ShapeController controller = new ShapeController();

    public void inputMenu() {
        while (true) {
            ShapeMenuOption.displayMenu();
            System.out.print(ShapeConstants.PROMPT_MENU_CHOICE);
            int choice = readIntegerInput();
            System.out.println();

            ShapeMenuOption.fromCode(choice).ifPresentOrElse(
                    option -> {
                        if (option == ShapeMenuOption.INPUT_INFO) {
                            handleInputInfo();
                        } else if (option == ShapeMenuOption.PAINT_COLOR) {
                            handlePaintColor();
                        }
                    },
                    () -> System.out.println(ShapeConstants.MSG_INVALID_CHOICE)
            );

            if (choice == ShapeMenuOption.EXIT.getCode()) {
                break;
            }
        }
    }

    private void handleInputInfo() {
        int numSides = readValidSides();
        double sideLength = readValidLength();

        double perimeter = controller.calcPerimeter(numSides, sideLength);
        double area = controller.calcArea(numSides, sideLength);

        System.out.printf(ShapeConstants.MSG_PERIMETER_RESULT, numSides, perimeter);
        System.out.printf(ShapeConstants.MSG_AREA_RESULT, numSides, area);
        System.out.println(controller.print());
        System.out.println();
    }

    private void handlePaintColor() {
        System.out.print(ShapeConstants.PROMPT_COLOR);
        String color = sc.nextLine();
        controller.paintColor(color);
        System.out.println(ShapeConstants.MSG_PAINT_SUCCESS);
        System.out.println(controller.print());
        System.out.println();
    }

    private int readValidSides() {
        while (true) {
            System.out.print(ShapeConstants.PROMPT_NUM_SIDES);
            try {
                int value = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                if (value < 3) {
                    System.out.println(ShapeConstants.MSG_NUM_SIDES_ERROR);
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println(ShapeConstants.MSG_PARSE_ERROR);
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }

    private double readValidLength() {
        while (true) {
            System.out.print(ShapeConstants.PROMPT_SIDE_LENGTH);
            try {
                double value = sc.nextDouble();
                sc.nextLine(); // 버퍼 비우기
                if (value <= 0) {
                    System.out.println(ShapeConstants.MSG_SIDE_LENGTH_ERROR);
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println(ShapeConstants.MSG_PARSE_ERROR);
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }

    private int readIntegerInput() {
        try {
            int value = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            return value;
        } catch (Exception e) {
            sc.nextLine(); // 버퍼 비우기
            return -1;
        }
    }
}
