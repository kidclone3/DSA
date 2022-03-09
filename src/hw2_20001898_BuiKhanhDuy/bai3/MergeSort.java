package hw2_20001898_BuiKhanhDuy.bai3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {
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
    int arr[] = new int[n];
    System.out.println("Nhập " + n + " phần tử trên từng dòng");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    mergeSort(arr, 0, n-1);
    System.out.println("Cần " + counter + " bước để đổi chỗ!");
    System.out.println("In ra các phần tử sau khi sắp xếp");
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i] + " ");
    }
    scanner.close();
  }
  public static void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int L[] = new int[n1];
    int R[] = new int[n2];

    // Copy array.
    for(int i = 0; i < n1; i++) {
      L[i] = arr[left+i];
    }
    for(int i = 0; i < n2; i++) {
      R[i] = arr[mid+1+i];
    }

    // Merge Part.
    int i = 0, j = 0, curr = left;
    while(i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[curr] = L[i++];
      } else arr[curr] = R[j++];
      curr++;
      counter++;
    }

    while (i < n1) arr[curr++] = L[i++];

    while (j < n2) arr[curr++] = R[j++];
  }
  public static void mergeSort(int arr[], int left, int right) {
    if (left < right) {
      int mid = (left + right)/2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid+1, right);
      merge(arr, left, mid, right);
    }
  }
}
