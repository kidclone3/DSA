package hw2_20001898_BuiKhanhDuy.bai6;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
  public int compareSuit(Card card1, Card card2) {
    if (card1.getSuit() == card2.getSuit()) return 0;
    // Order = {S, C, D, H}, stand for
    // S = spades, C = clubs, D = diamond, H = hearts;
    char[] order = {'S', 'C', 'D', 'H'};
    int card1_i, card2_i;
    for (card1_i = 0; card1_i < 4; ++card1_i) {
      if (order[card1_i] == card1.getSuit()) break;
    }
    for (card2_i = 0; card2_i < 4; ++card2_i) {
      if (order[card2_i] == card2.getSuit()) break;
    }
    return card1_i - card2_i;
  }

  @Override
  public int compare(Card card1, Card card2) {
    if (card1.getRank() == card2.getRank()) {
      return compareSuit(card1, card2);
    } else return card1.getRank() - card2.getRank();
  }
}
