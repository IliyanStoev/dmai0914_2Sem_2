package controlLayer;


import modelLayer.*;
import DBLayer.*;

import java.util.List;
import java.util.ArrayList;

public class CustomerCtr {
   
    public CustomerCtr() {
        
    }
    
    public void insertCustomer(String name, String address, int zipCode, String city, String phone, String email) throws Exception
    {    
         Customer cust = new Customer();
         cust.setName(name);
         cust.setAddress(address);
         cust.setZipCode(zipCode);
         cust.setCity(city);
         cust.setPhoneNo(phone);
         cust.setEmail(email);
  
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
    
    public Customer findByCid(int cid) {
        DBIFCustomer dbCustomer = new DBCustomer();
        return dbCustomer.findCustomer(cid);
    }
    
    public int updateCustomer(String name, String address, int zipCode, String city, String phoneNo, String email, int cid) {
        DBIFCustomer dbCustomer = new DBCustomer();
        Customer cust = new Customer();
        cust.setName(name);
        cust.setAddress(address);
        cust.setZipCode(zipCode);
        cust.setCity(city);
        cust.setPhoneNo(phoneNo);
        cust.setEmail(email);
        cust.setCid(cid);
        return  dbCustomer.updateCustomer(cust);
    }

    public void removeCustomer(Customer cust) {
    	DBIFCustomer dbCustomer = new DBCustomer();
    	dbCustomer.removeCustomer(cust);
    }
       
}
