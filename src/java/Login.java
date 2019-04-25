/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viral
 */
public class Login {
    int id;
    String username;
    String password; 

    public Login(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Login() {
        this.id = 0;
        this.username = "";
        this.password = "";
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
