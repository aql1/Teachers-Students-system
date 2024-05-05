
package sa.edu.uqu.education;

import java.util.ArrayList;
import java.util.List;

// This is the Student class extends from person class because the person class have common data member
public class Student extends Person {
    
    private double gpa;
     //-----------< The ArrayList of the teacher to assign an existing teacher  to an existing student >---------
    private List<Teacher> teachers = new ArrayList<>();

    // This constructor for Student class
    public Student(String firstName, String lastName, String mobilePhoneNumber, String emailAddress, double gpa) throws InvalidGPAException {
        super(firstName, lastName, mobilePhoneNumber, emailAddress);
        if (gpa < 0.0 || gpa > 4.0) {
            throw new InvalidGPAException("Invalid student GPA. A valid GPA value should be in the 0.0 to 4.0 range!");
        }
        this.gpa = gpa;
    }

    //--------------< The getters methods >--------------
    //This method is to get gpa of the Student
    public double getGPA() {
        return gpa;
    }
    //This method is to get Teachers
    public List<Teacher> getTeachers() {
        return teachers;
    }
    //This method is to add Teachers to a Student
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
