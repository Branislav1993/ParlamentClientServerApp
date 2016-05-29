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
public class ClientObjectTransfer implements Serializable {

    private int operation;
    private Object parameter;

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }
}
