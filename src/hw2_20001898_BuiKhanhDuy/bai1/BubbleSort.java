package hw2_20001898_BuiKhanhDuy.bai1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BubbleSort {
  public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
    Scanner scanner;
    try {
      File obj = new File("src/hw2/input.txt");
      scanner = new Scanner(obj);
    } catch (FileNotFoundException e) {
      scanner = new Scanner(System.in);
    }
    int n;
    System.out.println("Nhập Số n: ");
    n = scanner.nextInt();
    int arr[] = new int[n];
    System.out.println("Nhập " + n + " phần tử trên từng dòng");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    int counter = bubbleSort(arr);
    System.out.println("Cần " + counter + " bước để đổi chỗ!");
    System.out.println("In ra các phần tử sau khi sắp xếp");
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i] + " ");
    }
    scanner.close();
  }

  public static int bubbleSort(int arr[]) {
    int counter = 0;
    int n = arr.length;
    // C1
    //    for (int i = 0; i < n - 1; i++) {
    //      for (int j = i+1; j < n; j++) {
    //        if (arr[j] < arr[i]) {
    //          int temp = arr[j];
    //          arr[j] = arr[i];
    //          arr[i] = temp;
    //          counter++;
    //        }
    //      }
    //    }
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n - i; j++) {
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          counter++;
        }
      }
    }
    return counter;
  }
}
