package shape.menu;

import shape.ShapeConstants;
import shape.controller.SquareController;
import shape.controller.TriangleController;
import shape.type.ShapeTypeOption;
import shape.type.TriangleMenuOption;
import shape.type.SquareMenuOption;

import java.util.Scanner;

public class ShapeMenu {
    private final Scanner sc = new Scanner(System.in);
    private final SquareController scr = new SquareController();
    private final TriangleController tc = new TriangleController();

    public void inputMenu() {
        while (true) {
            ShapeTypeOption.displayMenu();
            int choice = readIntegerInput(ShapeConstants.PROMPT_SHAPE_CHOICE);
            System.out.println();

            ShapeTypeOption.fromCode(choice).ifPresentOrElse(
                    option -> {
                        if (option == ShapeTypeOption.TRIANGLE) {
                            triangleMenu();
                        } else if (option == ShapeTypeOption.SQUARE) {
                            squareMenu();
                        }
                    },
                    () -> System.out.println(ShapeConstants.MSG_INVALID_CHOICE)
            );

            if (choice == ShapeTypeOption.EXIT.getCode()) {
                break;
            }
        }
    }

    public void triangleMenu() {
        while (true) {
            TriangleMenuOption.displayMenu();
            int choice = readIntegerInput(ShapeConstants.PROMPT_MENU_CHOICE);
            System.out.println();

            TriangleMenuOption.fromCode(choice).ifPresentOrElse(
                    option -> {
                        if (option == TriangleMenuOption.AREA) {
                            inputSize(3, 1);
                        } else if (option == TriangleMenuOption.PAINT) {
                            inputSize(3, 2);
                        } else if (option == TriangleMenuOption.INFO) {
                            printInformation(3);
                        }
                    },
                    () -> System.out.println(ShapeConstants.MSG_INVALID_CHOICE)
            );

            if (choice == TriangleMenuOption.EXIT.getCode()) {
                break;
            }
        }
    }

    public void squareMenu() {
        while (true) {
            SquareMenuOption.displayMenu();
            int choice = readIntegerInput(ShapeConstants.PROMPT_MENU_CHOICE);
            System.out.println();

            SquareMenuOption.fromCode(choice).ifPresentOrElse(
                    option -> {
                        if (option == SquareMenuOption.PERIMETER) {
                            inputSize(4, 1);
                        } else if (option == SquareMenuOption.AREA) {
                            inputSize(4, 2);
                        } else if (option == SquareMenuOption.PAINT) {
                            inputSize(4, 3);
                        } else if (option == SquareMenuOption.INFO) {
                            printInformation(4);
                        }
                    },
                    () -> System.out.println(ShapeConstants.MSG_INVALID_CHOICE)
            );

            if (choice == SquareMenuOption.EXIT.getCode()) {
                break;
            }
        }
    }

    public void inputSize(int type, int menuNum) {
        if (type == 3) { // 삼각형
            if (menuNum == 1) {
                double height = readDoubleInput(ShapeConstants.PROMPT_HEIGHT);
                double width = readDoubleInput(ShapeConstants.PROMPT_WIDTH);
                double area = tc.calcArea(height, width);
                System.out.printf(ShapeConstants.MSG_TRIANGLE_AREA_RESULT, area);
            } else if (menuNum == 2) {
                System.out.print(ShapeConstants.PROMPT_COLOR);
                String color = sc.nextLine();
                tc.paintColor(color);
                System.out.println(ShapeConstants.MSG_PAINT_SUCCESS);
            }
        } else if (type == 4) { // 사각형
            if (menuNum == 1) {
                double height = readDoubleInput(ShapeConstants.PROMPT_HEIGHT);
                double width = readDoubleInput(ShapeConstants.PROMPT_WIDTH);
                double perimeter = scr.calcPerimeter(height, width);
                System.out.printf(ShapeConstants.MSG_SQUARE_PERIMETER_RESULT, perimeter);
            } else if (menuNum == 2) {
                double height = readDoubleInput(ShapeConstants.PROMPT_HEIGHT);
                double width = readDoubleInput(ShapeConstants.PROMPT_WIDTH);
                double area = scr.calcArea(height, width);
                System.out.printf(ShapeConstants.MSG_SQUARE_AREA_RESULT, area);
            } else if (menuNum == 3) {
                System.out.print(ShapeConstants.PROMPT_COLOR);
                String color = sc.nextLine();
                scr.paintColor(color);
                System.out.println(ShapeConstants.MSG_PAINT_SUCCESS);
            }
        }
        System.out.println();
    }

    public void printInformation(int type) {
        if (type == 3) {
            System.out.println(tc.print());
        } else if (type == 4) {
            System.out.println(scr.print());
        }
        System.out.println();
    }

    private int readIntegerInput(String label) {
        while (true) {
            System.out.print(label);
            try {
                int value = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                return value;
            } catch (Exception e) {
                System.out.println(ShapeConstants.MSG_PARSE_ERROR);
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }

    private double readDoubleInput(String label) {
        while (true) {
            System.out.print(label);
            try {
                double value = sc.nextDouble();
                sc.nextLine(); // 버퍼 비우기
                if (value <= 0) {
                    System.out.println(ShapeConstants.MSG_NEGATIVE_ERROR);
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println(ShapeConstants.MSG_PARSE_ERROR);
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
