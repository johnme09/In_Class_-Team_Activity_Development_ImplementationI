import java.util.LinkedList;
import java.util.Objects;

public class User {

    private LinkedList<CourseRecord> records;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String hashedPassword;

    //Constructors--Default constructor is not intended for use, but is here just in case
    public User() {
        this.userName = "default";
        this.firstName = "default";
        this.lastName = "default";
        this.email = "default";
        createPasswordHash();
        this.records = new LinkedList<>();
    }
    public User(String userName, String firstName, String lastName, String email, String hashedPassword) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        createPasswordHash();
        this.records = new LinkedList<>();
    }

    ////////////////////////////UTILITY METHODS////////////////////////////////////////
    //Add a CourseRecord to the user's records
    public void addCourseRecord(CourseRecord record) {
        this.records.add(record);
    }

    //Hashes the user's password
    public void createPasswordHash() {
        this.hashedPassword = Integer.toHexString(this.hashedPassword.hashCode());
    }

    //placeholder for making a course
    public void makeCourse() {
        System.out.println("Course created successfully.");
    }

    //placeholder for deleting a course
    public void deleteCourse() {
        System.out.println("Course deleted successfully.");
    }

    //Checks if the user is enrolled in a given course as a Learner
    public boolean checkEnrolled(String course) {
        for (CourseRecord record : records) {
            if (record.getCourseName().equals(course) && !record.isLearner()) {
                return true;
            }
        }
        return false;
    }
    

    //Checks if this user is equal to another user (based on username and email)--not necessary for functional requirements, but may be nonfunctional
    public boolean equals(User other) {
        return (Objects.equals(this.userName, other.userName) && Objects.equals(this.email, other.email));
    }

    ////////////////////////////ENROLLMENT METHODS/////////////////////////////////////
    //Enrolls the user in a course as a learner
    public void enroll(String course) {
        records.add(new CourseRecord(course, false));
    }

    //Removes the user from a course as a learner
    public void drop(String course) {
        records.removeIf(record -> record.getCourseName().equals(course) && record.isLearner());
    }

    //Enrolls the user in the course as an Owner
    public void enrollOwner(String course) {
        records.add(new CourseRecord(course, true));
    }

    //Removes the user from a course if they are enrolled and are an Owner (and are enrolled in the course)
    public void dropOwner(String course) {
        records.removeIf(record -> record.getCourseName().equals(course) && record.isOwner());
    }

    ////////////////////////////REPORTS METHODS////////////////////////////////////////
    //Retrieves records for courses the user is enrolled in (not as an owner)
    public LinkedList<CourseRecord> getUserRecords() {
        LinkedList<CourseRecord> userRecords = new LinkedList<>();
        for (CourseRecord record : records) {
            if (!record.isOwner()) {
                userRecords.add(record);
            }
        }
        return userRecords;
    }

    //Retrieves records for courses the user owns
    public LinkedList<CourseRecord> getOwnerRecords() {
        LinkedList<CourseRecord> ownerRecords = new LinkedList<>();
        for (CourseRecord record : records) {
            if (record.isOwner()) {
                ownerRecords.add(record);
            }
        }
        return ownerRecords;
    }

    //Retrieves all course records for the user
    public LinkedList<CourseRecord> getAllRecords() {
        return records;
    }


    ////////////////////////////ALL SETTERS AND GETTERS/////////////////////////////////
    //Setter & Getter for records
    public LinkedList<CourseRecord> getRecords() {
        return records;
    }
    public void setRecords(LinkedList<CourseRecord> records) {
        this.records = records;
    }

    //Setter & Getter for userName
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Setter & Getter for firstName
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Setter & Getter for lastName
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Setter & Getter for email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Setter & Getter for hashedPassword
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }




    

}