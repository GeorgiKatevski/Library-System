package Library;

import java.util.Arrays;

public class Book {
    private String author="sadsd";
    private String title="";
    private String genre="";
    private int year=0;
    private String description="";

    private String[] keyWords=new String[12];
    private double rate=2.0;
    private String ISBN="";


   public Book()
    {
        setRating(5.0);
        setGenre("War");
        setDescription("_description");
        setISBN("_ISBN");
        //setKeyWords();
    }

    public Book(String title,String _author,
				String _genre,String _ISBN,double _rating,int _year,
				   	String _description,String[] _keyWords)
    {
        setRating(_rating);
        setGenre(_genre);
        setDescription(_description);
        setISBN(_ISBN);
        setKeyWords(_keyWords);
    }

  public  void setGenre(String _genre)
    {

        if (_genre == "Action"	||_genre=="Adventure" ||
                _genre=="Biography" ||_genre =="Romance"  ||
                _genre=="War"       ||_genre=="Mystery"   ||
                _genre=="Horror"    || _genre=="History"  ||
                _genre=="Sport"     || _genre=="Sci-Fi"   )
        {
            genre = _genre;
        }
        else
        {
            genre = "Wrong genre";
        }

    }
   public void setRating(double _rating)
    {

        assert(rate > 0.0);
        assert(rate < 10.0);
        rate = _rating;
    }
   public void setDescription(String _description)
    {
        int len = _description.length();
        if (len >= 256)
        {
            description = "";
        }
        else
        {
            description = _description;
        }
    }
   public void setKeyWords(String[] _words)
    {
        for (int i = 0; i < _words.length; i++)
        {
            keyWords[i] = _words[i];
        }
    }
    public void setISBN(String _ISBN)
    {
        if (_ISBN!=null)
        {
            ISBN = _ISBN;
        }
        else
        {
            ISBN = "Dedault_ISBN";
        }
    }

    public double getRating() {
       return rate;
    }
    public String getTitle()
    {
        return title;
    }
	 public String getAuthor(){
        return author;
     }
    public String getISBN() {
        return ISBN;
     }
	public String getGenre() {
        return genre;
     }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", keyWords=" + Arrays.toString(keyWords) +
                ", rate=" + rate +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
