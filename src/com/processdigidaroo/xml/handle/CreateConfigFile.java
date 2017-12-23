/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processdigidaroo.xml.handle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author alirezakhtm
 */
public class CreateConfigFile {
    private final List<Integer> lstPrice;
    private final boolean sendSMSToSuccessPayment;
    private final boolean sendSMSToFailedPayment;
    private final boolean isTestMode;
    private final boolean isFirstPriceFailed, isUseXMLFile;
    private final String messageTextSuccessPayment;
    private final String messageTextFailedPayment;
    private final int threadNumber, threadPoolSize, threadPoolConnection, stepSize;
    private final String username, password, dbName, driver, tagName;
    private final String spid, serviceID;

    /**
     *
     * @param lstPrice
     * @param sendSMSToSuccessPayment
     * @param sendSMSToFailedPayment
     * @param isTestMode
     * @param isFirstPriceFailed
     * @param messageTextSuccessPayment
     * @param messageTextFailedPayment
     * @param threadNumber
     * @param username
     * @param password
     * @param dbName
     * @param driver
     * @param tagName
     */
    public CreateConfigFile(List<Integer> lstPrice,
            boolean sendSMSToSuccessPayment,
            boolean sendSMSToFailedPayment,
            boolean isTestMode,
            boolean isFirstPriceFailed,
            boolean isUseXmlFile,
            String messageTextSuccessPayment,
            String messageTextFailedPayment,
            int threadNumber,
            int threadPoolSize,
            int threadPoolConnection,
            String username,
            String password,
            String dbName,
            String driver,
            String tagName,
            int stepSize,
            String spid,
            String serviceID
    ) {
        this.lstPrice = lstPrice;
        this.sendSMSToSuccessPayment = sendSMSToSuccessPayment;
        this.sendSMSToFailedPayment = sendSMSToFailedPayment;
        this.isTestMode = isTestMode;
        this.isFirstPriceFailed = isFirstPriceFailed;
        this.messageTextSuccessPayment = messageTextSuccessPayment;
        this.messageTextFailedPayment = messageTextFailedPayment;
        this.threadNumber = threadNumber;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
        this.driver = driver;
        this.tagName = tagName;
        this.threadPoolSize = threadPoolSize;
        this.threadPoolConnection = threadPoolConnection;
        this.isUseXMLFile = isUseXmlFile;
        this.stepSize = stepSize;
        this.spid = spid;
        this.serviceID = serviceID;
    }
    
    /**
     * @param  addressFile input example is : /home/foo/Document
     */
    public void saveFile(String addressFile){
        try{
            // create file that want to be save as config.xml
            File file = new File(addressFile + "/config.xml");
            // create marshaller object for saving as xml format
            JAXBContext context = JAXBContext.newInstance(root.class);
            Marshaller marshaller = context.createMarshaller();
            /**********************************************************
             * create an object from root.class and set its parameter *
             **********************************************************/
            root myConfig = new root();
            // Database setting
            myConfig.setDb(new database(username, password, dbName, driver, tagName));
            // Price Setting
            myConfig.setLstPrice(lstPrice);
            // Is test mode
            myConfig.setTestmode(isTestMode);
            // set using XML file
            myConfig.setUseXMLFile(isUseXMLFile);
            // Is first price failed
            myConfig.setFirstPriceFailed(this.isFirstPriceFailed);
            // set thread number
            myConfig.setThreadNumber(threadNumber);
            // set thread pool size
            myConfig.setThreadPoolSize(threadPoolSize);
            // set thread pool connection
            myConfig.setThreadPoolConnection(threadPoolConnection);
            // message setting
            myConfig.setMsg(new message(sendSMSToSuccessPayment, sendSMSToFailedPayment));
            // seting step size for algorithm
            myConfig.setStepSize(stepSize);
            // set service setting
            myConfig.setServiceSetting(new ServiceSetting(spid, serviceID));
            /****************************************************
             * create confing.xml file according to XML patern  *
             ****************************************************/
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(myConfig, file);
            /*******************************************
             * create file s.txt and f.txt for message *
             *******************************************/
            // check that user set request to send SMS
            if(sendSMSToSuccessPayment){
                File stxt = new File(addressFile + "/s.txt");
                BufferedWriter sbw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(stxt)));
                sbw.write(messageTextSuccessPayment);
                sbw.flush();
                sbw.close();
            }
            if(sendSMSToFailedPayment){
                File ftxt = new File(addressFile + "/f.txt");
                BufferedWriter fbw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ftxt)));
                fbw.write(messageTextFailedPayment);
                fbw.flush();
                fbw.close();
            }
        }catch(Exception e){
            System.err.println("File - 00 : CreateConfigFile > " + e.getMessage());
        }
    }
    
    
}
