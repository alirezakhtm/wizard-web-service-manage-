/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processdigidaroo.xml.handle;

import javax.xml.bind.annotation.*;
/**
 *
 * @author alirezakhtm
 */
@XmlRootElement(name = "database")
public class database {
    private String username;
    private String password;
    private String dbname;
    private String driver;
    private String tagname;

    public database() {
    }

    public database(String username, String password, String dbname, String driver, String tagname) {
        this.username = username;
        this.password = password;
        this.dbname = dbname;
        this.driver = driver;
        this.tagname = tagname;
    }
    
    public String getUsername() {
        return username;
    }
    
    @XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbname() {
        return dbname;
    }
    
    @XmlElement(name = "dbname")
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDriver() {
        return driver;
    }
    
    @XmlElement(name = "driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTagname() {
        return tagname;
    }
    
    @XmlElement(name = "tagname")
    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
    
}
