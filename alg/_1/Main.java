package algorism.basic_100_youtube.student_name_no_store1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList();

        Student student1 = new Student("표하은", "230");
        Student student2 = new Student("김감감", "4012");
        Student student3 = new Student("박박치", "2901");
        list.add(student1);
        list.add(student2);
        list.add(student3);

        for (Student stu : list) {
            System.out.println("stu.getName() = " + stu.getName());
            System.out.println("stu.getNo() = " + stu.getNo());
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("검색 -> Y / 종료 -> N");
            String input = sc.next();
            if (input.equals("Y")) {
                System.out.println("검색을 시작합니다.");
                System.out.print("이름 입력 : ");
                String name = sc.next();
                boolean flag = false;
                for (Student stu : list) {
                    if (stu.getName().equals(name)) {
                        System.out.println(name + "의 학번은" + stu.getNo() + "입니다");
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("등록되지 않은 학생입니다.");
                }
            } else if (input.equals("N")) {
                break;
            }
        }
        System.out.println("검색을 종료합니다.");


    }
}
