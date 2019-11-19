/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Session.UsersFacade;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author fotin
 */
@Named
@RequestScoped

public class Web {
    
    @EJB
    private UsersFacade uf;
    
    
    private String name;
    private String fname;
    private String email;

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
