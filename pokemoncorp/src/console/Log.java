package pokemoncorp.src.console;

public class Log {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // welcome
    public static void w(String message) {
        System.out.println(ANSI_YELLOW + message + ANSI_RESET);
    }

    // info
    public static void i(String message) {
        System.out.println(ANSI_BLUE + message + ANSI_RESET);
    }

    // error
    public static void e(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    // choice
    public static void ch(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    // Winner
    public static void win(String message) {
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }

}
