/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystemalgorithm.model;

/**
 *
 * @author pema
 */
public class User {
    
    
    private int uid;
    private String name;
    private String address;
    private String dpt;
    private int salary;
    private String photos;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    
    
    public User(int uid, String name, String address, String dpt, int salary, String photos) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.dpt = dpt;
        this.salary = salary;
        this.photos = photos;
    }
    
    
    
    
}
