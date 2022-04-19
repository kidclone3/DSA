package hw4_20001898_BuiKhanhDuy.bai5;

import hw4.Stack.Stack;
import hw4_20001898_BuiKhanhDuy.bai2.LinkedListStack;

public class Palindrome {
  public static void main(String[] args) {
    //
    String s = "abbcbbb";
      System.out.println("Xau can kiem tra la s: " + s);
    System.out.println("Xau " + (isPalin(s)? "la Palindrome" : "khong phai Palindrome") + "");
  }
  public static boolean isPalin(String s) {
      // ý tưởng kiểm tra palin hay không: Dùng stack để đảo ngược xâu.
      LinkedListStack<Character> stack = new LinkedListStack<>();
      for (int i = 0; i < s.length(); i++) {
          stack.push(s.charAt(i));
      }
      // Ktra palin hay ko
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != stack.pop().charValue()) return false;
      }
      return true;
  }
}
