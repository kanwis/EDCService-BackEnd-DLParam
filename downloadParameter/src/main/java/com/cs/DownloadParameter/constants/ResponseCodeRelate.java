package com.cs.DownloadParameter.constants;


import java.text.MessageFormat;

public enum ResponseCodeRelate {
	
	NOT_FOUND_RELATE("0003", "Not found enterpriseId or merchantId or terminalId."), 
	NOT_FOUND_PARAMETER_RELATE("0004", "Not found parameter."),
	NOT_FOUND_PARAMETER_STATUS_RELATE("0005", "Not found enterpriseId or merchantId or terminalId or paramVersion."),
	CAN_NOT_UPDATE_RELATE("2001", "Can’t Insert or Update data into database.");
	
	private ResponseCodeRelate(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private final String code;
	private final String message;

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String formatMessage(Object... args) {
		return MessageFormat.format(message, args);
	}
	

}
