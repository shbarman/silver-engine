package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.*;
//import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserType;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
          Network network1_MA =  system.createAndAddNetwork();
          Network network2_NH = system.createAndAddNetwork();
          Network network3_CONN = system.createAndAddNetwork();
          
          
          Enterprise enterpriseMA_Boston = network1_MA.getEnterpriseDirectory().createAndAddEnterprise("Boston", Enterprise.EnterpriseType.BOSTON);
          Enterprise enterpriseMA_Cambridge = network1_MA.getEnterpriseDirectory().createAndAddEnterprise("Cambridge", Enterprise.EnterpriseType.CAMBRIDGE);
           
          Enterprise enterpriseNH_Grafton = network2_NH.getEnterpriseDirectory().createAndAddEnterprise("Grafton", Enterprise.EnterpriseType.GRAFTON);
          Enterprise enterpriseNH_Carroll = network2_NH.getEnterpriseDirectory().createAndAddEnterprise("Carroll", Enterprise.EnterpriseType.CARROLL);
          
          Enterprise enterpriseCONN_Hartford = network3_CONN.getEnterpriseDirectory().createAndAddEnterprise("Hartford", Enterprise.EnterpriseType.HARTFORD);
          Enterprise enterpriseCONN_Fairfield = network3_CONN.getEnterpriseDirectory().createAndAddEnterprise("Fairfield", Enterprise.EnterpriseType.FAIRFIELD);
        
          
          Organization adminBoston= enterpriseMA_Boston.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
          Organization adminCambridge= enterpriseMA_Cambridge.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
          
          Organization adminGrafton= enterpriseNH_Grafton.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
          Organization adminCarroll= enterpriseNH_Carroll.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
          
          Organization adminHartford= enterpriseCONN_Hartford.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
          Organization adminFairfield= enterpriseCONN_Fairfield.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
          
          Employee employeeBoston1 = adminBoston.getEmployeeDirectory().createEmployee("Bhashmi Fatnani","Boston");
          Employee employeeCambridge1 = adminCambridge.getEmployeeDirectory().createEmployee("Kumari Deepshikha","Cambridge");
       //   Employee employeeCambridge2 = adminBoston.getEmployeeDirectory().createEmployee("T. Madhu","Cambridge");
        //  Employee employeeBoston2 = adminCambridge.getEmployeeDirectory().createEmployee("Ayesha Singhal","Boston");
          
          Employee employeeGrafton1 = adminGrafton.getEmployeeDirectory().createEmployee("Shuravi Barman","Grafton");
          Employee employeeCarroll1 = adminCarroll.getEmployeeDirectory().createEmployee("Shivangi Mukati","Carroll");
        //  Employee employeeGrafton2 = adminGrafton.getEmployeeDirectory().createEmployee("Komal Prasad","Grafton");
         // Employee employeeCarroll2 = adminCarroll.getEmployeeDirectory().createEmployee("Ayushi Jha","Carroll");
          
          Employee employeeHartford1 = adminGrafton.getEmployeeDirectory().createEmployee("Rushali Udhani","Hartford");
          Employee employeeFairfield1 = adminGrafton.getEmployeeDirectory().createEmployee("Aditi Kinikar","Fairlfield");
       //   Employee employeeHartford2 = adminGrafton.getEmployeeDirectory().createEmployee("Anamika Negi","Hartford");
        //  Employee employeeFairfield2 = adminGrafton.getEmployeeDirectory().createEmployee("Aanchal Porwal","Fairlfield");
        
        UserAccount userAdminBoston = system.getUserAccountDirectory().createUserAccount("adminBoston", "adminBoston", new AdminRole());
        UserAccount userAdminCambridge = system.getUserAccountDirectory().createUserAccount("adminCambridge", "adminCambridge", new AdminRole());
        
        UserAccount userAdminGrafton = system.getUserAccountDirectory().createUserAccount("adminGrafton", "adminGrafton", new AdminRole());
        UserAccount userAdminCarroll = system.getUserAccountDirectory().createUserAccount("adminCarroll", "adminCarroll", new AdminRole());
        
        UserAccount userAdminHartford = system.getUserAccountDirectory().createUserAccount("adminHartford", "adminHartford", new AdminRole());
        UserAccount userAdminFairfield = system.getUserAccountDirectory().createUserAccount("adminFairfield", "adminFairfield", new AdminRole());
        
        UserAccount userEmployeeBoston = system.getUserAccountDirectory().createUserAccount("employeeBoston", "employeeBoston", new EmployeeRole());
        UserAccount userEmployeeCambridge = system.getUserAccountDirectory().createUserAccount("employeeCambridge", "employeeCambridge", new EmployeeRole());
        
        UserAccount userEmployeeGrafton = system.getUserAccountDirectory().createUserAccount("employeeGrafton", "employeeGrafton", new EmployeeRole());
        UserAccount userEmployeeCarroll = system.getUserAccountDirectory().createUserAccount("employeeCarroll", "employeeCarroll", new EmployeeRole());
        
        UserAccount userEmployeeHartford = system.getUserAccountDirectory().createUserAccount("employeeHartford", "employeeHartford", new EmployeeRole());
        UserAccount userEmployeeFairfield = system.getUserAccountDirectory().createUserAccount("employeeFairfield", "employeeFairfield", new EmployeeRole());
        
        
        return system;
    }
    
}
