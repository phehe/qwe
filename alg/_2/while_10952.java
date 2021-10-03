package algorism.datastructure.baekjoon;

import java.util.Scanner;

public class while_10952 {
    public static void main(String[] args) {

        // 두 정수 a,b 입력 a+b 출력 프로그램 작성

        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.print("두개의 정수 입력 : ");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            int numAdd = num1 + num2;

            System.out.println(numAdd);

            if (num1==0 && num2==0) break;
        }

    }
}
