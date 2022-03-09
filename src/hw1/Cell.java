package hw1;

public class Cell <T>{
    private T a;

    public Cell(T a) {
        this.a = a;
    }
    public Cell() {

    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public boolean isPerfect() {
        int tmp;
        tmp = 0;
        if (a instanceof Integer) {
            tmp = (int) a;
        }
        if (a instanceof Double) {
            tmp = (int) Math.floor((float) a);
        }
        if (tmp == 1) return false;
        int result;
        result = 1;
        for (int i = 2; i * i <= tmp; ++i) {
            if (tmp % i == 0) {
                result += i;
                if (i != tmp/i) result += tmp/i;
            }
        }
        return result == tmp;
    }
    public boolean isPrime() {
        int x;
        x = 0;
        if (a instanceof Integer) {
            x = (int) a;
        }
        if (a instanceof Double ) {
            x = (int) Math.floor((float) a);
        }

        if (x == 2) return true;
        if (x % 2 == 0 || x < 2) return false;
        for (int i = 2; i * i <= x; ++i) if (x % i == 0) return false;
        return true;
    }
}
