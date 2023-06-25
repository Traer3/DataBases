import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

    private static String INSERT_STUDENT = "INSERT INTO students(name, surname, course_name) VALUES (?,?,?);";
    private static String UPDATE_STUDENT = "UPDATE students SET course_name = ? WHERE id = ?;";
    private static String DELETE_STUDENT = "DELETE FROM students WHERE id = ?;";

    public static List<Student> getStudentData(String query) {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String curse_name = resultSet.getString("course_name");

                students.add(new Student(id, name, surname, curse_name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return students;
    }

    public static List<Student> saveStudent(Student student) {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getCurs_name());
            preparedStatement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = allStudents.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String curse_name = resultSet.getString("course_name");

                students.add(new Student(id, name, surname, curse_name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return students;
    }

    public static List<Student> updateStudent(int studentId, String courseName) {
        List<Student> updateStudents = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, courseName);
            preparedStatement.setInt(2, studentId);

            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = allStudents.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String curse_name = resultSet.getString("course_name");

                updateStudents.add(new Student(id, name, surname, curse_name));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return updateStudents;
    }
    public static List<Student> deleteStudent(int studentId){
        List<Student> deletedStudents = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = allStudents.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String curse_name = resultSet.getString("course_name");

                deletedStudents.add(new Student(id, name, surname, curse_name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return deletedStudents;
    }
}
