package coms3620.fashion;

public class Main {

    public static void main(String[] args) {
        splashScreen();
        FashionManager fashion_manager = new FashionManager();
        fashion_manager.enter_menu();
    }

    private static void splashScreen() {
        System.out.print("\033[32m"); // bright green
        System.out.println(
"""
╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                                ║
║        ▄████  ██      ▄▄▄▄▄    ▄  █ ▄█ ████▄    ▄       █▀▄▀█ ██      ▄   ██     ▄▀  ▄███▄   █▄▄▄▄             ║
║        █▀   ▀ █ █    █     ▀▄ █   █ ██ █   █     █      █ █ █ █ █      █  █ █  ▄▀    █▀   ▀  █  ▄▀             ║
║        █▀▀    █▄▄█ ▄  ▀▀▀▀▄   ██▀▀█ ██ █   █ ██   █     █ ▄ █ █▄▄█ ██   █ █▄▄█ █ ▀▄  ██▄▄    █▀▀▌              ║
║        █      █  █  ▀▄▄▄▄▀    █   █ ▐█ ▀████ █ █  █     █   █ █  █ █ █  █ █  █ █   █ █▄   ▄▀ █  █              ║
║         █        █               █   ▐       █  █ █        █     █ █  █ █    █  ███  ▀███▀     █               ║
║          ▀      █               ▀            █   ██       ▀     █  █   ██   █                 ▀                ║
║                ▀                                               ▀           ▀                                   ║
║                                                                                                                ║
║                                 ╔════════════════════════════════════════════╗                                 ║
║                                 ║        WELCOME TO GROUP 0  TERMINAL        ║                                 ║
║                                 ╚════════════════════════════════════════════╝                                 ║
║                                                                                                                ║
║                                 >>> Press [ENTER] to initialize system... <<<                                  ║
╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
"""
        );
        System.out.print("\033[0m"); // reset color
        new java.util.Scanner(System.in).nextLine(); // pause
    }

}
