
package sa.edu.uqu.education;

import java.util.ArrayList;
import java.util.List;
// This class Teacher extends from person class because the person class have common data member
public class Teacher extends Person {
    private double salary;

     //--------------< The ArrayList of the students to assign an existing student to an existing teacher>--------------
    private List<Student> students = new ArrayList<>();

    // This constructor for Student class
    public Teacher(String firstName, String lastName, String mobilePhoneNumber, String emailAddress, double salary) {
        super(firstName, lastName, mobilePhoneNumber, emailAddress);
        this.salary = salary;
    }

    //--------------< The getters methods >--------------
    //This method is to get Salary of the teacher
    public double getSalary() {
        return salary;
    }
    //This method is to get Student
    public List<Student> getStudents() {
        return students;
    }
    //This method is to add Student to a Teachers
    public void addStudent(Student student) {
        students.add(student);
    }
}
