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
public class CambridgeEnterprise extends Enterprise {

    public CambridgeEnterprise(String name, EnterpriseType type) {
        super(name, Enterprise.EnterpriseType.CAMBRIDGE);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
