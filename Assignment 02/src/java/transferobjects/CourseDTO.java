package transferobjects;

/**
 * Course element of the Course table.
 * @author Tanzim Ahmed Sagar
 * @version 1.0
 * @since 03.11.2022
 */
public class CourseDTO {
    private String courseCode;
    private String courseName;
    private String courseDescription;

    /**
     * Getter for {@code CourseCode} attribute
     * CAN'T BE NULL!!
     * @return {@code String} CourseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Setter for {@code CourseCode} attribute.
     * @param courseCode Id of the student.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Getter for {@code CourseName} attribute
     * @return {@code String} CourseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter for {@code CourseName} attribute.
     * @param courseName Id of the student.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter for {@code CourseDescription} attribute
     * @return {@code String} CourseDescription
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * Setter for {@code CourseDescription} attribute.
     * @param courseDescription Id of the student.
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}