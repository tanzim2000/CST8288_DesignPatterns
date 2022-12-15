package transferobjects;

/**
 * Student element of the student table.
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public class StudentDTO {
    private int studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    /**
     * Getter for {@code StudentID} attribute
     * @return {@code Integer} StudentID
     */
    public int getStudentID(){
        return studentID;
    }
    /**
     * Getter for {@code FirstName} attribute
     * @return {@code String} FirstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Getter for {@code LastName} attribute
     * @return {@code String} LastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Getter for {@code Email} attribute
     * @return {@code String} Email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Getter for {@code PhoneNumber} attribute
     * @return {@code String} PhoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Setter for {@code StudentID} attribute.
     * @param studentID Id of the student.
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    /**
     * Setter for {@code FirstName} attribute.
     * @param firstName First name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Setter for {@code LastName} attribute.
     * @param lastName Last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Setter for {@code Email} attribute.
     * @param email Email address of the student.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Setter for {@code PhoneNumber} attribute.
     * @param phoneNumber Phone number of the student.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
