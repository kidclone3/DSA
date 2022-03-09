package hw2_20001898_BuiKhanhDuy.bai6;

public class TestDriver {
  public static void main(String[] args) {
    /*  Mô tả về các lớp theo yêu cầu đề bài.
    - Card:
      + Có các phương thức get, set.
      + Có hàm toString để xuất ra tên lá bài theo nguyên tắc (số + bộ)
    - CompareCard:
      + Hàm compareSuit theo so sánh các bộ theo thứ tự Bích, Chuồn, Rô, Cơ.
      + Hàm compare so sánh cả giá trị và bộ.
    - Generate:
      + Hàm randomGenerate: đúng như tên gọi, sẽ sinh ra bộ bài với số lá theo người dùng cần. Trong hàm main là 52 lá.
        Đảm bảo rằng không có 2 lá trùng nhau.
      + Hàm sortedGenerate: sắp xếp các lá theo thứ tự tăng dần (theo giá trị trước rồi mới đến bộ.
        Nếu cần thiết thì hãy ib mình để thêm tính năng sắp xếp theo bộ)
      + Hàm hash: Để thực hiện kĩ thuật hashing
     */
    Card[] deck = new Card[52];
    Generate.randomGenerate(deck);
    for (Card card : deck) {
      System.out.println(card.toString());
    }
  }
}
