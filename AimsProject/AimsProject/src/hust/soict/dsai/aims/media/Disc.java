package hust.soict.dsai.aims.media;

public class Disc extends Media{
    
    private int length;
    private String director;

// Constructor
public Disc(String title){
    super(title);
}

public Disc(String title, String category, float cost){
    super(title, category, cost);
}

public Disc(String title, String category, String director, float cost){
    this(title, category, cost);
    this.director = director;
}

public Disc(String title, String category, String director, int length, float cost){
    this(title, category, director, cost);
    this.length = length;
}



// get and set method
public void setLength(int length){
    this.length = length;
}

public int getLength(){
    return this.length;
}

public void setDirector(String director){
    this.director = director;
}

public String getDirector(){
    return this.director;
}


}