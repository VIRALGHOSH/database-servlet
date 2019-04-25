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
    int credential_id;
    String username;
    String password; 

    public Login(int credential_id, String username, String password) {
        this.credential_id = credential_id;
        this.username = username;
        this.password = password;
    }

    public Login() {
        this.credential_id = 0;
        this.username = "";
        this.password = "";
    }

    public int getId() {
        return credential_id;
    }

    public void setId(int id) {
        this.credential_id = id;
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
        return "Login{" + "id=" + credential_id + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
