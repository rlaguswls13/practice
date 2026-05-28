import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            SystemOption.displayMenu();
            System.out.print(SystemConstants.PROMPT_SERVICE_CHOICE);

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                System.out.println();

                SystemOption.fromCode(choice).ifPresentOrElse(
                        option -> {
                            option.execute();
                            if (option == SystemOption.EXIT) {
                                System.exit(0);
                            }
                        },
                        () -> System.out.println(SystemConstants.MSG_INVALID_CHOICE)
                );
            } catch (Exception e) {
                System.out.println(SystemConstants.MSG_PARSE_ERROR);
                sc.nextLine(); // 버퍼 비우기
            }
        }
    }
}
