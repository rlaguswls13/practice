package product.menu;

import product.ProductConstants;
import product.controller.ProductController;
import product.dto.ProductInputDto;
import product.entity.Product;
import product.prompt.Prompt;
import product.prompt.MainPrompt;
import product.prompt.InsertPrompt;
import product.prompt.SelectPrompt;
import product.type.SelectConditionType;

import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private final ProductController controller = new ProductController();
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;

    public void mainMenu() {
        this.isRunning = true; // 대시보드에서 매번 다시 진입할 때를 대비
        while (isRunning) {
            MenuOption.displayMenu();
            printMenuPrompt();
            int choice = readIntegerInput();
            processCommand(choice);
        }
    }

    private void printMenuPrompt() {
        System.out.print(MainPrompt.MENU_NUM.getText());
    }

    private void printPrompt(Prompt prompt) {
        System.out.print(prompt.getText());
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

    private void processCommand(int choice) {
        MenuOption.fromCode(choice).ifPresentOrElse(
                option -> option.execute(this),
                () -> System.out.println(ProductConstants.MSG_INVALID_INPUT)
        );
    }

    public void handleInsertProduct() {
        try {
            executeInsertStage();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    private void executeInsertStage() {
        printPrompt(InsertPrompt.PRODUCT_NAME);
        String name = scanner.nextLine();

        int price = readValidPrice();

        printPrompt(InsertPrompt.PRODUCT_BRAND);
        String brand = scanner.nextLine();

        ProductInputDto dto = new ProductInputDto(name, price, brand);
        controller.insertProduct(dto);
    }

    private int readValidPrice() {
        while (true) {
            printPrompt(InsertPrompt.PRODUCT_PRICE);
            try {
                int price = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                if (price < 0) {
                    System.out.println(ProductConstants.MSG_INVALID_PRICE);
                    continue;
                }
                return price;
            } catch (Exception e) {
                System.out.println(ProductConstants.MSG_INVALID_PRICE);
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    public void handleSelectAllProducts() {
        SelectConditionType.displayMenu();
        printPrompt(MainPrompt.SELECT_TYPE_NUM);
        int choice = readIntegerInput();

        SelectConditionType.fromCode(choice).ifPresentOrElse(
                type -> type.execute(this),
                () -> System.out.println(ProductConstants.MSG_INVALID_INPUT)
        );
        System.out.println();
    }

    public void handleSelectAll() {
        List<Product> products = controller.selectProduct();
        displayProducts(products);
    }

    public void handleSelectByBrand() {
        printPrompt(SelectPrompt.SEARCH_BRAND);
        String brand = scanner.nextLine();
        List<Product> products = controller.selectProductByBrand(brand);
        displayProducts(products);
    }

    public void handleSelectByPrice() {
        while (true) {
            printPrompt(SelectPrompt.SEARCH_PRICE);
            try {
                int price = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                if (price < 0) {
                    System.out.println(ProductConstants.MSG_INVALID_PRICE);
                    continue;
                }
                List<Product> products = controller.selectProductByPriceLessThanOrEqual(price);
                displayProducts(products);
                break;
            } catch (Exception e) {
                System.out.println(ProductConstants.MSG_INVALID_PRICE);
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("조회된 상품이 없습니다.");
            return;
        }
        products.stream()
                .map(Product::inform)
                .forEach(System.out::println);
    }

    public void handleExit() {
        System.out.println(ProductConstants.MSG_EXIT);
        this.isRunning = false;
    }
}
