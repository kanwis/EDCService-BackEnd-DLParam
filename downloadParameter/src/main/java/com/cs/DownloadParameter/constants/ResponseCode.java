package com.cs.DownloadParameter.constants;


import java.text.MessageFormat;

public enum ResponseCode {
	EXCEPTION("9999", "{0}"), 
	SUCCESS("0001", "Success"), 
	INVALID("0002", "{0} is invalid."),
	NOT_FOUND("0003", "Not found terminalId or merchantId."), 
	CORRUPTED("0004", "File was corrupted."),
	DUPPLICATE_USERNAME_EMAIL("0005", "This Username or Email already been used, please try another"),
	VALIDATE_LOGDATE_REQUIRED("0006", "Log Date is required"),
	VALIDATE_LOGDATE_FORMAT("0007", "logDate must be format yyyy-MM-dd"),
	VALIDATE_FILE_REQUIRED("0008", "File is required"),

	// fileSize
	VALIDATE_FILE_SIZE_REQUIRED("0009", "fileSize is required"),
	VALIDATE_FILE_SIZE_MAX("0010", "fileSize maximum length is 9999999.99"),

	// checkSum
	VALIDATE_CHECKSUM_REQUIRED("0011", "checkSum is required"),
	VALIDATE_CHECKSUM_LENGTH("0012", "checkSum maximum length is 2000"),

	// terminalId
	VALIDATE_TERMINALID_REQUIRED("0013", "terminalId is required"),
	VALIDATE_TERMINALID_LENGTH("0014", "terminalId must be length equals 8"),
	VALIDATE_TERMINALID_NUMBER("0015", "terminalId must be a number"),

	// merchantId
	VALIDATE_MERCHANTID_REQUIRED("0016", "merchantId is required"),
	VALIDATE_MERCHANTID_LENGTH("0017", "merchantId must be length equals 15"),
	VALIDATE_MERCHANTID_NUMBER("0018", "merchantId must be a number"),

	// transactionId
	VALIDATE_TRANSACTION_ID_REQUIRED("0019", "transactionId is required"),
	VALIDATE_TRANSACTION_ID_LENGTH("0020", "transactionId maximum length is 29"),

	// terminalParam
	VALIDATE_TERMINAL_PARAM_REQUIRED("0021", "terminalParam is required"),
	VALIDATE_TERMINAL_PARAM_LENGTH("0022", "terminalParam maximum length is 12"),
	VALIDATE_TERMINAL_PARAM_NUMBER("0023", "terminalParam must be a number"),

	// loyaltyParam
	VALIDATE_LOYALTY_PARAM_REQUIRED("0024", "loyaltyParam is required"),
	VALIDATE_LOYALTY_PARAM_LENGTH("0025", "loyaltyParam maximum length is 12"),
	VALIDATE_LOYALTY_PARAM_NUMBER("0026", "loyaltyParam must be a number"),

	// productMappingVersion
	VALIDATE_PRODUCT_MAPPING_VERSION_REQUIRED("0027", "productMappingVersion is required"),
	VALIDATE_PRODUCT_MAPPING_VERSION_LENGTH("0028", "productMappingVersion maximum length is 12"),

	// piG2ProxyVersion
	VALIDATE_PI_G2_PROXY_VERSION_REQUIRED("0029", "piG2ProxyVersion is required"),
	VALIDATE_PI_G2_PROXY_VERSION_LENGTH("0030", "piG2ProxyVersion maximum length is 20"),

	// terminalVersion
	VALIDATE_TERMINAL_VERSION_REQUIRED("0031", "terminalVersion is required"),
	VALIDATE_TERMINAL_VERSION_LENGTH("0032", "terminalVersion maximum length is 20"),

	// terminalIp
	VALIDATE_TERMINAL_IP_REQUIRED("0033", "terminalIp is required"),
	VALIDATE_TERMINAL_IP_LENGTH("0034", "terminalIp maximum length is 15"),

	// terminalGateway
	VALIDATE_TERMINAL_GATEWAY_REQUIRED("0035", "terminalGateway is required"),
	VALIDATE_TERMINAL_GATEWAY_LENGTH("0036", "terminalGateway maximum length is 15"),

	// nii
	VALIDATE_NII_REQUIRED("0037", "nii is required"), VALIDATE_NII_LENGTH("0035", "nii maximum length is 3"),
	VALIDATE_NII_NUMBER("0038", "nii must be a number"),

	// phoneNum1
	VALIDATE_PHONE_NUM1_REQUIRED("0039", "phoneNum1 is required"),
	VALIDATE_PHONE_NUM1_LENGTH("0040", "phoneNum1 maximum length is 15"),
	VALIDATE_PHONE_NUM1_NUMBER("0041", "phoneNum1 must be a number"),

	// phoneNum2
	VALIDATE_PHONE_NUM2_REQUIRED("0042", "phoneNum2 is required"),
	VALIDATE_PHONE_NUM2_LENGTH("0043", "phoneNum2 maximum length is 15"),
	VALIDATE_PHONE_NUM2_NUMBER("0044", "phoneNum2 must be a number"),

	// batchNo
	VALIDATE_BATCH_NO_REQUIRED("0045", "batchNo is required"),
	VALIDATE_BATCH_NO_LENGTH("0046", "batchNo maximum length is 6"),
	VALIDATE_BATCH_NO_NUMBER("0047", "batchNo must be a number"),

	// hostIp1
	VALIDATE_HOST_IP1_REQUIRED("0048", "hostIp1 is required"),
	VALIDATE_HOST_IP1_LENGTH("0049", "hostIp1 maximum length is 15"),

