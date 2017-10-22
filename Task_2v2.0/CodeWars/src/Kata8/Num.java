package Kata8;

public class Num {
    public static int nthEven(int n) {
        int counter = 1;
        for (int i = 0;  ; i+=2) {
            if(n == counter){
                return i;
            }
            counter++;
        }
    }

    public static void main(String[] args) {

        System.out.println(nthEven(1298734));

    }
}






