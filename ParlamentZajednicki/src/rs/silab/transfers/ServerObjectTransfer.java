/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.silab.transfers;

import java.io.Serializable;

/**
 *
 * @author Branislav Vidojevic
 */
public class ServerObjectTransfer implements Serializable {

    private Object data;
    private int operationSuccess;
    private Exception exception;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getOperationSuccess() {
        return operationSuccess;
    }

    public void setOperationSuccess(int operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
