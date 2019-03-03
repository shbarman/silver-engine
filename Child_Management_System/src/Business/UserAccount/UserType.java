/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

/**
 *
 * @author bhash
 */
public abstract class UserType{
     
    public enum Type{
        Admin("Admin User"), Employee("Employee User"), User("Customer User");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

}
