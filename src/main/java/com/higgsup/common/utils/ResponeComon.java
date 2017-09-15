package com.higgsup.common.utils;

import com.higgsup.app.ConstantsApp;

import java.io.Serializable;

/**
 * Created on 15-Sep-17.
 * OwnerBy anhvu
 */
public class ResponeComon<T> implements Serializable {

    private String resultCode;
    private String message;
    private T value;

    public ResponeComon() {
    }

    public ResponeComon<T> successfulRespone(T value) {
        this.resultCode = ConstantsApp.RESULT_CODE_SUCCESS;
        this.message = ConstantsApp.MESSAGE_SUCCESS;
        this.value = value;

        return this;
    }

    public ResponeComon<T> failedRespone(T value) {
        this.resultCode = ConstantsApp.RESULT_CODE_FAIL;
        this.message = ConstantsApp.MESSAGE_FAIL;
        this.value = value;

        return this;
    }

    public ResponeComon<T> failedRespone(T value, String messageError) {
        this.resultCode = ConstantsApp.RESULT_CODE_FAIL;
        this.message = messageError;
        this.value = value;

        return this;
    }

    public ResponeComon<T> failedRespone(String messageError) {
        this.resultCode = ConstantsApp.RESULT_CODE_FAIL;
        this.message = messageError;

        return this;
    }

    public ResponeComon<T> failedRespone(T value, String resultCode, String messageError) {
        this.resultCode = resultCode;
        this.message = messageError;
        this.value = value;

        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
