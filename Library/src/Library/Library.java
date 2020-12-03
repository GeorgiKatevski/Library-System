package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<User> users = new ArrayList<User>();
    private List<Book> books = new ArrayList<Book>();

    private boolean isLogged = false;
    private boolean isAdmin = false;

    public Library() {
        setLogged(false);
        setAdmin(false);
        users = new ArrayList<User>(20);
        books = new ArrayList<Book>(20);
    }

    public Library(ArrayList<User> users, ArrayList<Book> books) {
        setBooks(books);
        setUsers(users);
      //  setLogged(true);
    }

    public Library(Library rhs)
    {
        setAdmin(rhs.isAdmin);
        setLogged(rhs.isLogged);
        setUsers(rhs.users);
        setBooks(rhs.books);
    }
    public void setAdmin(boolean admin) {

        this.isAdmin = admin;
    }

    public void setBooks(List<Book> books) {
        this.books = books;

    }

    public void setLogged(boolean logged) {
        this.isLogged = logged;
    }

    public void setUsers(List<User> users) {

        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void login(String name, String password, boolean isAdmin) {
        if (!isLogged) {

            boolean isValid = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password) && users.get(i).isAdmin() == isAdmin) {
                    this.isLogged = true;
                    isValid = true;
                    if (users.get(i).isAdmin()) {
                        this.isAdmin = true;
                    }
                    System.out.println("Welcome " + name);

                    break;
                }

            }
            if (!isValid) {
                System.out.println("Invalid account!");
            }
        }
    }

    public void logout() {
        setLogged(false);
        setAdmin(false);
    }


    public void booksAll() {
        if (isLogged) {
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i).toString());

            }

        } else {
            System.out.println("You have to login first");

        }
    }

    public void booksInfo(String ISBN) {
        if (isLogged) {

            boolean isValidBook = false;
            for (int i = 0; i < books.size(); i++) {
                if (ISBN.equals(books.get(i).getISBN())) {
                    isValidBook = true;
                    System.out.println(books.get(i).toString());
                    break;
                }

            }
            if (!isValidBook) {
                System.out.println("Invalid ISBN");

            }
        } else {
            System.out.println("You have to log in first");

        }
    }

    public Book bookfind(String option, String name) {
        if (isLogged) {
            if (option.equals("title")) {
                boolean isValid = false;
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getTitle().equals(name)) {
                        isValid = true;
                        return books.get(i);

                    }
                }
                if (!isValid) {
                    System.out.println("Invalid Title");

                }
            }
            if (option.equals("author")) {
                boolean isValid = false;
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getAuthor().equals(name)) {
                        isValid = true;
                        return books.get(i);

                    }
                }
                if (!isValid) {
                    System.out.println("Invalid Author");

                }

            }


        } else {
            System.out.println("You have to log in first");
            return null;
        }
        return null;
    }

    public void addUser(User user) {
        if (isAdmin  && isLogged ) {
            users.add(user);
        } else {
            System.out.println("You are not admin or you are not logged in");

        }
    }

    public void pushUser(String name, String password) {
        User user = new User(name, password, false);
        addUser(user);

    }

    void removeUser(String name) {
        if (isAdmin  && isLogged ) {
            int count = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName().equals(name)) {
                    count = i;
                    break;
                }
            }
            users.remove(count);
        } else {
            System.out.println("You are not admin or you are not logged in");

        }
    }


    public void booksAdd(Book book) {
        if (isAdmin  && isLogged ) {
            books.add(book);
        } else {
            System.out.println("You are not admin or you are not logged in");
        }
    }


    public void booksRemove(String name) {
        if (isAdmin  && isLogged ) {
            int count = 0;
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle().equals(name)) {
                    count = i;
                    break;
                }
            }

            books.remove(count);
        } else {
            System.out.println("You are not admin or you are not logged in");

        }

    }


    void quickSort(String option,int first, int last)
    {

        int p = 0, j, i;
        Book temp=new Book();
        if (first < last)
        {
            p = first;
            i = first;
            j = last;

            while (i < j)
            {
                        while (books.get(i).getYear() >= books.get(p).getYear() && i < last) {
                            i++;
                            while (books.get(j).getYear() < books.get(p).getYear()) {
                                j--;
                            }

                            if (i < j) {
                                temp = books.get(i);
                                books.set(i, books.get(j));
                                books.set(j, temp);
                            }
                        }

            }
            temp = books.get(p);
            books.set(p, books.get(j));
            books.set(j, temp);


            quickSort(option,first, j - 1);
            quickSort(option,j + 1, last);
        }

    }

    public boolean isLogged() {
        return isLogged;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "Library{" +
                "users=" + users + '\n' +
                ", books=" + books + '\n' +
                ", isLogged=" + isLogged +
                ", isAdmin=" + isAdmin +
                '}' + '\n';
    }
}
