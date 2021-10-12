package ex43;

public class Website {
    public String SiteName;
    public String Author;
    public boolean JavaScript;
    public boolean CSS;

    public Website(String SiteName, String Author, String JavaScript, String CSS)
    {
        this.SiteName = SiteName;
        this.Author = Author;

        if (JavaScript.toLowerCase().equals("y"))
            this.JavaScript = true;

        if (CSS.toLowerCase().equals("y"))
            this.CSS = true;
    }
}
