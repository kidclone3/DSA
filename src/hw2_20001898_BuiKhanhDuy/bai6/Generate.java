package hw2_20001898_BuiKhanhDuy.bai6;

import java.util.Arrays;
import java.util.Random;

public class Generate {
  public static int hash(int rank, int suit) {
      return rank*10 + suit;
  }
  public static void randomGenerate(Card[] deck) {
    // Generate + shuffle the cards.
    // Generate 52 cards
    char[] suits = {'S', 'C', 'D', 'H'};
    boolean[] mark = new boolean[1000];
    Random random = new Random();
    for (int i = 0; i < deck.length; i++) {
      int rank = random.nextInt(1, 14);
      int suit = random.nextInt(0, 4);

//      Because in this time, we haven't learnt HashMap + HashSet yet.
//      So I use this potato way.
      while (mark[hash(rank, suit)]) {
        rank = random.nextInt(1, 14);
        suit = random.nextInt(0, 4);
      }
      mark[hash(rank, suit)] = true;
      deck[i] = new Card(rank, suits[suit]);
    }
  }
  public static void sortedGenerate(Card[] deck) {
    randomGenerate(deck);
    Arrays.sort(deck, (a, b) -> a.compare(a, b));
  }

  public static void main(String[] args) {

    Card[] deck = new Card[52];

    randomGenerate(deck);
    for (int i = 0; i < 52; i++) {
      System.out.println(deck[i].toString());
    }
//    sortedGenerate(deck);
  }
}
