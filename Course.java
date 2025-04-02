package application;

import java.util.LinkedList;

public class Course{

	private LinkedList<User> users = new LinkedList<>();
	private LinkedList<User> owners = new LinkedList<>();
	private LinkedList<Content> content = new LinkedList<>();
	private double passScore; 

public Course{
	users.clear();
	owners.clear();
	content.clear();
}

public LinkedList<User> getUsers(){

}

public void addUser(User newUser){

}

public void removeUser(User userToGo){

}

public LinkedList<User> getOwners(){

}

public void addOwner(User newOwner){

}

public void removeOwner(User ownerToGo){
	
}

public boolean containsUser(User userToFind){

}

public LinkedList<Content> getContent(){

}

public void addContent(Content newContent){

}

public void removeContentByIndex(int index){
	
}

public void removeContent(Content contentToGo){
	
}

public double getPassScore(){

}

public void setPassScore(double newPassScore){

}

public LinkedList<User> getPassing(){

}

public LinkedList<User> getFailing(){
	
}

public LinkedList<User> getIncomplete(){
	
}

}