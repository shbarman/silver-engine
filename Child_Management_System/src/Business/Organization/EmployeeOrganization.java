/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Role.EmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeOrganization extends Organization{

    public EmployeeOrganization() {
        super(Organization.Type.Employee.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
   //     roles.add(new EmployeeRole());
        return roles;
    }
     
}