package product.menu;

import product.ProductConstants;
import product.controller.ProductController;
import product.dto.ProductInputDto;
import product.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private final ProductController controller = new ProductController();
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;

    public void mainMenu() {
        this.isRunning = true;
        while (isRunning) {
            MenuOption.displayMenu();
            System.out.print(ProductConstants.PROMPT_MENU_CHOICE);
            int choice = readIntegerInput();
            processCommand(choice);
        }
    }

    private int readIntegerInput() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기
            return value;
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1;
        }
    }

    private Long readLongInput() {
        try {
            Long value = scanner.nextLong();
            scanner.nextLine(); // 버퍼 비우기
            return value;
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1L;
        }
    }

    private int readValidNumber(String prompt, String errorMsg) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                if (value < 0) {
                    System.out.println(errorMsg);
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println(errorMsg);
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private void processCommand(int choice) {
        MenuOption.fromCode(choice).ifPresentOrElse(
                option -> option.execute(this),
                () -> System.out.println(ProductConstants.MSG_INVALID_INPUT)
        );
    }

    public void handleCreate() {
        while (true) {
            System.out.println(ProductConstants.MSG_REGISTRATION_INTRO);
            System.out.print(ProductConstants.PROMPT_REG_TYPE);
            int regChoice = readIntegerInput();
            System.out.println();

            if (regChoice == 9) {
                break;
            }

            String category;
            if (regChoice == 1) {
                category = "GENERAL";
            } else if (regChoice == 2) {
                category = "SNACK";
            } else {
                System.out.println(ProductConstants.MSG_INVALID_INPUT);
                continue;
            }

            try {
                System.out.print(ProductConstants.PROMPT_KIND);
                String kind = scanner.nextLine();

                System.out.print(ProductConstants.PROMPT_NAME);
                String name = scanner.nextLine();

                System.out.print(ProductConstants.PROMPT_DETAIL);
                String detail = scanner.nextLine();

                int numOf = readValidNumber(ProductConstants.PROMPT_NUM_OF, ProductConstants.MSG_INVALID_NUM_OF);
                int price = readValidNumber(ProductConstants.PROMPT_PRICE, ProductConstants.MSG_INVALID_PRICE);

                ProductInputDto dto = new ProductInputDto(category, kind, name, detail, numOf, price);
                controller.insertProduct(dto);
                System.out.println(ProductConstants.MSG_REG_SUCCESS + "\n");
                break;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage() + "\n");
                break;
            }
        }
    }

    public void handleRead() {
        List<Product> products = controller.selectProduct();
        if (products.isEmpty()) {
            System.out.println(ProductConstants.MSG_EMPTY_LIST + "\n");
            return;
        }
        System.out.println("--- 등록된 상품/스낵 목록 ---");
        products.forEach(p -> System.out.println(p.inform()));
        System.out.println();
    }

    public void handleUpdate() {
        System.out.print(ProductConstants.PROMPT_ID);
        Long id = readLongInput();

        try {
            System.out.println(ProductConstants.MSG_UPDATE_INTRO);
            System.out.print(ProductConstants.PROMPT_KIND);
            String kind = scanner.nextLine();

            System.out.print(ProductConstants.PROMPT_NAME);
            String name = scanner.nextLine();

            System.out.print(ProductConstants.PROMPT_DETAIL);
            String detail = scanner.nextLine();

            int numOf = readValidNumber(ProductConstants.PROMPT_NUM_OF, ProductConstants.MSG_INVALID_NUM_OF);
            int price = readValidNumber(ProductConstants.PROMPT_PRICE, ProductConstants.MSG_INVALID_PRICE);

            ProductInputDto dto = new ProductInputDto(null, kind, name, detail, numOf, price);
            controller.updateProduct(id, dto);
            System.out.println(ProductConstants.MSG_UPDATE_SUCCESS + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void handleDelete() {
        System.out.print(ProductConstants.PROMPT_ID);
        Long id = readLongInput();

        try {
            controller.deleteProduct(id);
            System.out.println(ProductConstants.MSG_DELETE_SUCCESS + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void handleExit() {
        System.out.println(ProductConstants.MSG_EXIT);
        this.isRunning = false;
    }
}
