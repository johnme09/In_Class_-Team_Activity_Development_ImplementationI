public abstract class Content {
    private String prompt;

    public Content(String prompt){
	this.prompt = prompt;
    }

    public String getPrompt(){
        return this.prompt;
    }

    public void setPrompt(String prompt){
        this.prompt = prompt;
    }
}
