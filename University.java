
package sa.edu.uqu.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class contain the main method
public class University {

  // -----------< The ArrayList of the teacher to add new teacher >--------------
  private static List<Teacher> teachers = new ArrayList<>();

  // -----------< The ArrayList of the student to add new student >--------------
  private static List<Student> students = new ArrayList<>();
  static Scanner sc = new Scanner(System.in);

  
  // --------------< This method to add the information of teacher >--------------
  private static void addTeacher() {

    System.out.print("Enter teacher first name: ");
    String firstName = sc.nextLine();

    System.out.print("Enter teacher last name: ");
    String lastName = sc.nextLine();

    String mobilePhone = "";
    boolean isValidMobile = false;
    while (!isValidMobile) {
      // This try-catch used to throw exception if the user entered invalid phone
      // number
      try {
        System.out.print("Enter teacher mobile phone number (saudi number) : ");
        mobilePhone = sc.nextLine();
        isValidMobile = validMobilephone(mobilePhone);
        if (!isValidMobile) {
          throw new Exception("Not valied phone number");
        }

      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    boolean x;
    String email;
    // this loop to check the email address if is not valid and give the user chance
    // to try again
    do {
      System.out.print("Enter teacher email address: ");
      email = sc.nextLine();
      if (email.contains("@uqu.edu.sa")) {
        x = true;
      } else {
        System.out.println("Not valied email ,try again");
        x = false;
      }
    } while (!x);

    double salary = 0;
    boolean isValidSalary = false;
    while (!isValidSalary) {

      // This try-catch used to throw exception if the user entered negative value of
      // salary
      try {
        System.out.print("Enter teacher salary: ");
        String s = sc.nextLine();
        salary = Double.parseDouble(s);
        if (salary < 0) {
          throw new Exception("Salary must be a positive value");
        }
        isValidSalary = true;
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    // This for add the information of teacher to the ArrayList
    teachers.add(new Teacher(firstName, lastName, mobilePhone, email, salary));
    System.out.println("\n------< Teacher added successfully! >------\n");
  }

  // --------------< This method to add the information of student >--------------
  private static void addStudent() {
    System.out.print("Enter student first name: ");
    String firstName = sc.nextLine();

    System.out.print("Enter student last name: ");
    String lastName = sc.nextLine();

    String mobilePhone = "";
    boolean isValidMobile = false;
    while (!isValidMobile) {

      /* This try-catch used to throw exception if the user entered invalid phone
       number */
      try {
        System.out.print("Enter student mobile phone number (saudi number) : ");
        mobilePhone = sc.nextLine();
        isValidMobile = validMobilephone(mobilePhone);
        if (!isValidMobile) {
          throw new Exception("Not valied phone number");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    boolean x;
    String email;
    /* this loop to check the email address if is not valid and give the user chance
    to try again */
    do {
      System.out.print("Enter student email address: ");
      email = sc.nextLine();
      if (email.contains("@st.uqu.edu.sa")) {
        x = true;
      } else {
        System.out.println("Not valied email ,try again");
        x = false;
      }
    } while (!x);

    System.out.print("Enter student GPA: ");
    String g = sc.nextLine();
    Double gpa = Double.parseDouble(g);
    /*
     * her we used the InvalidGPAException to throw Exception when the GPA is less
     * than zero or more than four
     */
    try {
      if (gpa < 0.0 || gpa > 4.0) {
        throw new InvalidGPAException("Invalid student GPA. A valid GPA value should be in the 0.0 to 4.0 range!");
      }

      students.add(new Student(firstName, lastName, mobilePhone, email, gpa));
      System.out.println("\n------< Teacher added successfully! >------\n");
    } catch (InvalidGPAException e) {
      System.out.println(e.getMessage());
    }
  }

  // --------------< This method to add the assign student toteache >--------------
  private static void assignStudentToTeacher() {
    /* This try-catch used to throw exception if the user entered invalid ID 
       of student or teacher */
    try {
      System.out.print("Enter teacher ID: ");
      String c = sc.nextLine();
      int teacherId = Integer.parseInt(c);
      System.out.print("Enter student ID: ");
      String i = sc.nextLine();
      int studentId = Integer.parseInt(i);
      Teacher teacher = null;
      Student student = null;
      for (Teacher t : teachers) {
        if (t.getId() == teacherId) {
          teacher = t;
        }
      }
      for (Student s : students) {
        if (s.getId() == studentId) {
          student = s;
        }
      }
      if (teacher == null || student == null) {
        System.out.println("Teacher or student not found.");
      } else {
        teacher.addStudent(student);
        student.addTeacher(teacher);
        System.out.println("\nAssigned " + student.getFirstName() + " " + student.getLastName() + " to "
            + teacher.getFirstName() + " " + teacher.getLastName());
      }
    } catch (NumberFormatException e) {
      System.out.println("\nInvalid input. Teacher or student ID must be an integer.");
    }
  }

  // --------------< This method to print teachers >--------------
  private static void printTeachers() {
    System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-20s|  %-6s", "ID", "First Name", "Last Name",
        "Mobile Phone", "Email", "Salary");
    System.out
        .println("\n_________________________________________________________________________________________________");
    for (Teacher t : teachers) {
      System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-20s|  %-6s", t.getId(), t.getFirstName(),
          t.getLastName(), t.getMobilePhoneNumber(), t.getEmail(), t.getSalary());
    }
  }

  // --------------< This method to print students >--------------
  private static void printStudents() {
    System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-25s|  %-6s", "ID", "First Name", "Last Name",
        "Mobile Phone", "Email", "GPA");
    System.out.println(
        "\n___________________________________________________________________________________________________");
    for (Student s : students) {
      System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-25s|  %-6s", s.getId(), s.getFirstName(),
          s.getLastName(), s.getMobilePhoneNumber(), s.getEmail(), s.getGPA());
    }
  }

  // --------------< This method to  display teachers for students >--------------
  private static void displayTeachersForStudent() {
    System.out.print("Enter student ID: ");
    try {
      String i = sc.nextLine();
      int studentId = Integer.parseInt(i);
      Student student = null;
      for (Student s : students) {
        if (s.getId() == studentId) {
          student = s;
        }
      }
      if (student == null) {
        System.out.println("Student not found.");
      } else {
        System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-20s|  %-6s", "ID", "First Name", "Last Name",
            "Mobile Phone", "Email", "Salary");
        System.out.println(
            "\n_________________________________________________________________________________________________");
        for (Teacher t : student.getTeachers()) {
          System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-20s|  %-6s", t.getId(), t.getFirstName(),
              t.getLastName(), t.getMobilePhoneNumber(), t.getEmail(), t.getSalary());
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid student ID, must be an integer.");
    }
  }

  // --------------< This method to display students for teacher >--------------
  private static void displayStudentsForTeacher() {
    System.out.print("Enter teacher ID: ");
    String i = sc.nextLine();
    int teacherId = Integer.parseInt(i);
    Teacher teacher = null;
    for (Teacher t : teachers) {
      if (t.getId() == teacherId) {
        teacher = t;
      }
    }
    if (teacher == null) {
      System.out.println("Teacher not found.");
    } else {
      System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-25s|  %-6s", "ID", "First Name", "Last Name",
          "Mobile Phone", "Email", "GPA");
      System.out.println(
          "\n___________________________________________________________________________________________________");
      for (Student s : teacher.getStudents()) {
        System.out.printf("\n| %-5s |  %-15s |  %-15s |  %-13s |  %-25s|  %-6s", s.getId(), s.getFirstName(),
            s.getLastName(), s.getMobilePhoneNumber(), s.getEmail(), s.getGPA());
      }
    }
  }

  // --------------< This method checks if the given Mobile Phone is valid
  private static boolean validMobilephone(String Phone) {
    // check if the number is 10 digit, and if it is 13 digit it should contain
    // +966, and if it is 14 digit, it should contain 00966
    if (Phone.length() == 10) {
      boolean result1 = Phone.contains("05");
      if (result1) {
        return true;
      } else {
        return false;
      }
    } else if (Phone.length() == 13) {
      boolean result2 = Phone.contains("+9665");
      if (result2) {
        return true;
      } else {
        return false;
      }
    } else if (Phone.length() == 14) {
      Boolean result3 = Phone.contains("009665");
      if (result3) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public static void main(String[] args) throws InvalidGPAException {
    // Initial fixed collection of Teachers
    teachers.add(new Teacher("Mazen", "Alaql", "0545650318", "MazenA@uqu.edu.sa.com", 20000.0));
    teachers.add(new Teacher("Mohammed", "Bumandr", "0545340368", "MohammedB@uqu.edu.sa.com", 20000.0));

    // Initial fixed collection of Students
    students.add(new Student("Abdullah", "ALaql", "0587565031", "443005948@st.uqu.edu.sa", 3.75));
    students.add(new Student("Abdulrahman", "Bumandr", "0545612318", "s443011895@st.uqu.edu.sa", 3.75));
    students.add(new Student("Ali", "Ahmed", "0545650354", "443005288@st.uqu.edu.sa", 3.69));

    int choice;
    do {

      System.out.println("\n\n\t-----< Welcome to Teachers-Students Application >-----");
      System.out.println("\n\t1. Add a basic teacher information");
      System.out.println("\t2. Add a basic student information");
      System.out.println("\t3. Assign an existing student to an existing teacher");
      System.out.println("\t4. Print all teachers basic information");
      System.out.println("\t5. Print all students basic information");
      System.out.println("\t6. Display all teachers information for a certain student");
      System.out.println("\t7. Display all students information for a certain teacher");
      System.out.println("\t8. Exit the program\n");
      System.out.print("please choose the operation you wants to perform: ");

      try {
        String c = sc.nextLine();
        choice = Integer.parseInt(c);

        switch (choice) {

          /*
           * case 1 is to add a basic teacher information
           * (by providing all her/his information)
           */
          case 1:
            addTeacher();
            break;

          /*
           * case 2 is to add a basic Student information
           * (by providing all her/his information)
           */
          case 2:
            addStudent();
            break;

          /*
           * case 3 is to assign an existing student to an existing teacher
           * (after reading both existing teacher ID and student ID from the user)
           */
          case 3:
            assignStudentToTeacher();
            break;

          /* case 4 is to print all teachers basic information (in a well-tabular form) */
          case 4:
            printTeachers();
            break;

          /* case 5 is to print all students basic information (in a well-tabular form) */
          case 5:
            printStudents();
            break;

          /*
           * case 6 is to Display all teachers information for a certain student (in a
           * well-tabular
           * form including student ID and student full name after reading existing
           * student ID from the user)
           */
          case 6:
            displayTeachersForStudent();
            break;

          /*
           * Display all students information for a certain teacher (in a well-tabular
           * form including teacher ID and teacher full name after reading existing
           * teacher ID from the user)
           */
          case 7:
            displayStudentsForTeacher();
            break;

          /* Exit the program (after printing out “Exiting from the program...” message */
          case 8:
            System.out.println("Exiting from the program...");
            System.exit(0);

            /* default for print mesaage that user enter unvalid chice */
          default:
            System.out.println("Invalid choice");
            break;
        }

        /*
         * NumberFormatException is to throw Exception if the user intered other than
         * integer
         */
      } catch (NumberFormatException e) {
        System.out.println("Invalid input format. Please enter a valid integer value.");
      }

    } while (true);

  }

}