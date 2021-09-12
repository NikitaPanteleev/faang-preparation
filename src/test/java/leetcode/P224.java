package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/
public class P224 {
  public static void main(String[] args) {
    assert(new P224().calculate("(1+(4+5+2)-3)-(6+8)") == -5);
    assert(new P224().calculate("2147483647") == 2147483647);
  }

  public int calculate(String s) {
    List<String> terms = createTerms(s);
    Stack<String> stack = new Stack<>();
//    System.out.println(terms);
    for (String elem: terms) {
      if (elem.equals(")")) {
        simplifyStack(stack);
      } else {
        stack.push(elem);
      }
//      System.out.println(stack);
    }
    simplifyStack(stack);

    return Integer.parseInt(stack.pop());
  }

  private void simplifyStack(Stack<String> stack) {
    int currentValue = 0;
    while (!stack.isEmpty()) {
      String current = stack.pop();
      if (current.equals("(")) {
        stack.push(currentValue+"");
        return;
      } else if (current.equals("-(")){
        stack.push((-currentValue) + "");
        return;
      } else{
        currentValue+=Integer.parseInt(current);
      }
    }
    stack.push(currentValue+"");
    return;
  }

  private List<String> createTerms(String s) {
    char[] input = s.replaceAll(" ", "").toCharArray();
    int i = 0;
    List<String> terms = new ArrayList<>();
    StringBuilder current = new StringBuilder();
    while(i < input.length) {
      if (input[i] == '(' || input[i] == ')') {
        if (!current.toString().isEmpty()) {
          terms.add(current.toString());
          current = new StringBuilder();
        }
        terms.add(input[i]+"");
      } else if(input[i] == '-' || input[i] == '+') {
        if (!current.toString().isEmpty()) {
          terms.add(current.toString());
          current = new StringBuilder();
        }
        if (input[i] == '+' && input[i+1] == '(') {
          terms.add("(");
          i++;
        } else if(input[i] == '-' && input[i+1] == '(') {
          terms.add("-(");
          i++;
        } else if (input[i] == '-') {
          current.append(input[i]);
        }

      } else {
        current.append(input[i]);
      }
      i++;
    }
    if (!current.toString().isEmpty()) {
      terms.add(current.toString());
    }
    return terms;
  }
}
