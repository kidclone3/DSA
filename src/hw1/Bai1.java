package hw1;

import java.util.Scanner;

public class Bai1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập vào số int: ");
    int x1 = scanner.nextInt();
    scanner.nextLine();
    System.out.println( "Int " + x1);

    System.out.println("Nhập vào số double: ");
    double x2 = scanner.nextDouble();
    scanner.nextLine();
    System.out.println( "Double " + x2);

    System.out.println("Nhập vào 1 kí tự char: ");
    char x3 = scanner.nextLine().charAt(0);
    System.out.println("Char " + x3);

    System.out.println("Nhập vào số byte: ");
    byte x4 = scanner.nextByte();
    scanner.nextLine();
    System.out.println( "Byte " + x4);

    System.out.println("Nhập vào số short: ");
    short x5 = scanner.nextShort();
    scanner.nextLine();
    System.out.println( "Short " + x5);

    System.out.println("Nhập vào số long: ");
    long x6 = scanner.nextLong();
    System.out.println( "Long " + x6);

    System.out.println("Nhập vào boolean: ");
    boolean x7 = scanner.nextBoolean();
    scanner.nextLine();
    System.out.println( "Boolean " + x7);

    System.out.println("Nhập vào số float: ");
    float x8 = scanner.nextFloat();
    scanner.nextLine();
    System.out.println( "Float " + x8);

//      byte, short, int, long, char, boolean, float, và double
  }
}
