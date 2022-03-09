package hw2_20001898_BuiKhanhDuy.bai6;

public class Card extends CompareCard {
    private int rank;
    private char suit;
    public Card() {}
    protected Card(int rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    protected void setRank(int rank) {
        this.rank = rank;
    }

    public char getSuit() {
        return suit;
    }

    protected void setSuit(char suit) {
        this.suit = suit;
    }
    @Override
    public String toString() {
        return String.valueOf(rank) + String.valueOf(suit);

    }
}
