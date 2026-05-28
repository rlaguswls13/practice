package product.menu;

import product.ProductConstants;
import product.controller.ProductController;
import product.dto.ProductInputDto;
import product.entity.Product;
import product.type.ProductCategory;
import product.type.ProductQueryOption;

import java.util.List;
import java.util.Optional;
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
            ProductCategory.displayMenu();
            System.out.print(ProductConstants.PROMPT_MENU_CHOICE);
            int regChoice = readIntegerInput();
            System.out.println();

            if (regChoice == 9) {
                break;
            }

            Optional<ProductCategory> categoryOpt = ProductCategory.fromCode(regChoice);
            if (categoryOpt.isEmpty()) {
                System.out.println(ProductConstants.MSG_INVALID_INPUT);
                continue;
            }
            ProductCategory category = categoryOpt.get();

            try {
                System.out.print(ProductConstants.PROMPT_KIND);
                String kind = scanner.nextLine();

                System.out.print(ProductConstants.PROMPT_NAME);
                String name = scanner.nextLine();

                // 카테고리별 동적 상세 프롬프트 출력
                String detailPrompt = getDetailPrompt(category);
                System.out.print(detailPrompt);
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
        while (true) {
            ProductQueryOption.displayMenu();
            System.out.print(ProductConstants.PROMPT_MENU_CHOICE);
            int searchChoice = readIntegerInput();
            System.out.println();

            if (searchChoice == 9) {
                break;
            }

            Optional<ProductQueryOption> queryOpt = ProductQueryOption.fromCode(searchChoice);
            if (queryOpt.isEmpty()) {
                System.out.println(ProductConstants.MSG_INVALID_INPUT);
                continue;
            }

            switch (queryOpt.get()) {
                case ALL:
                    queryAll();
                    break;
                case BY_ID:
                    queryById();
                    break;
                case BY_CATEGORY:
                    queryByCategory();
                    break;
                case BY_BRAND:
                    queryByBrand();
                    break;
                case BY_PRICE:
                    queryByPrice();
                    break;
                default:
                    System.out.println(ProductConstants.MSG_INVALID_INPUT);
            }
        }
    }

    private void queryAll() {
        List<Product> products = controller.selectProduct();
        displayProductList("--- 등록된 상품/스낵 목록 ---", products);
    }

    private void queryById() {
        System.out.print(ProductConstants.PROMPT_ID);
        Long id = readLongInput();
        controller.selectProductById(id).ifPresentOrElse(
                p -> {
                    System.out.println("--- 상품 상세 정보 ---");
                    System.out.println(p.inform());
                    System.out.println();
                },
                () -> System.out.println(ProductConstants.MSG_NOT_FOUND + "\n")
        );
    }

    private void queryByCategory() {
        System.out.print(ProductConstants.PROMPT_SEARCH_CATEGORY);
        int categoryCode = readIntegerInput();
        ProductCategory.fromCode(categoryCode).ifPresentOrElse(
                category -> {
                    List<Product> products = controller.selectProductByCategory(category);
                    displayProductList("--- 카테고리 [" + category.getDescription() + "] 검색 결과 ---", products);
                },
                () -> System.out.println(ProductConstants.MSG_INVALID_INPUT)
        );
    }

    private void queryByBrand() {
        System.out.print(ProductConstants.PROMPT_SEARCH_BRAND);
        String keyword = scanner.nextLine();
        List<Product> products = controller.selectProductByBrand(keyword);
        displayProductList("--- 브랜드/맛/품종 [" + keyword + "] 검색 결과 ---", products);
    }

    private void queryByPrice() {
        int maxPrice = readValidNumber(ProductConstants.PROMPT_SEARCH_PRICE, ProductConstants.MSG_INVALID_PRICE);
        List<Product> products = controller.selectProductByPriceLessThanOrEqual(maxPrice);
        displayProductList("--- 가격 [" + maxPrice + "원 이하] 검색 결과 ---", products);
    }

    private void displayProductList(String title, List<Product> list) {
        if (list.isEmpty()) {
            System.out.println(ProductConstants.MSG_EMPTY_LIST + "\n");
            return;
        }
        System.out.println(title);
        list.forEach(p -> System.out.println(p.inform()));
        System.out.println();
    }

    private String getDetailPrompt(ProductCategory category) {
        if (category == ProductCategory.GENERAL) {
            return ProductConstants.PROMPT_DETAIL_GENERAL;
        } else if (category == ProductCategory.SNACK) {
            return ProductConstants.PROMPT_DETAIL_SNACK;
        } else {
            return ProductConstants.PROMPT_DETAIL_FRUIT;
        }
    }

    public void handleUpdate() {
        System.out.print(ProductConstants.PROMPT_ID);
        Long id = readLongInput();

        Optional<Product> originalOpt = controller.selectProductById(id);
        if (originalOpt.isEmpty()) {
            System.out.println(ProductConstants.MSG_NOT_FOUND + "\n");
            return;
        }
        Product original = originalOpt.get();

        try {
            System.out.println(ProductConstants.MSG_UPDATE_INTRO);
            System.out.print(ProductConstants.PROMPT_KIND);
            String kind = scanner.nextLine();

            System.out.print(ProductConstants.PROMPT_NAME);
            String name = scanner.nextLine();

            // 기존 등록된 카테고리에 맞는 동적 상세 필드 프롬프트 출력
            String detailPrompt = getDetailPrompt(original.getCategory());
            System.out.print(detailPrompt);
            String detail = scanner.nextLine();

            int numOf = readValidNumber(ProductConstants.PROMPT_NUM_OF, ProductConstants.MSG_INVALID_NUM_OF);
            int price = readValidNumber(ProductConstants.PROMPT_PRICE, ProductConstants.MSG_INVALID_PRICE);

            ProductInputDto dto = new ProductInputDto(original.getCategory(), kind, name, detail, numOf, price);
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

