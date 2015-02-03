package com.perceptivesoftware.mule.workflowtrigger;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.perceptivesoftware.com/pif/imagenow/workflow", name = "WorkflowTrigger")
public interface WorkflowTrigger {

    @WebResult(name = "return", targetNamespace = "")
    public boolean invokeTrigger(
        @WebParam(name = "ITEM_ID", targetNamespace = "")
        java.lang.String itemID,
        @WebParam(name = "QUEUE_ID", targetNamespace = "")
        java.lang.String queueID,
        @WebParam(name = "QUEUE_NAME", targetNamespace = "")
        java.lang.String queueNAME,
        @WebParam(name = "SUCCESS_QUEUE_ID", targetNamespace = "")
        java.lang.String successQUEUEID,
        @WebParam(name = "SUCCESS_QUEUE_NAME", targetNamespace = "")
        java.lang.String successQUEUENAME,
        @WebParam(name = "FAILURE_QUEUE_ID", targetNamespace = "")
        java.lang.String failureQUEUEID,
        @WebParam(name = "FAILURE_QUEUE_NAME", targetNamespace = "")
        java.lang.String failureQUEUENAME
    );
}
