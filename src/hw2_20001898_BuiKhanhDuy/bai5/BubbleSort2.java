package hw2_20001898_BuiKhanhDuy.bai5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BubbleSort2 {
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
    // Thay Integer bằng kiểu dữ liệu khác
    Node<Integer> arr[] = new Node[n];
    System.out.println("Nhập " + n + " phần tử trên từng dòng");
    for (int i = 0; i < n; i++) {
      arr[i] = new Node<>(scanner.nextInt());
    }
    int counter = bubbleSort(arr);
    System.out.println("Cần " + counter + " bước để đổi chỗ!");
    System.out.println("In ra các phần tử sau khi sắp xếp");
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i].get() + " ");
    }
    scanner.close();
  }

  public static <T> int bubbleSort(Node<T>[] arr) {
    int counter = 0;
    int n = arr.length;
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
        if (arr[j].compareTo(arr[j - 1]) < 0) {
          T temp = arr[j].get();
          arr[j].set(arr[j - 1].get());
          arr[j - 1].set(temp);
          counter++;
        }
      }
    }
    return counter;
  }
}
