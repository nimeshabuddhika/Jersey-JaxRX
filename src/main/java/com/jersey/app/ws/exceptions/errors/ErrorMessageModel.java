package com.jersey.app.ws.exceptions.errors;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
@XmlRootElement
public class ErrorMessageModel {
    private String errorMsg;
    private String className;
    private int lineNo;

    public ErrorMessageModel() {
    }

    public ErrorMessageModel(String errorMsg, String className, int lineNo) {
        this.errorMsg = errorMsg;
        this.className = className;
        this.lineNo = lineNo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }
}
