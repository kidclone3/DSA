package hw5_20001898_BuiKhanhDuy.bai4;

import java.util.ArrayList;

public class Node {
  int key;
  Node parrent;
  ArrayList<Node> siblings;

  Node(int data) {
    key = data;
    parrent = null;
    siblings = new ArrayList<>();
  }

  Node(int data, Node parrent) {
    key = data;
    this.parrent = parrent;
    siblings = new ArrayList<>();
  }
  int getKey() {
    return key;
  }
}
