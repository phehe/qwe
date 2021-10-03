package algorism.datastructure.baekjoon;

import java.util.Scanner;

public class while_10951 {
    // a+b    - > EOF End Of File  -> .close();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //hasNextInt() 입력값 유무
        while (sc.hasNextInt()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            System.out.println(num1 + num2);
        }
    }
}
