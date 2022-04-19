package hw5_20001898_BuiKhanhDuy.bai4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestDriver {
  public static void main(String[] args) {
    //    Input format:
    //    First line: n (int): number of nodes
    //    Second line: r (int): root
    //    Third line: m (int): number of edges
    //    m lines later: u v (int, int): edge from node u to node v, u is parent of v.
    //    Input must in order from higher level to lower level.
    //    Last line: p (int): Node become root.
    //    r, u, v, p in range [1, n]. u != v.
    //    Example:
    //        4
    //     /  |  \
    //    3   1   2
    //           / \
    //          5   6
    //    => input will be:
//        6
//        4
//        5
//        4 3
//        4 1
//        4 2
//        2 5
//        2 6
//        2

//    Input2:
//            1
//          /   \
//         2     3
//        / \   / \
//       4   5 9   10
//      / \   \
//     6   7   8
//      10
//      1
//      9
//      1 2
//      1 3
//      2 4
//      2 5
//      3 9
//      3 10
//      4 6
//      4 7
//      5 8
//      4
    Scanner sc;
    try{
      sc = new Scanner(new File("/home/delus/Documents/Projects/school/DSA/src/hw5_20001898_BuiKhanhDuy/bai4/input2.txt"));
    } catch (FileNotFoundException e) {
      sc = new Scanner(System.in);
    }
    new Scanner(System.in);
    int n = 0;
    n = sc.nextInt();
    int r = 0;
    r = sc.nextInt();
    Tree generalTree = new Tree(r);

    int m = 0;
    m = sc.nextInt();
    ArrayList<ArrayList<Integer>> adjs = new ArrayList<>(n + 1);
    for (int i = 0; i < n+1; i++) { // start from 1.
      adjs.add(new ArrayList<>());
    }
    //    System.out.println(adjs.size());
    Deque<Integer> queue = new ArrayDeque<>();
    // Create an adjacencies list.
    //    Now we make a graph version of the input
    for (int i = 0; i < m; ++i) {
      int u, v;
      u = sc.nextInt();
      v = sc.nextInt();
      adjs.get(u).add(v);
      if (queue.isEmpty() || u != queue.getLast()) {
        queue.offerLast(u);
      }
    }
    int x = 0;
    x = sc.nextInt(); // node change to root.
    //    From that graph version, make it become tree.
    //    Use a queue to save the siblings nodes from parent.
    Queue<Node> queueSibling = new LinkedList<>();
    queueSibling.offer(generalTree.getRoot());
    while (!queueSibling.isEmpty()) {
      Node top = queueSibling.poll();
      for (Integer adj : adjs.get(top.getKey())) {
        Node child = generalTree.insert(top, adj);
        queueSibling.offer(child);
      }
    }
//    Now is done the input.
    boolean status = generalTree.changeRoot(x);
    System.out.println(status);
    generalTree.printTree();
  }
}
