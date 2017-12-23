/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processdigidaroo.xml.handle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alirezakhtm
 */
@XmlRootElement(name = "service")
public class ServiceSetting {
    private String spID;
    private String serviceID;

    public ServiceSetting() {
    }

    public ServiceSetting(String spID, String serviceID) {
        this.spID = spID;
        this.serviceID = serviceID;
    }
    
    public String getSpID() {
        return spID;
    }

    @XmlElement(name = "spid")
    public void setSpID(String spID) {
        this.spID = spID;
    }

    public String getServiceID() {
        return serviceID;
    }

    @XmlElement(name = "serviceid")
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    
}
