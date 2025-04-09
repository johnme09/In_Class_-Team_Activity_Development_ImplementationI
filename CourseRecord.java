public class CourseRecord {

    private String courseName;
    private double score;
    private int progress;
    private boolean pass;
    private int date;
    private String role;

    //constructor
    public CourseRecord(String courseName, double score, int progress, boolean pass, int date, String role) {
        this.courseName = courseName;
        this.score = score;
        this.progress = progress;
        this.pass = pass;
        this.date = date;
        this.role = role;
    }

//getters and setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String newName) {
        courseName = newName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double newScore) {
        score = newScore;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int newProgress) {
        progress = newProgress;
    }

    public boolean getPass() {
        return pass;
    }

    public void setPass(boolean newPass) {
        pass = newPass;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int newDate) {
        date = newDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String newRole) {
        role = newRole;
    }

//utility
    public boolean equals(CourseRecord other) {
        if (other.pass != pass) {
            return false;
        }
        if (!other.courseName.equalsIgnoreCase(courseName)) {
            return false;
        }
        if (other.date != date) {
            return false;
        }
        if (other.progress != progress) {
            return false;
        }
        if (other.score != score) {
            return false;
        }
        return other.role.equalsIgnoreCase(role);
    }

}
