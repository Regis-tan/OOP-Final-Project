package OOP_Final.Citation_Generator_Code;

public class Webpage extends APA_7_Superclass {
    //Properties
    public String date; //Date of the citation.
    public String website; //Name of the website origin of the citation.
    public String url; //URL link of the source or article.
    
    //Constructor
    public Webpage(String title, String year, String date, String website, String url){
        super(title, year); //Calls the super constructor.
        this.date = date;
        this.website = website;
        this.url = url;
    }

    //Methods
    //This method returns the citation in the format of APA-7th webpage style.
    @Override
    String getCitation() {
        //The special unicode is for italic characters as they are nessecary for the format.
        return getAuthors() + " (" + this.year + ", " + this.date + "). " + "\033[3m" + this.title + "\033[0m" + ". " + this.website + ". " + this.url;
    }

    //This method returns the citation but for in text style.
    @Override
    String getIntextCitation() {
        return "(" + getAuthorsNoInitial() + ", " +this.year + ")";
    }
}
