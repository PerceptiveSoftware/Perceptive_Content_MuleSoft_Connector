package com.perceptivesoftware.mule.workflowtrigger;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.module.cxf.CxfConstants;

public class WorkflowTriggerInterceptor extends AbstractPhaseInterceptor<Message> {

	public WorkflowTriggerInterceptor() {
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		MuleEvent event = (MuleEvent) message.getExchange().get(CxfConstants.MULE_EVENT);
		MuleMessage muleMsg = event.getMessage();
		
		MessageContentsList inObjects = MessageContentsList.getContentsList(message);
		
		muleMsg.setOutboundProperty("asq.item.id", inObjects.get(0));
		muleMsg.setOutboundProperty("asq.queue.id", inObjects.get(1));
		muleMsg.setOutboundProperty("asq.queue.name", inObjects.get(2));
		muleMsg.setOutboundProperty("asq.queue.success.id", inObjects.get(3));
		muleMsg.setOutboundProperty("asq.queue.success.name", inObjects.get(4));
		muleMsg.setOutboundProperty("asq.queue.failure.id", inObjects.get(5));
		muleMsg.setOutboundProperty("asq.queue.failure.name", inObjects.get(6));
		
		return;
	}

}