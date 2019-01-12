package ds_n_algo.datastructure.linear_data_structure.stacks.Exercise;

import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BalancedParenthesis {
    public static void main(String[] args) {

        Character[][] tokens = new Character[][]{{'(', ')'}, {'{', '}'}, {'[', ']'}};

        Predicate<Character> isOpenThread = character -> {
            for (Character[] charecters : tokens
                    ) {
                if (charecters[0] == character)
                    return true;
            }
            return false;
        };
                /*Arrays.stream(tokens).map(characters -> characters[0]).equals(character);*/

        BiPredicate<Character, Character> isMatches = (openterm, closeterm) -> {

            for (Character[] charecters : tokens
                    ) {
                if (charecters[0] == openterm)
                    return charecters[1] == closeterm;
            }
            return false;
        };

        Predicate<String> isbalanced = input -> {
            Stack<Character> stack = new Stack<>();
            for (Character c : input.toCharArray()) {
                if (isOpenThread.test(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || isMatches.test(stack.pop(), c) == false)
                        return false;
                }
            }
            return stack.isEmpty();
        };

        String input = "{()}";
        System.out.println(isbalanced.test(input));
                /*Arrays.stream(tokens).map(characters -> characters[0]).equals(character1)*/

           /* for (Character[] chars:tokens
                 ) {
                    if(chars[0].equals(character))
            }*/

    }

}
