package hackerrank.preparationkit.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class BalancedBrackets {
  // Complete the isBalanced function below.
  static boolean isOpen(char ch) {
    return Arrays.asList('{', '[', '(').contains(ch);
  }
  static boolean isClosingFor(char closing, char opened) {
    return opened == '{' && closing == '}' ||
        opened == '(' && closing == ')' ||
        opened == '[' && closing == ']';
  }
  static String isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch: s.toCharArray()) {
      if (isOpen(ch)) {
        stack.add(ch);
      } else {
        if (stack.isEmpty() || !isClosingFor(ch, stack.pop())) {
          return "NO";
        }
      }
    }
    return stack.isEmpty() ? "YES" : "NO";
  }

}
