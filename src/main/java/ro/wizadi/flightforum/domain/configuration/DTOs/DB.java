package ro.wizadi.flightforum.domain.configuration.DTOs;

//POJO
public class DB {
    private String name;
    private String user;
    private String pass;
    private short port=300;



    public void setPort(short port) {
        this.port = port;
    }

    public short getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}