package hw1;

import java.util.Scanner;

public class Bai2 {

//  static boolean isPerfect(int x) {
//    if (x == 1) return false;
//    int result;
//    result = 1;
//    for (int i = 2; i * i <= x; ++i) {
//      if (x % i == 0) {
//        result += i;
//        if (i != x/i) result += x/i;
//      }
//    }
//    return result == x;
//  }
//  static boolean isPrime(int x) {
//    if (x == 2) return true;
//    if (x % 2 == 0 || x < 2) return false;
//    for (int i = 2; i * i <= x; ++i) if (x % i == 0) return false;
//    return true;
//  }

  public static void main(String[] args) {
    // So hoan hao
    int n;
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();

    Cell<Float>[] array = new Cell[100];
    // int

    for (int i = 0; i < n; i++) {
      Float x = scanner.nextFloat();
      array[i] = new Cell<Float>(x);
//      Cell<Integer> tmp = new Cell<>(x)
//      array[i].setA(x);
    }
    System.out.println("Các số hoàn hảo là: ");
    for (int i = 0; i < n; i++) {
      if (array[i].isPerfect())
        System.out.println(array[i].getA() + " ");
    }

    System.out.println("Các số nguyên tố là: ");
    for (int i = 0; i < n; i++) {
      if (array[i].isPrime())
        System.out.println(array[i].getA() + " ");
    }
  }
}
