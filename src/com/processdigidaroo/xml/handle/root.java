/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processdigidaroo.xml.handle;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alirezakhtm
 */
@XmlRootElement(name = "root")
public class root {
    private boolean testmode;
    private message msg;
    private database db;
    private List<Integer> lstPrice;
    private int threadNumber;
    private boolean firstPriceFailed;
    private int threadPoolSize;
    private int threadPoolConnection;
    private boolean useXMLFile;
    private int stepSize;
    private ServiceSetting serviceSetting;

    public boolean isUseXMLFile() {
        return useXMLFile;
    }

    @XmlElement(name = "useXMLFile")
    public void setUseXMLFile(boolean useXMLFile) {
        this.useXMLFile = useXMLFile;
    }

    public int getThreadPoolConnection() {
        return threadPoolConnection;
    }

    @XmlElement(name = "threadPoolConnection")
    public void setThreadPoolConnection(int threadPoolConnection) {
        this.threadPoolConnection = threadPoolConnection;
    }
    
    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    @XmlElement(name = "threadPoolSize")
    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public void setFirstPriceFailed(boolean firstPriceFailed) {
        this.firstPriceFailed = firstPriceFailed;
    }
    
    @XmlElement(name = "firstPriceFailed")
    public boolean isFirstPriceFailed() {
        return firstPriceFailed;
    }
    
    public int getThreadNumber() {
        return threadNumber;
    }

    @XmlElement(name = "threadnumber")
    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    public boolean getTestmode() {
        return testmode;
    }

    @XmlElement(name = "testmode")
    public void setTestmode(boolean testmode) {
        this.testmode = testmode;
    }

    public message getMsg() {
        return msg;
    }

    @XmlElement(name = "message")
    public void setMsg(message msg) {
        this.msg = msg;
    }

    public database getDb() {
        return db;
    }

    @XmlElement(name = "database")
    public void setDb(database db) {
        this.db = db;
    }
    
    public List<Integer> getLstPrice() {
        return lstPrice;
    }

    @XmlElementWrapper(name = "prices")
    @XmlElement(name = "price")
    public void setLstPrice(List<Integer> lstPrice) {
        this.lstPrice = lstPrice;
    }

    public int getStepSize() {
        return stepSize;
    }

    @XmlElement(name = "stepsize")
    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }

    public ServiceSetting getServiceSetting() {
        return serviceSetting;
    }

    @XmlElement(name = "service")
    public void setServiceSetting(ServiceSetting serviceSetting) {
        this.serviceSetting = serviceSetting;
    }
    
}
