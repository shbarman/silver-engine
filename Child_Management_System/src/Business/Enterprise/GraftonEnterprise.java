/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author bhash
 */
public class GraftonEnterprise extends Enterprise {

    public GraftonEnterprise(String name, EnterpriseType type) {
        super(name, Enterprise.EnterpriseType.GRAFTON);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       return null;
    }
    
}
