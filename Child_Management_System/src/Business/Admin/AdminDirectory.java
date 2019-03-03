/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Admin;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author bhash
 */
public class AdminDirectory {
     private ArrayList<Admin> adminList;

    public AdminDirectory() {
        adminList = new ArrayList();
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }
    
    public Admin createAdmin(String name){
        Admin admin = new Admin();
        admin.setAdminName(name);
        adminList.add(admin);
        return admin ;
    }
}
