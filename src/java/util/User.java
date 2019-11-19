package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp User
 */
import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6297385302078200511L;
	
	private String uname;
        private String fname;
	private String email;
	

	public User(String nm, String em, int i){
		this.uname=nm;
		this.email=em;
	}

    public User(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public void setName(String name) {
		this.uname = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return uname;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString(){
		return "Name="+this.uname+", Email="+this.email;
	}
}
