package Library;

import java.io.IOException;

import java.util.*;

public class SystemTest {
    public static void main(String[] args) throws IOException {
        String[] words = new String[12];
        for (int i = 0; i < 12; i++) {
            words[i] = "zvezdi";
        }
        Book book = new Book("Kalmari", "Georgi Katevski", "Action", "isbn1", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);
        Book book2 = new Book("Kalmari2", "Georgi Katevski", "Action", "isbn2", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);
        Book book3 = new Book("Kalmari3", "Georgi Katevski", "Action", "isbn3", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);
        Book book4 = new Book("Kalmar4", "Georgi Katevski", "Action", "isbn4", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);
        Book book5 = new Book("Kalmari5", "Georgi Katevski", "Actiosdsdn", "isbn5", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);
        Book book6 = new Book("Kalmari64", "Georgi Katevski", "Action", "isbn6", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);
        Book book7 = new Book("Kalmari55", "Georgi Katevski", "Action", "isbn7", 5.5, 1999, "kalmari e suzdadena prez idealnoto vreme", words);

        User user = new User("Georgi", "Parola", false);
        User user2 = new User("Ivan", "Parola", false);
        User user3 = new User("shishkan", "Parola", false);
        User user4 = new User("peshu", "Parola", false);
        User user5 = new User("pencho", "Parola", false);
        User user6 = new User("goshu", "Parola", false);
        User user7 = new User("chicho", "Parola", false);
        User user8 = new User("Klr", "Parola", false);


        ArrayList<Book> books = new ArrayList<Book>(10);
        books.add(book);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book2);

        ArrayList<User> users = new ArrayList<User>(10);
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);

        // System.out.println(user.toString());


        Library library = new Library(users, books);
       //library.setLogged(true);
        library.booksAll();
        System.out.println("------");
       // library.booksInfo("isbn2");


        //  System.out.println(library.toString());
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = myObj.nextLine();
        System.out.println("Enter Password: ");
        String password=myObj.nextLine();
        System.out.println("Are you admin? (true/false)");
        boolean flag=myObj.nextBoolean();
        System.out.println(name + " " + password);

        library.login(name,password,flag);



        library.booksAll();
        library.booksInfo("isbn2");











    }


}
