package modelo;

public class Usuario 
{
    private int id;
    private String username;
    private String pass;

    public Usuario(int id, String username, String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }
    
    public Usuario()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
