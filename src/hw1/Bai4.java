package hw1;

import java.util.Scanner;

class Sphere {
  private double r, x, y, z;

  Sphere() {}

  Sphere(double r, double x, double y, double z) {
    this.r = r;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  void input(Scanner scanner) {
    this.r = scanner.nextDouble();
    this.x = scanner.nextDouble();
    this.y = scanner.nextDouble();
    this.z = scanner.nextDouble();
  }

  double surfaceArea() {
    return 4 * Math.PI * r * r;
  }

  double volume() {
    return 4.0 / 3 * Math.PI * r * r * r;
  }

  static double powTwo(double x) {
    return x * x;
  }

  static double getDistance(Sphere a, Sphere b) {
    return Math.abs(powTwo(a.x - b.x) + powTwo(a.y - b.y) + powTwo(a.z - b.z));
  }

  static boolean isCover(Sphere a, Sphere b) {
    double distance = getDistance(a, b);
    if (a.r > b.r) {
      return distance + b.r <= a.r;
    } else {
      return distance + a.r <= b.r;
    }
  }

  static boolean isIntersect(Sphere a, Sphere b) {
    if (isCover(a, b)) return false;
    return a.r + b.r > getDistance(a, b);
  }
}

public class Bai4 {
  public static void main(String[] args) {
    //
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập hình cầu 1");
    Sphere sphere1 = new Sphere();
    sphere1.input(scanner);
    System.out.println("Diện tích xung quanh = " + sphere1.surfaceArea());
    System.out.println("Thể tích = " + sphere1.volume());

    System.out.println("Nhập hình cầu 2");
    Sphere sphere2 = new Sphere();
    sphere2.input(scanner);
    System.out.println("Diện tích xung quanh = " + sphere2.surfaceArea());
    System.out.println("Thể tích = " + sphere2.volume());

    System.out.println("Hình cầu 1 và 2 có bọc nhau không? " + Sphere.isCover(sphere1, sphere2));
    System.out.println("Hình cầu 1 và 2 có giao nhau không? " + Sphere.isIntersect(sphere1, sphere2));
  }
}
