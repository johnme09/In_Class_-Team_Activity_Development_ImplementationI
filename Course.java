
import java.util.LinkedList;

public class Course {

    private LinkedList<User> users = new LinkedList<>();
    private LinkedList<User> owners = new LinkedList<>();
    private LinkedList<Content> content = new LinkedList<>();
    private double passScore;

    //added course name to search CourseRecord
    private String courseName;

//constructor
    public Course(String courseName, double passScore) {
        this.passScore = passScore;
        this.courseName = courseName;
        users.clear();
        owners.clear();
        content.clear();
    }

//getters, setters, adds, and removes
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String newName) {
        courseName = newName;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public void removeUser(User userToGo) {
        users.remove(userToGo);
    }

    public LinkedList<User> getOwners() {
        return owners;
    }

    public void addOwner(User newOwner) {
        owners.add(newOwner);
    }

    public void removeOwner(User ownerToGo) {
        owners.remove(ownerToGo);
    }

    public boolean containsUser(User userToFind) {
        return users.contains(userToFind);
    }

    public boolean containsOwner(User ownerToFind) {
        return owners.contains(ownerToFind);
    }

    public LinkedList<Content> getContent() {
        return content;
    }

    public void addContent(Content newContent) {
        content.add(newContent);
    }

    public void removeContentByIndex(int index) {
        content.remove(index);
    }

    public void removeContent(Content contentToGo) {
        content.remove(contentToGo);
    }

    public double getPassScore() {
        return passScore;
    }

    public void setPassScore(double newPassScore) {
        passScore = newPassScore;
    }

//utilities
    public LinkedList<User> getPassing() {
        LinkedList<User> passing = new LinkedList<>();
        for (int i = 0; i < users.size(); i++) {
            LinkedList<CourseRecord> records = users.get(i).getUserRecords();
            for (int j = 0; j < records.size(); j++) {
                if (records.get(j).getCourseName().equalsIgnoreCase(courseName)) {
                    if (records.get(j).getScore() >= passScore) {
                        passing.add(users.get(i));
                        break;
                    }
                }
            }
        }
        return passing;
    }

    public LinkedList<User> getFailing() {
        LinkedList<User> failing = new LinkedList<>();
        for (int i = 0; i < users.size(); i++) {
            LinkedList<CourseRecord> records = users.get(i).getUserRecords();
            for (int j = 0; j < records.size(); j++) {
                if (records.get(j).getCourseName().equalsIgnoreCase(courseName)) {
                    if (records.get(j).getScore() <= passScore) {
                        failing.add(users.get(i));
                        break;
                    }
                }
            }
        }
        return failing;
    }

    public LinkedList<User> getIncomplete() {
        LinkedList<User> incomp = new LinkedList<>();
        for (int i = 0; i < users.size(); i++) {
            LinkedList<CourseRecord> records = users.get(i).getUserRecords();
            for (int j = 0; j < records.size(); j++) {
                if (records.get(j).getCourseName().equalsIgnoreCase(courseName)) {
                    if (records.get(j).getProgress() < 100) {
                        incomp.add(users.get(i));
                        break;
                    }
                }
            }
        }
        return incomp;
    }

}
