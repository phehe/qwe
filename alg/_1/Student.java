package algorism.basic_100_youtube.student_name_no_store1;

public class Student {
    private String name;
    private String no;
    static int sequence;

    public Student(String name, String no) {
        this.name = name;
        this.no = no;
        ++sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
