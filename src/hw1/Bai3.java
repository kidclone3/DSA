package hw1;

import java.util.ArrayList;
import java.util.Scanner;

class Fraction {
  private int numerator, denominator;

  int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  void reduce() {
    int common = gcd(Math.abs(numerator), Math.abs(denominator));
    numerator /= common;
    denominator /= common;
  }

  Fraction() {numerator = 1; denominator = 1;}
  Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    reduce();
  }

  void print() {
    System.out.println(numerator + " / " + denominator);
  }

  static Fraction add(Fraction a, Fraction b) {
    Fraction result = new Fraction();
    result.numerator = a.numerator * b.denominator + b.numerator * a.denominator;
    result.denominator = a.denominator * b.denominator;
    result.reduce();
    return result;
  }
  static Fraction minus(Fraction a, Fraction b) {
    Fraction result = new Fraction();
    result.numerator = a.numerator * b.denominator - b.numerator * a.denominator;
    result.denominator = a.denominator * b.denominator;
    result.reduce();
    return result;
  }
  static Fraction muliply(Fraction a, Fraction b) {
    Fraction result = new Fraction();
    result.numerator = a.numerator * b.numerator;
    result.denominator = a.denominator * b.denominator;
    result.reduce();
    return result;
  }
  static Fraction divide(Fraction a, Fraction b) {
    Fraction result = new Fraction();
    result.numerator = a.numerator * b.denominator;
    result.denominator = a.denominator * b.numerator;
    result.reduce();
    return result;
  }
}

public class Bai3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numerator, denominator;
    System.out.println("Mỗi phân số được nhập trên 1 dòng, tử và mẫu tách bởi dấu cách.");

    int n;
    System.out.println("Nhập số lượng phân số: ");
    n = scanner.nextInt();
    ArrayList<Fraction> array = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      System.out.println("Nhập phân số thứ " + (i+1) + ":");
      numerator = scanner.nextInt();
      denominator = scanner.nextInt();
      array.add(new Fraction(numerator, denominator));

    }
    System.out.println("Tổng các phân số là: ");
    Fraction result = array.get(0);
    for (int i = 1; i < n; i++) {
      result = Fraction.add(result, array.get(i));
    }
    result.print();

    System.out.println("Hiệu của phân số thứ 1 với các phân số còn lại là: ");
    result = array.get(0);
    for (int i = 1; i < n; i++) {
      result = Fraction.minus(result, array.get(i));
    }
    result.print();

    System.out.println("Tích các phân số là: ");
    result = array.get(0);
    for (int i = 1; i < n; i++) {
      result = Fraction.muliply(result, array.get(i));
    }
    result.print();

    System.out.println("Thương của phân số thứ 1 với các phân số còn lại là: ");
    result = array.get(0);
    for (int i = 1; i < n; i++) {
      result = Fraction.divide(result, array.get(i));
    }
    result.print();

  }
}
