/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeListBoston;
    private ArrayList<Employee> employeeListCambridge;
    private ArrayList<Employee> employeeListGrafton;
    private ArrayList<Employee> employeeListCarroll;
    private ArrayList<Employee> employeeListHartford;
    private ArrayList<Employee> employeeListFairfield;

    public ArrayList<Employee> getEmployeeListBoston() {
        return employeeListBoston;
    }

    public ArrayList<Employee> getEmployeeListCambridge() {
        return employeeListCambridge;
    }

    public ArrayList<Employee> getEmployeeListGrafton() {
        return employeeListGrafton;
    }

    public ArrayList<Employee> getEmployeeListCarroll() {
        return employeeListCarroll;
    }

    public ArrayList<Employee> getEmployeeListHartford() {
        return employeeListHartford;
    }

    public ArrayList<Employee> getEmployeeListFairfield() {
        return employeeListFairfield;
    }


    public EmployeeDirectory() {
        employeeListBoston = new ArrayList();
        employeeListCambridge = new ArrayList();
        employeeListGrafton = new ArrayList();
        employeeListCarroll = new ArrayList();
        employeeListHartford = new ArrayList();
        employeeListFairfield = new ArrayList();
    }

    
    
    public Employee createEmployee(String name, String loc){
        if(loc.equals("Boston")){
        Employee employeeBoston = new Employee();
        employeeBoston.setName(name);
        employeeBoston.setLocation(loc);
        employeeListBoston.add(employeeBoston);
        return employeeBoston;
        }
        if(loc.equals("Cambridge")){
        Employee employeeCambridge = new Employee();
        employeeCambridge.setName(name);
        employeeCambridge.setLocation(loc);
        employeeListCambridge.add(employeeCambridge);
        return employeeCambridge;
        }
        if(loc.equals("Grafton")){
        Employee employeeGrafton = new Employee();
        employeeGrafton.setName(name);
        employeeGrafton.setLocation(loc);
        employeeListGrafton.add(employeeGrafton);
        return employeeGrafton;
        }
            if(loc.equals("Carroll")){
        Employee employeeCarroll = new Employee();
        employeeCarroll.setName(name);
        employeeCarroll.setLocation(loc);
        employeeListCarroll.add(employeeCarroll);
        return employeeCarroll;
        }
            if(loc.equals("Fairfield")){
        Employee employeeFairfield = new Employee();
        employeeFairfield.setName(name);
        employeeFairfield.setLocation(loc);
        employeeListFairfield.add(employeeFairfield);
        return employeeFairfield;
        }    
           if(loc.equals("Hartford")){
        Employee employeeHartford = new Employee();
        employeeHartford.setName(name);
        employeeHartford.setLocation(loc);
        employeeListHartford.add(employeeHartford);
        return employeeHartford;
        }  
        return null;
    }

}