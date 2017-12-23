/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processdigidaroo.xml.handle;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author alirezakhtm
 */
public class message {
    
    private boolean success;
    private boolean fail;

    public message() {
    }

    public message(boolean success, boolean fail) {
        this.success = success;
        this.fail = fail;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    @XmlElement(name = "success")
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFail() {
        return fail;
    }
    
    @XmlElement(name = "fail")
    public void setFail(boolean fail) {
        this.fail = fail;
    }
    
}
