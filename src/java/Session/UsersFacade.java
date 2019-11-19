/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Users;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "jpa_examPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public void Save(String name, String fname, String email) {
        try{
            Users user =new Users (name,fname,email);
            em.persist(user);
        }catch (Exception e){
            throw new EJBException(e.getMessage());           
        }
    }
}
