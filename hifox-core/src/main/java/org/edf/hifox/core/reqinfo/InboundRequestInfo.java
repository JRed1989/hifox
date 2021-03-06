package org.edf.hifox.core.reqinfo;

import java.util.Date;

import org.edf.hifox.core.datatransfer.Body;
import org.edf.hifox.core.datatransfer.Head;
import org.edf.hifox.core.datatransfer.Message;

/**
 * 
 * @author WangYang
 *
 */
public class InboundRequestInfo {
	private String adapterId;
	private String remoteIp;
	private int remotePort;
	private byte[] content;
	private String contentString;
	private String objectMark;
	private String requestEncoding;
	private String responseEncoding;
	private String serviceId;
	
	private Date receiveTime;
	
	private Message<Head, Body> requestMessage;

	public String getAdapterId() {
		return adapterId;
	}

	public void setAdapterId(String adapterId) {
		this.adapterId = adapterId;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public String getObjectMark() {
		return objectMark;
	}

	public void setObjectMark(String objectMark) {
		this.objectMark = objectMark;
	}

	public String getRequestEncoding() {
		return requestEncoding;
	}

	public void setRequestEncoding(String requestEncoding) {
		this.requestEncoding = requestEncoding;
	}

	public String getResponseEncoding() {
		return responseEncoding;
	}

	public void setResponseEncoding(String responseEncoding) {
		this.responseEncoding = responseEncoding;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Message<Head, Body> getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(Message<Head, Body> requestMessage) {
		this.requestMessage = requestMessage;
	}
	
}
