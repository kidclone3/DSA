package hw1;

import java.util.Scanner;

public class Bai5 {
  /* Write a short Java program that takes all the lines input to standard input and
  writes them to standard output in reverse order. That is, each line is output in the
  correct order, but the ordering of the lines is reversed.
       */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      StringBuilder s = new StringBuilder(sc.nextLine());
      s.reverse();
      System.out.println(s);
    }
  }
}
