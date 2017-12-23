/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processdigidaroo.xml.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author alirezakhtm
 */
public class xmlHandler {
    
    private boolean testMode;
    private boolean sendMsgForSuccess;
    private boolean sendMsgForFail;
    private String username;
    private String password;
    private String driver;
    private String tagName;
    private String dbName;
    private List<Integer> lstPrice;
    private int threadNumber;
    private boolean firstPriceFailed;
    private int threadPoolSize;
    private int threadPoolConnection;
    private boolean useXMLFile;
    private int stepSize;
    private String SPID;
    private String serviceID;
    
    private String successMsg = null;
    private String failMsg = null;

    public xmlHandler() {
        try{
            File file = new File("xml-config/config.xml");
            JAXBContext context = JAXBContext.newInstance(root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            root setting = (root)unmarshaller.unmarshal(file);
            boolean bTestMode = setting.getTestmode();
            message msg = setting.getMsg();
            database db = setting.getDb();
            List<Integer> prices = setting.getLstPrice();
            int threadNumber = setting.getThreadNumber();
            ServiceSetting serviceSetting = setting.getServiceSetting();
                        
            this.threadNumber = threadNumber;
            this.testMode = bTestMode;
            this.sendMsgForSuccess = msg.isSuccess();
            this.sendMsgForFail = msg.isFail();
            this.username = db.getUsername();
            this.password = db.getPassword();
            this.driver = db.getDriver();
            this.tagName = db.getTagname();
            this.dbName = db.getDbname();
            this.lstPrice = prices;
            this.firstPriceFailed = setting.isFirstPriceFailed();
            this.threadPoolSize = setting.getThreadPoolSize();
            this.threadPoolConnection = setting.getThreadPoolConnection();
            this.useXMLFile = setting.isUseXMLFile();
            this.stepSize = setting.getStepSize();
            this.SPID = serviceSetting.getSpID();
            this.serviceID = serviceSetting.getServiceID();
            
            if(sendMsgForSuccess){
                try{
                    File f = new File("xml-config/s.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                    String line, txt = "";
                    while((line = br.readLine()) != null){
                        txt += line + "\n";
                    }
                    this.successMsg = txt;
                }catch(FileNotFoundException e){
                    System.err.println("XML - 01 - 00 : xmlHandler > " + e.getMessage());
                }catch(IOException e){
                    System.err.println("XML - 01 - 01 : xmlHandler > " + e.getMessage());
                }
            }
            
            if(sendMsgForFail){
                try{
                    File f = new File("xml-config/f.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                    String line, txt = "";
                    while((line = br.readLine()) != null){
                        txt += line + "\n";
                    }
                    this.failMsg = txt;
                }catch(FileNotFoundException e){
                    System.err.println("XML - 01 - 00 : xmlHandler > " + e.getMessage());
                }catch(IOException e){
                    System.err.println("XML - 01 - 01 : xmlHandler > " + e.getMessage());
                }
            }
            
            
        }catch(JAXBException e){
            System.err.println("XML - 01 : xmlHandler > " + e.getMessage());
        }
    }

    public boolean isUseXMLFile() {
        return useXMLFile;
    }
    
    public int getThreadPoolConnection() {
        return threadPoolConnection;
    }
    
    public boolean isFirstPriceFailed() {
        return firstPriceFailed;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public String getFailMsg() {
        return failMsg;
    }
    
    public boolean isTestMode() {
        return testMode;
    }

    public boolean isSendMsgForSuccess() {
        return sendMsgForSuccess;
    }

    public boolean isSendMsgForFail() {
        return sendMsgForFail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }

    public String getTagName() {
        return tagName;
    }

    public String getDbName() {
        return dbName;
    }

    public List<Integer> getLstPrice() {
        return lstPrice;
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public int getStepSize() {
        return stepSize;
    }

    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }

    public String getSPID() {
        return SPID;
    }

    public void setSPID(String SPID) {
        this.SPID = SPID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    
    
    public static void main(String[] args) {
        try{
            File file = new File("xml-config/config.xml");
            JAXBContext context = JAXBContext.newInstance(root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            root setting = (root)unmarshaller.unmarshal(file);
            boolean bTestMode = setting.getTestmode();
            message msg = setting.getMsg();
            database db = setting.getDb();
            List<Integer> prices = setting.getLstPrice();
            
            System.out.println("Test Mode : " + bTestMode);
            System.out.println("Message :");
            System.out.println("Message for Success : " + msg.isSuccess());
            System.out.println("Message for fail : " + msg.isFail());
            System.out.println("Database");
            System.out.println("DB Username : " + db.getUsername());
            System.out.println("DB Driver : " + db.getDriver());
            System.out.println("DB Password : " + db.getPassword());
            System.out.println("DB Tag Name : " + db.getTagname());
            System.out.println("DB DBName : " + db.getDbname());
            System.out.println("Thread Number : " + setting.getThreadNumber());
            System.out.println("Prices");
            prices.forEach((p) -> System.out.println( p+""));
            
            xmlHandler h = new xmlHandler();
            
            System.out.println("S MSG :: " + h.getSuccessMsg());
            System.out.println("F MSG :: " + h.getFailMsg());
            
            System.out.println("First Price Failed :: " + h.isFirstPriceFailed());
            
            System.out.println("Step Size : " + h.getStepSize());
            
        }catch(JAXBException e){
            System.err.println("XML - 00 : xmlHandler > " + e.getMessage());
        }
    }
}
