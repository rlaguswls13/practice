package practice3.inherit.common.utils;

import lombok.RequiredArgsConstructor;
import java.util.Scanner;

@RequiredArgsConstructor
public class InputView {

    private final Scanner sc;

    public int inputInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public String inputString(String message) {
        System.out.print(message);
        return sc.next();
    }
}
