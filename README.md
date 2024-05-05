This project for the Object-Oriented Programming course involves crafting a Java console application for a Teachers-Students management system, leveraging key OOP principles.

The application will maintain comprehensive information regarding the association between teachers and students within a specific university. Both teachers and students share fundamental attributes such as a unique ID, first name, last name, mobile phone number, and email address.

Moreover, teachers will have additional information regarding their salary, while students will include their GPA. GPA values must fall within the range of 0.0 to 4.0.

To ensure data integrity, the ID attribute for both teachers and students will be automatically generated and incremented, starting from 1, for each new object. Static data members will facilitate this functionality.

Relationships between teachers and students will be managed dynamically, enabling multiple teachers to instruct a single student and vice versa.

The application will feature a user-friendly selection screen menu, allowing users to perform various operations. These include adding basic information for teachers and students, assigning students to teachers, printing all teachers' and students' information, displaying all teachers' information for a certain student, and vice versa. The program will continue to display the selection screen until the user opts to exit by entering the number 8.

Additionally, a custom exception named InvalidGPAException will be implemented to handle cases where a user attempts to add a new student with a GPA value outside the valid range of 0.0 to 4.0. This exception will not be handled using try-catch blocks as per the project specifications.

The application aims to provide a robust and intuitive interface for managing teacher-student relationships within the university setting, adhering to best practices in object-oriented design and programming.
