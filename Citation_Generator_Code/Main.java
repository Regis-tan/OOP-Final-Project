package OOP_Final.Citation_Generator_Code;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        boolean running = true; //Running variable is true, and the loop will continue.
        HashMap<String, APA_7_Superclass> citations_list = new HashMap<>();
        
        while(running){
            //Options for the main menu.
            seperator("=", 40);
            System.out.println("APA-7th Edition Citation Generator");
            System.out.println("1. Add Citation\n2. Print Citaton List\n0. Exit");

            seperator("-", 30);
            String option = stringPrompt("Enter option (0-2): ");
            
            //Conditional statements for option variable.
            if(option.equals("1")){
                //Add citation picked
                System.out.println("Select Citation type\n1. Webpage\n2. Book");
                option = stringPrompt("Enter option (1-2): ");

                if(option.equals("1")){
                    //Webpage
                    String web_title = stringPrompt("Enter article title: ");
                    String web_year = stringPrompt("Enter publish year (Ex: 2020): ");
                    String web_date = stringPrompt("Enter publish date (Ex: May 12): ");
                    String web_site = stringPrompt("Enter website name: ");
                    String web_url = stringPrompt("Enter article URL: ");

                    Webpage citation = new Webpage(web_title, web_year, web_date, web_site, web_url);
                    
                    boolean adding_authors = true;
                    seperator("-", 30);
                    while(adding_authors){
                        //Prompts the user for the first and last name of the author.
                        String first_name = stringPrompt("Enter author's first name: ");
                        String last_name = stringPrompt("Enter author's last name: ");
                        citation.addAuthor(first_name, last_name); //Adds it to the citation.
                        
                        String continue_adding = stringPrompt("Continue adding? (y/n): ");
                        if(continue_adding.equals("n")){
                            adding_authors = false;//Leaves the adding_authors while loop.
                        } else{
                            seperator("-", 30);
                        }
                    }
                    citations_list.put(getFirstPerson(citation.getAuthorsNoInitial()), citation); //Adds the author to a hashmap with the object as the value and the first author as its key.
                } else if(option.equals("2")){
                    //Prompts the user for the variables.
                    String book_title = stringPrompt("Enter book title: ");
                    String book_year = stringPrompt("Enter publish year (Ex: 2020): ");
                    String book_publisher = stringPrompt("Enter book publisher: ");

                    Book citation = new Book(book_title, book_year, book_publisher);
                    
                    //Starts the while loop.
                    boolean adding_authors = true;
                    seperator("-", 30);
                    while(adding_authors){
                        String first_name = stringPrompt("Enter author's first name: ");
                        String last_name = stringPrompt("Enter author's last name: ");
                        citation.addAuthor(first_name, last_name);
                        
                        String continue_adding = stringPrompt("Continue adding? (y/n): ");
                        if(continue_adding.equals("n")){
                            adding_authors = false;
                        } else{
                            seperator("-", 30);
                        }
                    }
                    citations_list.put(getFirstPerson(citation.getAuthorsNoInitial()), citation); //Adds the author to a hashmap with the object as the value and the first author as its key.
                }
            } else if(option.equals("2")){
                //Print citation picked
                ArrayList<HashMap.Entry<String, APA_7_Superclass>> entries = new ArrayList<>(citations_list.entrySet());
                entries.sort(HashMap.Entry.comparingByKey());

                for (HashMap.Entry<String, APA_7_Superclass> entry : entries) {
                    System.out.println("- " + entry.getValue().getCitation() + " - " + entry.getValue().getIntextCitation());
                }
                continuePrompt();
            } else if(option.equals("0")){
                //Quit picked
                System.out.println("Thank you for using this program!");
                running = false;
            } else{
                
                System.out.println(option + " is not a valid option. Try again.");
                continuePrompt();
            }
        }
    }

    //Methods
    public static void continuePrompt(){
        Scanner prompt = new Scanner(System.in);
        System.out.print("Press enter to continue.");
        prompt.nextLine();
    }

    public static void seperator(String text, int length){
        for(int i = 0; i < length; i++){System.out.print(text);}
        System.out.println();
    }

    public static String stringPrompt(String message){
        Scanner prompt = new Scanner(System.in);

        System.out.print(message);
        return prompt.nextLine();
    }

    public static String getFirstPerson(String names) {
        if (names == null || names.isEmpty()) {
            return "";
        }

        String[] nameArray = names.split(",");
        if (nameArray.length > 0) {
            return nameArray[0].trim();
        } else {
            return "";
        }
    }
}
