package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * 
 * @author wangding 时间：2018年8月21日 下午3:42:00 给定一个表达式字符串数组，写一个函数返回该表达式的逆波兰表达式(即去掉括号) 例子:3 + 4 * 5
 *         逆波兰表达式：3 4 5 * +
 */
public class PolanDemo {

  public static void main(String[] args) {
    String expression = "1+2*3-(10+5*2)/5";
    String result = getInverSePolan(expression);
    System.out.println("初始表达式  " + expression);
    System.out.println("逆波兰表达式 " + result);
    int resultData = getNPLValues(result);
    System.out.println("resultData = " + resultData);
  }
  
  /**
   * 
   * 中缀表达式转换为逆波兰表达式
   */
  public static String getInverSePolan(String expression) {
    StringTokenizer test = new StringTokenizer(expression, "()+-*/", true);
    List<String> oldList = new ArrayList<String>();
    Stack<String> output = new Stack<String>();
    Stack<String> operators = new Stack<String>();
    while (test.hasMoreTokens()) {
      String text = test.nextToken();
      oldList.add(text);
    }
    for (int i = 0; i < oldList.size(); i++) {
      String num = oldList.get(i);
      if (isInteger(num)) {
        output.push(num);
      } else {
        if (operators.isEmpty()) {
          operators.push(num);
        } else {
          // 包含操作符之后，进行括号判断
          switch (num) {
            case "(":
              operators.push(num);
              break;
            case ")":
              // 把多余的运算符从栈中弹出
              while (!operators.isEmpty() && !"(".equals(operators.peek())) {
                output.push(operators.pop());
              }
              operators.pop();
              break;

            default:
              // 不是括号的计算方式
              if (!operators.isEmpty()) {
                // 包含(的
                if (operators.contains("(")) {
                  if (isPriority(num) <= isPriority(operators.peek()) && !"(".equals(operators.peek())) {
                    while (!"(".equals(operators.peek()) && !operators.isEmpty() && isPriority(num) <= isPriority(operators.peek())) {
                      output.push(operators.pop());
                    }
                    // 栈中移除左括号
                    operators.pop();
                    operators.push(num);
                  } else {
                    operators.push(num);
                  }
                } else {
                  // 不包含(的计算方式
                  if (isPriority(num) <= isPriority(operators.peek())) {
                    while (!operators.isEmpty() && isPriority(num) <= isPriority(operators.peek())) {
                      output.push(operators.pop());
                    }
                    operators.push(num);
                  } else {
                    operators.push(num);
                  }
                }
              } else {
                operators.push(num);
              }
              break;
          }
        }
      }
    }

    while (!operators.isEmpty()) {
      output.push(operators.pop());
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < output.size(); i++) {
      sb.append(output.get(i) + " ");
    }
    return sb.toString();
  }

  public static boolean isInteger(String str) {
    Pattern pattern = Pattern.compile("^[\\d]*$");
    return pattern.matcher(str).matches();
  }

  public static int isPriority(String operator) {
    int priority = 0;
    switch (operator) {
      case "(":
        priority = 3;
        break;
      case ")":
        priority = 3;
        break;
      case "*":
        priority = 2;
        break;
      case "/":
        priority = 2;
        break;
      case "+":
        priority = 1;
        break;
      case "-":
        priority = 1;
        break;
    }
    return priority;
  }

  /**
   * 逆波兰表达式求值
   * 
   * @param express
   * @return
   */
  public static int getNPLValues(String express) {
    int result = 0;
    Stack<String> output = new Stack<String>();
    StringTokenizer test = new StringTokenizer(express, " ", false);
    List<String> oldList = new ArrayList<String>();
    while (test.hasMoreTokens()) {
      String text = test.nextToken();
      oldList.add(text);
    }
    for (int i = 0; i < oldList.size(); i++) {
      String num = oldList.get(i);
      if (isInteger(num)) {
        output.push(num);
      } else {
        if (!output.isEmpty()) {
          int lastNum = Integer.parseInt(output.pop());
          int secondNum = Integer.parseInt(output.pop());
          int newNum = 0;
          switch (num) {
            case "+":
              newNum = lastNum + secondNum;
              output.push(newNum + "");
              break;
            case "-":
              newNum = secondNum - lastNum;
              output.push(newNum + "");
              break;
            case "*":
              newNum = lastNum * secondNum;
              output.push(newNum + "");
              break;
            case "/":
              newNum = secondNum / lastNum;
              output.push(newNum + "");
              break;
          }
        }
      }
    }
    result = Integer.parseInt(output.pop());
    return result;
  }
  
  /**
   * 波兰表达式转逆波兰表达式
   * @param express
   * @return
   */
  public static String getNPL2PL(String express) {
    
    
    return null;
  }

}
