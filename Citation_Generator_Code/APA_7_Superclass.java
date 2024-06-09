package OOP_Final.Citation_Generator_Code;
import java.util.ArrayList;

abstract class APA_7_Superclass {
    //Properties
    public ArrayList<String> authors; //ArrayList to contain the authors of this citaiton.
    public String title; //The title of the source material.
    public String year; //The year the source material was published.

    //Constructor
    public APA_7_Superclass(String title, String year){
        this.authors = new ArrayList<String>(); //Authors becomes a new String type ArrayList.
        this.title = title; 
        this.year = year;
    }

    //Methods
    //Method that adds an author into the authors ArrayList.
    public void addAuthor(String first, String last){
        Character first_initial = first.charAt(0); //Only takes the initials.
        this.authors.add(last + ", " + first_initial + "."); //Formats the author.
    }

    //Method that returns the first author.
    public String getFirstAuthor(){
        return this.authors.get(0); //Returns the first author in the ArrayList.
    }

    //Method that returns an ordered string of authors.
    public String getAuthors(){
        if(authors.size() < 1){ //If there is no author of the citation, it will return the title of the source.
            return this.title;

        } else if(authors.size() == 1 || authors.size() == 2){ //If there are only one or two authors, it will add only the & symbol.
            return String.join(", & ", authors);

        } else{ //If there are more than 2 authors it will add commas and & symbols.
            String last_author = authors.get(authors.size() - 1); //Gets the last author in the list.
            authors.remove(authors.size() - 1); //Temporarily removes the last author.
            String output = String.join(", ", authors) + ", & " +last_author; //Creates the output String, it will have commas for spacing except for the last author which will have an & symbol.
            authors.add(last_author); //Returns the last author back into the ArrayList.

            return output;//Returns the output String.
        }
    }

    //Method that also returns an ordered string of authors but without the initials, it is used for the in text citation methods in child classes.
    public String getAuthorsNoInitial(){
        if(authors.size() < 1){ //If there is no authors, it will return the title.
            return this.title;
        }

        ArrayList<String> authors_short = new ArrayList<>(); //Creates a temporary ArrayList called authors_short.
        authors_short.addAll(authors); //Adds all elements in authors into the new ArrayList.

        for(String element : authors_short){ //For loop to remove the last 4 letters of the string as it contains the initials and punctuation.
            String new_element = element.substring(0, element.length() - 4);
            authors_short.set(authors_short.indexOf(element), new_element);
        }
        
        if(authors_short.size() == 1 || authors_short.size() == 2){ //If there is only 1 or 2 authors.
            return String.join(", & ", authors_short); //Returns the string with only a comma and & symbol.

        } else{ //If there are 3 or more authors.
            String last_author = authors_short.get(authors.size() - 1); //Creates a variable called last_author and sets it to the last author in the ArrayList.
            authors_short.remove(authors_short.size() - 1); //Removes the last author but will not add it back as this is temporary and isolated in this method.
            String output = String.join(", ", authors_short) + ", & " +last_author; //Formats the output String.

            return output; //Returns the output String.
        }
    }

    //Abstract Methods
    //These are abstract as different citation types will have different formats.
    abstract String getCitation();
    abstract String getIntextCitation();
}
