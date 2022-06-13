package hust.soict.dsai.aims.media;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class Book extends Media {
    private String content = new String();
    private List<String> ListOfAuthors = new ArrayList<String>();
    private List<String> contentTokens;
	private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();

    public Book(String title, String category, float cost, String content){
        super(title, category, cost);
        this.content = content;
        this.processContent();

    }

    private void processContent() {
		
		contentTokens = Arrays.asList(content.toLowerCase().split("\\P{L}+"));
		
		TreeMap<String, Integer> treeMap =  new TreeMap<String, Integer>();
		
		String ls;
		for (String s : contentTokens) {
			ls = s.toLowerCase();
			if (treeMap.containsKey(ls)) {
				treeMap.replace(ls, treeMap.get(ls) + 1);
			} else {
				treeMap.put(ls, 1);
			}
		}

		wordFrequency = treeMap;
	}

    public void setContent(String content){
        this.content = content;
        this.processContent();

    }

    public String getContent(String content){
        return content;
        
    }

    public List<String> getContentTokens() {
		return contentTokens;
	}

    public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

    public void addAuthor(String AuthorName){
        if (ListOfAuthors.contains(AuthorName)){
            System.out.println("The author already in the List");

        }
        else{
        
            ListOfAuthors.add(AuthorName);
            System.out.println("Successful adding author name to the list");   
        }
    }

    public void removeAuthor(String AuthorName){
        if (ListOfAuthors.contains(AuthorName)){
            ListOfAuthors.remove(AuthorName);
            System.out.println("successful removing author name out of the list");
        }
        else{
            System.out.println("The author name have not already in the list");
        }
    }


    public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("CD title: ", this.getTitle()));
		result.append(String.format("CD category: ", this.getCategory()));
		
	
		
		result.append(String.format("CD cost: ", this.getCost()));

        result.append("The list of author(s) of this books:\n");
		int i = 0;
        for (i = 0; i < ListOfAuthors.size(); i++) {
			result.append(String.format("Author: ", i+1, ListOfAuthors.get(i)));
		}
		
        result.append(String.format("Book length of tokens: ", this.getContentTokens().size()));

		return result.toString();
	}
    

}

