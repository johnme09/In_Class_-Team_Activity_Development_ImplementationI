import java.util.LinkedList;

public class Media extends Content{
    private LinkedList<Image> images;
    private int imageCount;
    private LinkedList<Video> videos;
    private int videoCount;


    public boolean equals(Content other){
        if(!(other instanceof Media))
            return false;
        Media otherMedia = (Media) other;

        if(!this.images.equals(otherMedia.getImages()))
            return false;

            if(!this.vides.equals(otherMedia.getVideos()))
            return false;

        return true;
    }

    public int getImageCount(){
        return this.imageCount;
    }

    public int getVideoCount(){
        return this.videoCount;
    }

    public LinkedList<Video> getVideos(){
        return this.videos;
    }

    public LinkedList<Image> getImages(){
        return this.images;
    }

    public void addImage(Image image){
        this.images.add(image);
    }

    
    public void addVideo(Video video){
        this.videos.add(video);
    }

    public void removeImage(Image image){
        this.images.remove(image);
    }

    public void removeImage(int image){
        this.images.remove(image);
    }

    public void removeVideo(Image video){
        this.videos.remove(image);
    }

    public void removeVideo(int video){
        this.videos.remove(image);
    }
}
