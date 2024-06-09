package OOP_Final.Citation_Generator_Code;

public class Book extends APA_7_Superclass{
    //Properties
    public String publisher; //Publisher of the source material.

    //Constructor
    public Book(String title, String year, String publisher){
        super(title, year); //Calls the super constructor.
        this.publisher = publisher;
    }

    //Methods
    //Method that returns the citation in APA-7th book style.
    @Override
    String getCitation() {
        //Same as webpage but with different format, the unicode are also for italics.
        return getAuthors() + "(" + this.year + "). " + "\033[3m" + this.title + "\033[0m" + ". " + this.publisher + ".";
    }

    //Method that returns the in text citation.
    @Override
    String getIntextCitation() {
        return "(" + getAuthorsNoInitial() + ", " +this.year + ")";
    }
}
