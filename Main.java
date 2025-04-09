import java.util.LinkedList;

public class Main {    
    private User currentUser = null;
    private String role;
    
    public static void main(String[] args) {        
        Main main = new Main();
        
    }  
    
    //Logs the user in and sets the current user and role
    //If the user is not found, it prints an error message
    private void login(String username, String password, String role) {
        Authenticator authenticator = new Authenticator();
        User user = authenticator.authenticate(username, password);
        if(user != null) {
            setCurrentUser(user);
            setRole(role);
            updateVisuals();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    //Logs the user out and resets the current user and role
    private void logout() {
        setRole(null);
        setCurrentUser(null);
        updateVisuals();
    }

    private boolean checkAuth() {
        if(role.equals("Owner")) {
            return true;
        } else {
            return false;
        }
    }

    //Registers a user for a course
    private void enrollRegister(String courseName) {
            // Check if the user is already enrolled in the course
            if (currentUser.checkEnrolled(courseName)) {
                System.out.println("You are already enrolled in this course.");
                return;
            }
    
            // Enroll the user in the course
            CourseRecord newRecord = new CourseRecord();
            currentUser.addCourseRecord(newRecord);
            System.out.println("You have been successfully enrolled in the course.");
    } 

    private void toggleRole() {
        if (role.equals("Learner")) {
            setRole("Owner");
            setLayoutOwner();
        } else {
            setRole("Learner");
            setLayoutLearner();
        }
    }

    //Submits the answer to questions and calculates the total score
    private void answerSubmit() {
        String userAnswer = ""; // This should be replaced with actual user input
        double score = 0.0;
        
        LinkedList<Question> questions = new LinkedList<>();
        
        for (Question question : questions) {
            score += scoreQuestion(question, userAnswer);
        }
        
        System.out.println("Total Score: " + score);
    }

    //Scores an individual question and returns the points earned
    private double scoreQuestion(Question question, String userAnswer) {
        if(question.isCorrect(userAnswer)) {
            return question.getPoints();
        } else {
            return 0.0;
        }
    }

    private LinkedList<CourseRecord> pullClassReport() {
        return null;
    }

    private void updateVisuals() {
        if (role.equals("Owner")) {
            setLayoutOwner();
        } else {
            setLayoutLearner();
        }
    }

    private void setLayoutOwner() {
        // Placeholder for setting layout for owner
    }

    private void setLayoutLearner() {
        // Placeholder for setting layout for learner
    }

    //Set current user
    private void setCurrentUser(User user) {
        this.currentUser = user;
    }

    //Get current user
    private User getCurrentUser() {
        return this.currentUser;
    }

    //Set role
    private void setRole(String role) {
        this.role = role;
    }

    //Get role
    private String getRole() {
        return this.role;
    }
}
