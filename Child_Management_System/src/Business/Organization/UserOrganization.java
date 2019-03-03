/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Role.UserRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserOrganization extends Organization{

    public UserOrganization() {
        super(Organization.Type.User.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        //roles.add(new UserRole());
        return roles;
    }
     
   
    
    
}
