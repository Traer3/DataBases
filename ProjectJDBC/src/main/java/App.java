import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Student> students = CRUDUtils.getStudentData("SELECT * FROM students");
        System.out.println(students);

        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setCurs_name("java");

        System.out.println(CRUDUtils.saveStudent(student));
        System.out.println(CRUDUtils.updateStudent(2,"SQL Learning"));

        System.out.println(CRUDUtils.deleteStudent(1));
    }
}
