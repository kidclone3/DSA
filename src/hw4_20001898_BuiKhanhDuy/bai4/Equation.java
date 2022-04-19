package hw4_20001898_BuiKhanhDuy.bai4;

import hw4_20001898_BuiKhanhDuy.bai2.LinkedListStack;

public class Equation {

  public static void main(String[] args) {
    /*
        Sử dụng stack viết chương trình xét tính hợp lệ về dấu ngoặc của biểu thức:
        Ví dụ biểu thức hợp lệ về dấu ngoặc
                (a - b) * (c + d)
        (10 + 8) / ( (5 - 2) * 17)

    Ví dụ biểu thức không hợp lệ về dấu ngoặc
            (a + b) * c – d)
        (10– 8 / ( (2 + 5) * 17)
             */
    // Check if legit in bracket;

//    String input = "(a - b) * (c + d)";
    String input = "10– 8 / ( (2 + 5) * 17)";
    boolean isOk = isRightBracket(input);
    if (!isOk) {
      System.out.println("Không là dãy ngoặc đúng ");
      // Kết thúc luôn.
      return;
    } else {
      System.out.println("Đây là dãy ngoặc đúng");
    }
    // Neu la bieu thuc chua so' thi` moi' tinh' duoc
    if (!isEquation(input)) {
      System.out.println("Chua chu cai, nen khong tinh duoc");
    } else { // Neu nó là biểu thức, tính được => gọi hàm để tính.
      int ans = evaluate(input);
      System.out.println("Ket qua cua bieu thuc la: " + ans);
    }
  }
  public static int precedence(char operator) { // Hàm xác định mức độ ưu tiên của các toán tử.
    if (operator == '+' || operator == '-') {
      return 1;
    } else if (operator == '*' || operator == '/') {
      return 2; // Hạng cao nhất
    }
    return 0; // ngoài ra thì là 0, đơn cử là các dấu ngoặc.
  }
  public static int applyOperator(int a, int b, char operator) {
    if (operator == '+') {
      return a + b;
    } else if (operator == '-') {
      return a - b;
    } else if (operator == '*') {
      return a*b;
    } else if (operator == '/') {
      if (b == 0) throw new UnsupportedOperationException("Divide by zero");
      return a/b;
    }
    return 0;
  }

  public static int evaluate(String token) {
    LinkedListStack<Character> operators = new LinkedListStack<>();
    LinkedListStack<Integer> numbers = new LinkedListStack<>();
    boolean isTrue = true;
    for (int i = 0; i < token.length(); i++) {
      char tmp = token.charAt(i);
      if (tmp == '(') operators.push(tmp);
      else if (isDigit(tmp)) {
        int val = 0;
        // Có thể có nhiều hơn 1 chữ số, nên ta duyệt hết.
        while (i < token.length() && isDigit(token.charAt(i))) {
          val = val*10 + (token.charAt(i) - '0');
          i++;
        }
        numbers.push(val);
        i--; // Thụt về để không làm ảnh hưởng đến lệnh i++ trên vòng for.
      } else if (tmp == ')') { // Nếu gặp dấu đóng ngoặc thì sao?
        while(!operators.isEmpty() && operators.top() != '(') {
          int b = numbers.pop();
          int a = numbers.pop();
          // đổi như này cho dễ theo logic a +-*/ b. Chứ để ngược lại hơi khó nhìn.
          numbers.push(applyOperator(a, b, operators.pop()));
        }
      } else { // th còn lại: vị trí hiện tại đang là 1 toán tử.
        while (!operators.isEmpty() && precedence(operators.top()) >= precedence(token.charAt(i))) {
          // Nếu thấy toán tử đang trong stack có độ ưu tiên cao hơn toán tử sắp thêm vào, thì ta phải tính trước.
          // copy lại cái trên.
          int b = numbers.pop();
          int a = numbers.pop();
          // đổi như này cho dễ theo logic a +-*/ b. Chứ để ngược lại hơi khó nhìn.
          numbers.push(applyOperator(a, b, operators.pop()));
        }
      }
    }
    // Lấy nốt các phép tính đang không ở trong ngoặc.
    while(!operators.isEmpty()) {
      int b = numbers.pop();
      int a = numbers.pop();
      // đổi như này cho dễ theo logic a +-*/ b. Chứ để ngược lại hơi khó nhìn.
      numbers.push(applyOperator(a, b, operators.pop()));
    }
    return numbers.pop();
  }
  public static boolean isEquation(String s) {
    for (int i = 0; i < s.length(); i++) {
      char tmp = s.charAt(i);
      if (isAlphabet(tmp)) return false;
    }
    return true;
  }
  public static boolean isRightBracket(String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      char tmp = s.charAt(i);
      if(tmp == '(') cnt++;
      if(tmp == ')') cnt--;
      if(cnt < 0) return false;

    }
    return cnt == 0;
  }
  private static boolean isDigit(char x) {
    return '0' <= x && x <= '9';
  }

  private static boolean isAlphabet(char x) {
    return ('a' <= x && x <= 'z') || ('A' <= x && x <= 'Z');
  }
}
