
package sa.edu.uqu.education;

// This class contain the common information between teacher and student
public class Person {

    // This data member of the class
    // The variable nextId gives initial value 1 to increase the ID of Teacher and studernt automatically
    private static int nextId = 1;
    private int id;
    private String firstName;
    private String lastName;
    private String mobilePhoneNumber;
    private String emailAddress;
    
    // This constructor for person class
    public Person(String firstName, String lastName, String mobilePhoneNumber, String emailAddress) {
        //increaseing the ID by 1
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
    }

    //--------------< The getters methods >--------------
    //This method is to get ID
    public int getId() {
        return id;
    }

    //This method is to get the first Name 
    public String getFirstName() {
        return firstName;
    }

    //This method is to get the last  Name 
    public String getLastName() {
        return lastName;
    }

    //This method is to get the MibilePhone
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    
    //This method is to get the  email address
    public String getEmail() {
        return emailAddress;
    }
}
