package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();
    public Book(String title, String category, float cost){
        super(title, category, cost);

    }
    



    public void addAuthor(String AuthorName){
        if (authors.contains(AuthorName)){
            System.out.println("The author already in the List");

        }
        else{
        
            authors.add(AuthorName);
            System.out.println("Successful adding author name to the list");   
        }
    }

    public void removeAuthor(String AuthorName){
        if (authors.contains(AuthorName)){
            authors.remove(AuthorName);
            System.out.println("successful removing author name out of the list");
        }
        else{
            System.out.println("The author name have not already in the list");
        }
    }


}

