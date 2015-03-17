package controlLayer;


import modelLayer.*;
import DBLayer.*;

import java.util.List;
import java.util.ArrayList;

public class CustomerCtr {
   
    /** Creates a new instance of CtrCustomer */
    public CustomerCtr() {
        
    }
    
    public List<Customer> findAllCustomerloyee() {
      DBIFCustomer dbCustomer = new DBCustomer();
      List<Customer> allCustomer = new ArrayList<Customer>();
      allCustomer = dbCustomer.getAllCustomers(false);
      return allCustomer;
    }
    
    public List<Customer> findByFname(String name) {
        DBIFCustomer dbCustomer = new DBCustomer();
        return dbCustomer.searchCustomer(name, true);
    }
    
    public Customer findById(int cid) {
        DBIFCustomer dbCustomer = new DBCustomer();
        return dbCustomer.findCustomer( cid, true);
    }
      
    /*public int updateCustomer(Customer c) {
          DBIFCustomer dbCustomer = new DBCustomer();
          Customer Customer = new Customer();
          Customer.setCid(cid);
          Customer.setName(name);
          Customer.setLname(lname);
          Customer.setSupervisor(new Customerloyee(superssn));
          Customer.setSalary(salary);
          return  dbCustomer.updateCustomerloyee(Customer);
      }*/
    
    public void insertCustomer(String name, String address, String codeZip, String city, String phone) throws Exception
      {    
           Customer cust = new Customer();
           cust.setName(name);
           cust.setAddress(address);
           cust.setZipCode(codeZip);
           cust.setCity(city);
           cust.setPhoneNo(phone);
    
           try{
            DBConnection.startTransaction();
            DBCustomer dbCustomer = new DBCustomer();
            dbCustomer.insertCustomer(cust);
            DBConnection.commitTransaction();
           }
           catch(Exception e)
           {
               DBConnection.rollbackTransaction();
               throw new Exception("Customer not inserted");
           }
      }
    
}
