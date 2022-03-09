package hw2_20001898_BuiKhanhDuy.bai5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort2 {
  private static int counter = 0;

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
    // Thay Integer bằng kiểu dữ liệu khác
    Node<Integer> arr[] = new Node[n];
    System.out.println("Nhập " + n + " phần tử trên từng dòng");
    for (int i = 0; i < n; i++) {
      arr[i] = new Node<>(scanner.nextInt());
    }
    mergeSort(arr, 0, n - 1);
    System.out.println("Cần " + counter + " bước để đổi chỗ!");
    System.out.println("In ra các phần tử sau khi sắp xếp");
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i].get() + " ");
    }
    scanner.close();
  }

  public static <T> void merge(Node<T> arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    Node<T> L[] = new Node[n1];
    Node<T> R[] = new Node[n2];

    // Copy array.
    for (int i = 0; i < n1; i++) {
      L[i] = new Node<T>(arr[left + i].get());
    }
    for (int i = 0; i < n2; i++) {
      R[i] = new Node<T>(arr[mid + 1 + i].get());
    }

    // Merge Part.
    int i = 0, j = 0, curr = left;
    while (i < n1 && j < n2) {
      if (L[i].compareTo(R[j]) <= 0) {
        arr[curr].set(L[i++].get());
      } else arr[curr].set(R[j++].get());
      curr++;
      counter++;
    }

    while (i < n1) arr[curr++].set(L[i++].get());

    while (j < n2) arr[curr++].set(R[j++].get());
  }

  public static <T> void mergeSort(Node<T> arr[], int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }
}
