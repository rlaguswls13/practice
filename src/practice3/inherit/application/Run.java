package practice3.inherit.application;

import practice3.inherit.application.config.AppConfig;
import practice3.inherit.application.menu.ProgramSelector;

public class Run {
    public static void main(String[] args) {
        // Spring 컨테이너 역할을 하는 AppConfig 인스턴스화
        AppConfig appConfig = new AppConfig();
        
        // 의존성이 모두 주입된 최상위 라우터(ProgramSelector) 획득
        ProgramSelector programSelector = appConfig.programSelector();

        // 프로그램 실행
        programSelector.mainMenu();
    }
}
