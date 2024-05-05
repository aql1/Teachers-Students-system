package sa.edu.uqu.education;
// This class have Exception method
public class InvalidGPAException extends Exception {
    // this method throw Exception when the GPA less than zero or more than four
    public InvalidGPAException(String s) {
        super(s);
    }
}
