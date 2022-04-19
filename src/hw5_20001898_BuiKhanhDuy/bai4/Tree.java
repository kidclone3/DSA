package hw5_20001898_BuiKhanhDuy.bai4;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
  private Node root;

  public Tree(int root) {
    this.root = new Node(root);
    this.root.parrent = null;
  }

  public Node insert(Node parrent, int v) {
    parrent.siblings.add(new Node(v, parrent));
    return parrent.siblings.get(parrent.siblings.size() - 1);
  }

  public Node traversal(int key) {
    //        Travel to the node has key
    //        Using bfs
    Queue<Node> bfs = new LinkedList<>();
    bfs.offer(root);
    while (!bfs.isEmpty()) {
      if (bfs.peek().key == key) {
        return bfs.peek();
      }
      Node top = bfs.poll();
      for (Node adj : top.siblings) {
        bfs.add(adj);
      }
    }
    return null; // if we cannot find the key.
  }

  public boolean changeRoot(int key) { // Change from current root to new root has key.
    try {
      // if root is our wanting node => no need to change.
      if (root.key == key) {
        return true;
      }
      Node current = root = traversal(key); // newRoot
      //        What we have to change here?
      //        Some node in old tree was parent of newRoot node.
      //        So all of that node has to become siblings of the old ones, and newRoot become they
      // parent.
      //        Let start changing from newRoot (current).
      Node temp = current.parrent;
      while (current != null && temp != null) {
        Node par = temp;
        par.siblings.remove(current);
        temp = par.parrent;
        par.parrent = current;
        current.siblings.add(par);
        current = par;
      }
      root.parrent = null;
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Node getRoot() {
    return root;
  }
  public void printTree() {
//    Because I don't want to visualize this tree, so I just print into this format:
//    u : v1, v2, ...
//    First line will be root, next line will be its child.
//    Use bfs again.
    Queue<Node> bfs = new LinkedList<>();
    bfs.offer(root);
    while (!bfs.isEmpty()) {
      Node top = bfs.poll();
      System.out.print(top.key + ": ");
      for (Node adj : top.siblings) {
        System.out.print(adj.key + ", ");
        bfs.offer(adj);
      }
      System.out.println();
    }
  }
}
