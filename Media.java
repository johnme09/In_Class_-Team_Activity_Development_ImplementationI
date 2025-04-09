import java.util.LinkedList;
import java.io.File;

public class Media extends Content{
    private LinkedList<File> images;
    private int imageCount;
    private LinkedList<File> videos;
    private int videoCount;

    public Media(String prompt){
	super(prompt);
	this.images = new LinkedList<File>;
	this.videos = new LinkedList<File>;
	this.imageCount = 0;
	this.videoCount = 0;
    }

    public boolean equals(Content other){
        if(!(other instanceof Media))
            return false;
        Media otherMedia = (Media) other;

        if(!this.images.equals(otherMedia.getImages()))
            return false;

	if(!this.videos.equals(otherMedia.getVideos()))
            return false;

        return true;
    }

    public int getImageCount(){
        return this.imageCount;
    }

    public int getVideoCount(){
        return this.videoCount;
    }

    public LinkedList<File> getVideos(){
        return this.videos;
    }

    public LinkedList<File> getImages(){
        return this.images;
    }

    public void addImage(Image image){
        this.images.add(image);
	this.videoCount++;
    }

    
    public void addVideo(File video){
        this.videos.add(video);
	this.videoCount++;
    }

    public void removeImage(File image){
        this.images.remove(image);
	this.imageCount--;
    }

    public void removeImage(int image){
        this.images.remove(image);
	this.imageCount--;
    }

    public void removeVideo(File video){
        this.videos.remove(video);
	    this.videoCount--;
    }

    public void removeVideo(int video){
        this.videos.remove(video);
	this.videoCount--;
    }
}
