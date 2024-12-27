# Teachers and Students Management System

This is a Java-based **Teachers and Students Management System** application that allows users to manage information about teachers, students, and their relationships. The application includes functionalities for adding teachers and students, assigning students to teachers, and displaying detailed information in a tabular format.

---

## Features

### Teachers Management
- Add new teachers with basic information.
- Display all teachers' basic information in a tabular format.
- View all students assigned to a specific teacher.

### Students Management
- Add new students with basic information.
- Display all students' basic information in a tabular format.
- View all teachers assigned to a specific student.

### Validation
- **Mobile Phone Numbers**:
  - Must follow Saudi formats: 10-digit numbers starting with `05`, or international formats `+9665` or `009665`.
- **Email Addresses**:
  - Teachers: Must end with `@uqu.edu.sa`.
  - Students: Must end with `@st.uqu.edu.sa`.
- **GPA Validation**:
  - GPA must be between 0.0 and 4.0.
  - Uses custom `InvalidGPAException` to handle invalid GPA values.

---

## File Structure

```
teachers_students_management/
├── InvalidGPAException.java  # Custom exception class for GPA validation.
├── Person.java               # Base class for common attributes of teachers and students.
├── Student.java              # Extends Person to include GPA and assigned teachers.
├── Teacher.java              # Extends Person to include salary and assigned students.
├── University.java           # Main application class with the program logic.
└── README.md                 # Project documentation (this file).
```

---

## How to Run the Application

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/teachers_students_management.git
   cd teachers_students_management
   ```

2. **Compile the Code:**
   Compile all `.java` files in the `teachers_students_management` directory:
   ```bash
   javac sa/edu/uqu/education/*.java
   ```

3. **Run the Program:**
   Execute the `University` class:
   ```bash
   java sa.edu.uqu.education.University
   ```

---

## Usage

### Menu Options

1. **Add Teacher:**
   - Input basic information including name, mobile number, email, and salary.
   - Mobile and email validation ensure data integrity.

2. **Add Student:**
   - Input basic information including name, mobile number, email, and GPA.
   - Mobile, email, and GPA validation are performed.

3. **Assign Student to Teacher:**
   - Provide the teacher's ID and the student's ID to create the association.

4. **Display All Teachers:**
   - View a tabular list of all teachers.

5. **Display All Students:**
   - View a tabular list of all students.

6. **View Teachers for a Student:**
   - Enter the student's ID to view their assigned teachers.

7. **View Students for a Teacher:**
   - Enter the teacher's ID to view their assigned students.

8. **Exit the Program:**
   - Safely terminates the application.

---

## Example Interaction

### Adding a Teacher
```plaintext
Enter teacher first name: John
Enter teacher last name: Doe
Enter teacher mobile phone number (Saudi number): 0501234567
Enter teacher email address: john.doe@uqu.edu.sa
Enter teacher salary: 20000
------< Teacher added successfully! >------
```

### Adding a Student
```plaintext
Enter student first name: Alice
Enter student last name: Smith
Enter student mobile phone number (Saudi number): +966512345678
Enter student email address: alice.smith@st.uqu.edu.sa
Enter student GPA: 3.8
------< Student added successfully! >------
```

### Assigning a Student to a Teacher
```plaintext
Enter teacher ID: 1
Enter student ID: 2
Assigned Alice Smith to John Doe
```

---

## Technologies Used

- **Java:** Programming language for building the application.
- **ArrayList:** Used to manage collections of teachers and students.
- **Custom Exceptions:** For handling specific cases like invalid GPA.
- **Scanner:** For user input handling.
- **Tabular Display:** Organized data presentation.

---
