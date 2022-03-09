package hw2_20001898_BuiKhanhDuy.bai2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {
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
    int counter = selectionSort(arr);
    System.out.println("Cần " + counter + " bước để đổi chỗ!");
    System.out.println("In ra các phần tử sau khi sắp xếp");
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i] + " ");
    }
    scanner.close();

  }

  public static int selectionSort(int arr[]) {
    int counter = 0;
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minj = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minj]) minj = j;
      }
      if (minj != i) {
        counter++;
        int temp = arr[i];
        arr[i] = arr[minj];
        arr[minj] = temp;
      }
    }
    return counter;
  }
}
