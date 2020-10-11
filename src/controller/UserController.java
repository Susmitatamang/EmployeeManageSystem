/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import employeemanagementsystemalgorithm.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pema
 */
public class UserController {
    
       Database db;
    Connection con;
    PreparedStatement pst;
    
    
       public UserController(){
        super();
        db = new Database();
        con = db.getConnection();
        
    }
       
       public int addUser(User model)
    {
        int res=0;
        String sql="";
        System.err.println(model.toString());
        try{
            sql="INSERT INTO `user`(`name`, `address`, `dpt`, `salary`, `photo`) VALUES (?,?,?,?,?)";
            pst=con.prepareStatement(sql);
            System.out.println(sql);
            pst.setString(1, model.getName());
            pst.setString(2, model.getAddress());
            pst.setString(3, model.getDpt());
            pst.setInt(4, model.getSalary());
            pst.setString(5, model.getPhotos());
            res=pst.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
           
        }
        return res;
    }
       
     public ArrayList<User> getUsers()
    {
        ArrayList<User> al= new ArrayList<>();
        try{
            pst=con.prepareStatement("select * from user");
            ResultSet rs= pst.executeQuery();
            while(rs.next())
            {
               
                al.add(new User(rs.getInt("uid"),rs.getString("name") ,rs.getString("address"), rs.getString("dpt"),rs.getInt("salary"), rs.getString("photo")));
                
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return al;
        
    }     
       
       
       
   
         public int updateUser(User model)
    {
        int res=0;
        String sql="";
        System.err.println(model.toString());
        try{
            sql="INSERT INTO `user`(`name`, `address`, `dpt`, `salary`, `photo`) VALUES (?,?,?,?,?) where uid=?";
            pst=con.prepareStatement(sql);
            System.out.println(sql);
            pst.setString(1, model.getName());
            pst.setString(2, model.getAddress());
            pst.setString(3, model.getDpt());
            pst.setInt(4, model.getSalary());
            pst.setString(5, model.getPhotos());
            pst.setInt(6, model.getUid());
            res=pst.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
           
        }
        return res;
    }
    
     public User getUserByID(int id)
    {
      
        try{
            pst=con.prepareStatement("select * from user where uid=?");
            pst.setInt(1, id);
            ResultSet rs= pst.executeQuery();
            while(rs.next())
            {
               return new User(rs.getInt("uid"),rs.getString("name") ,rs.getString("address"), rs.getString("dpt"),rs.getInt("salary"), rs.getString("photo"));
                
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return null;
        
    }   
    
     public boolean deleteUserByID(int id)
    {
      
        try{
            pst=con.prepareStatement("delete from user where uid=?");
            pst.setInt(1, id);
            return pst.execute();
           
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return false;
        
    }   
    
}
