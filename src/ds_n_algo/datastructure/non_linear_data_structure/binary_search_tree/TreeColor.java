package ds_n_algo.datastructure.non_linear_data_structure.binary_search_tree;

import java.util.function.Function;

public class TreeColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001b[37m";

    static Function<String, String> getThreadColor = nam -> {

        switch (nam) {
            case "black":
                return ANSI_BLACK;
            case "green":
                return ANSI_GREEN;
            case "red":
                return ANSI_RED;
            case "yellow":
                return ANSI_YELLOW;
            case "purple":
                return ANSI_PURPLE;
            case "blue":
                return ANSI_BLUE;
            case "cyan":
                return ANSI_CYAN;
            case "white":
                return ANSI_WHITE;
            default:
                return ANSI_RESET;

        }
    };
}
