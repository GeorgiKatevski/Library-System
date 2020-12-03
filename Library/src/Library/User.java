package Library;

public class User {
    private String name;
    private String password;
    private boolean isAdmin;

    public User(String _name,String _password,boolean _isAdmin)
    {
        setName(_name);
        setPassword(_password);
        setAdmin(_isAdmin);
    }
 public User()
{
    setName("Default");
    setPassword("Default");
    setAdmin(false);
}


    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