	// hostPort1
	VALIDATE_HOST_PORT1_REQUIRED("0050", "hostPort1 is required"),
	VALIDATE_HOST_PORT1_LENGTH("0051", "hostPort1 maximum length is 5"),
	VALIDATE_HOST_PORT1_NUMBER("0052", "hostPort1 must be a number"),

	// hostIp2
	VALIDATE_HOST_IP2_REQUIRED("0053", "hostIp2 is required"),
	VALIDATE_HOST_IP2_LENGTH("0054", "hostIp2 maximum length is 15"),

	// hostPort2
	VALIDATE_HOST_PORT2_REQUIRED("0055", "hostPort2 is required"),
	VALIDATE_HOST_PORT2_LENGTH("0056", "hostPort2 maximum length is 5"),
	VALIDATE_HOST_PORT2_NUMBER("0057", "hostPort2 must be a number"),

	// terminalSerial
	VALIDATE_TERMINAL_SERIAL_REQUIRED("0058", "terminalSerial is required"),
	VALIDATE_TERMINAL_SERIAL_LENGTH("0059", "terminalSerial maximum length is 15"),

	// terminalModel
	VALIDATE_TERMINAL_MODEL_REQUIRED("0060", "terminalModel is required"),
	VALIDATE_TERMINAL_MODEL_LENGTH("0061", "terminalModel maximum length is 10"),

	// dnsServer
	VALIDATE_DNS_SERVER_REQUIRED("0062", "dnsServer is required"),
	VALIDATE_DNS_SERVER_LENGTH("0063", "dnsServer maximum length is 15"),

	// terminalSubnetMark
	VALIDATE_TERMINAL_SUBNET_MARK_REQUIRED("0064", "terminalSubnetMark is required"),
	VALIDATE_TERMINAL_SUBNET_MARK_LENGTH("0065", "terminalSubnetMark maximum length is 15"),

	// creditAppVersion
	VALIDATE_CREDIT_APP_VERSION_REQUIRED("0066", "creditAppVersion is required"),
	VALIDATE_CREDIT_APP_VERSION_LENGTH("0067", "creditAppVersion maximum length is 20"),

	// registerDate
//	VALIDATE_REGISTER_DATE_REQUIRED("0068", "registerDate is required"),
//	VALIDATE_REGISTER_DATE_LENGTH("0069", "registerDate maximum length is 19"),
//	VALIDATE_REGISTER_DATE_FORMAT("0070", "registerDate must be format YYYY-MM-DD"),// hh:mm:ss

	// appType
	VALIDATE_APP_TYPE_REQUIRED("0068", "appType is required"),
	VALIDATE_APP_TYPE_LENGTH("0069", "appType maximum length is 2"),
	VALIDATE_APP_TYPE_NUMBER("0070", "appType must be a number"),
	
	VALIDATE_DATA_REQUIRED("0071", "data is required"),
	VALIDATE_FUNCTION_NAME_REQUIRED("0072", "function_name is required"),
	VALIDATE_COUNT_USAGE_REQUIRED("0073", "count_usage is required"),
	VALIDATE_COUNT_USAGE_NUMBER("0074", "count_usage must be a number"),
	
	VALIDATE_USAGE_DATE_REQUIRED("0075", "usage_date is required"),
	
	DUPPLICATE_GROUP_NAME("0076", "This Group Name already been used, please try another"),
	VALIDATE_DELETE_GROUP("0077", "The user group cannot be deleted because it is already in use."),
	
	DUPPLICATE_MERCHANT_NAME("0078", "This Merchant ID already been used, please try another"),
	VALIDATE_ENTERPRISEID_REQUIRED("0079", "enterpriseId is required"),
	VALIDATE_ENTERPRISEID_LENGTH("0080", "enterpriseId must be length equals 8"),
	VALIDATE_ENTERPRISEID_NUMBER("0081", "enterpriseId must be a number"),
	VALIDATE_PARAM_VERSION_REQUIRED("0082", "paramVersion is required"),
	VALIDATE_PARAM_VERSION_LENGTH("0083", "paramVersion must be length equals 14"),
	VALIDATE_IS_SUCCESS_REQUIRED("0084", "isSuccess is required"),
	VALIDATE_IS_SUCCESS_LENGTH("0085", "isSuccess must be length equals 1"),
	VALIDATE_IS_SUCCESS_NUMBER("0086", "isSuccess must be a number"),
	
	VALIDATE_FUNCTION_NAME_MATCH("0005", "Not match EDC function name"),

	PERMISSION("1003", "You don’t have permission to access this resource."),
	CONNECT("2000", "{0} or Unable to connect to the database."),
	UNAVAILABLE("2001", "The database service is currently unavailable."), 
	DB_EXCEPTION("2002", "{0}"),
	REQUEST_NOT_FOUND("4004", "The request is not found."),
	SERVER_TIMEOUT("5004", "The server took too long to process the request."),
	
	TERMINAL_E004("E004","ข้อมูล {0} แถว ที่ {1} ไม่ถูกต้อง"),
	TERMINAL_E005("E005","ข้อมูล Serial No. หรือ Asset No. แถวที่ {0} ไม่ถูกต้อง"),
	TERMINAL_E006("E006","ข้อมูล Serial No. กับ Asset No. แถวที่ {0} มีสถานะไม่ว่าง"),
	TERMINAL_E024("E024","ข้อมูล Serial No. กับ Asset No. แถวที่ {0} มีสถานะการใช้งาน Inactive "),
	TERMINAL_E025("E025","ข้อมูล Serial No. กับ Asset No. แถวที่ {0} ดาวน์โหลดไม่สำเร็จ"),
	TERMINAL_E021("E021","หมายเลข Serial No. ซ้ำกับที่มีในระบบ"),
	TERMINAL_E022("E022","หมายเลข Asset No. ซ้ำกับที่มีในระบบ");

	private ResponseCode(String code, String message) {
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
