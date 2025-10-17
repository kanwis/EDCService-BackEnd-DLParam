package com.cs.DownloadParameter.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.cs.DownloadParameter.constants.Constants;
import com.cs.DownloadParameter.constants.ResponseCode;
import com.cs.DownloadParameter.exceptions.ValidateException;


public class ValidateUtils {

	public static Logger logger = LoggerFactory.getLogger(ValidateUtils.class);

	public static boolean isValidLogDate(String logDate) throws Exception {
//		logger.info("validate:logDate="+logDate);
		if (logDate.isEmpty()) {
			// Log Date is required
			throw new ValidateException(ResponseCode.VALIDATE_LOGDATE_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_LOGDATE_REQUIRED.getCode());
		} else if (!DateUtils.isValidDateFormat(logDate, Constants.DATE_FORMAT_yyyyMMdd)) {
			// yyyy-MM-dd
			// logDate must be format yyyy-MM-dd
			throw new ValidateException(ResponseCode.VALIDATE_LOGDATE_FORMAT.getMessage(),
					ResponseCode.VALIDATE_LOGDATE_FORMAT.getCode());
		}
		return true;
	}

	public static boolean isValidFileSize(String fileSize) throws Exception {
//		logger.info("validate:fileSize="+fileSize);
		if (fileSize.isEmpty()) {
			// File Size is required
			throw new ValidateException(ResponseCode.VALIDATE_FILE_SIZE_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_FILE_SIZE_REQUIRED.getCode());
		} else if (fileSize.length() > 8) {
			// fileSize maximum length is 9999999.99
			throw new ValidateException(ResponseCode.VALIDATE_FILE_SIZE_MAX.getMessage(),
					ResponseCode.VALIDATE_FILE_SIZE_MAX.getCode());
		}
		return true;
	}

	public static boolean isValidChecksum(String checkSum) throws Exception {
//		logger.info("validate:checkSum="+checkSum);
		if (checkSum.isEmpty()) {
			// checkSum is required!
			throw new ValidateException(ResponseCode.VALIDATE_CHECKSUM_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_CHECKSUM_REQUIRED.getCode());
		} else if (checkSum.length() > 2000) {
			// checkSum maximum length is 2000
			throw new ValidateException(ResponseCode.VALIDATE_CHECKSUM_LENGTH.getMessage(),
					ResponseCode.VALIDATE_CHECKSUM_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidFile(MultipartFile file) throws Exception {
//		logger.info("validate:file="+file);
		if (file.isEmpty()) {
			// File is required
			throw new ValidateException(ResponseCode.VALIDATE_FILE_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_FILE_REQUIRED.getCode());
		}
		return true;
	}

	public static boolean isValidTerminalId(String terminalId) throws Exception {
//		logger.info("validate:terminalId="+terminalId);
		if (terminalId.isEmpty()) {
			// terminalId is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINALID_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINALID_REQUIRED.getCode(), "terminalId");
		} else if (terminalId.length() != 8) {
			// terminalId must be length equals 8
			throw new ValidateException(ResponseCode.VALIDATE_TERMINALID_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINALID_LENGTH.getCode(), "terminalId");
		} else if (!terminalId.matches("\\d+")) {
			// terminalId must be a number
			throw new ValidateException(ResponseCode.VALIDATE_TERMINALID_NUMBER.getMessage(),
					ResponseCode.VALIDATE_TERMINALID_NUMBER.getCode(), "terminalId");
		}
		return true;
	}

	public static boolean isValidMerchantId(String merchantId) throws Exception {
//		logger.info("validate:merchantId="+merchantId);
		if (merchantId.isEmpty()) {
			// merchantId is required!
			throw new ValidateException(ResponseCode.VALIDATE_MERCHANTID_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_MERCHANTID_REQUIRED.getCode(), "merchantId");
		} else if (merchantId.length() != 15) {
			// merchantId must be length equals 15
			throw new ValidateException(ResponseCode.VALIDATE_MERCHANTID_LENGTH.getMessage(),
					ResponseCode.VALIDATE_MERCHANTID_LENGTH.getCode(), "merchantId");
		} else if (!merchantId.matches("\\d+")) {
			// merchantId must be a number
			throw new ValidateException(ResponseCode.VALIDATE_MERCHANTID_NUMBER.getMessage(),
					ResponseCode.VALIDATE_MERCHANTID_NUMBER.getCode(), "merchantId");
		}
		return true;
	}
	
	public static boolean isValidTransactionId(String transactionId) throws Exception {
//		logger.info("validate:transactionId="+transactionId);
		if (transactionId.isEmpty()) {
			// transactionId is required!
			throw new ValidateException(ResponseCode.VALIDATE_TRANSACTION_ID_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TRANSACTION_ID_REQUIRED.getCode(), "transactionId");
		} else if (transactionId.length() > 29) {
			// transactionId must be length equals 29
			throw new ValidateException(ResponseCode.VALIDATE_TRANSACTION_ID_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TRANSACTION_ID_LENGTH.getCode(), "transactionId");
		} 
		return true;
	}

	public static boolean isValidTerminalParam(String terminalParam) throws Exception {
//		logger.info("validate:terminalParam="+terminalParam);
		if (terminalParam.isEmpty()) {
			// terminalParam is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_PARAM_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_PARAM_REQUIRED.getCode());
		} else if (terminalParam.length() > 12) {
			// terminalParam maximum length is 12
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_PARAM_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_PARAM_LENGTH.getCode());
		} else if (!terminalParam.matches("\\d+")) {
			// terminalParam must be a number
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_PARAM_NUMBER.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_PARAM_NUMBER.getCode());
		}
		return true;
	}

	public static boolean isValidLoyaltyParam(String loyaltyParam) throws Exception {
//		logger.info("validate:loyaltyParam="+loyaltyParam);
		if (loyaltyParam.isEmpty()) {
			// loyaltyParam is required!
			throw new ValidateException(ResponseCode.VALIDATE_LOYALTY_PARAM_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_LOYALTY_PARAM_REQUIRED.getCode());
		} else if (loyaltyParam.length() > 12) {
			// loyaltyParam maximum length is 12
			throw new ValidateException(ResponseCode.VALIDATE_LOYALTY_PARAM_LENGTH.getMessage(),
					ResponseCode.VALIDATE_LOYALTY_PARAM_LENGTH.getCode());
		} else if (!loyaltyParam.matches("\\d+")) {
			// loyaltyParam must be a number
			throw new ValidateException(ResponseCode.VALIDATE_LOYALTY_PARAM_NUMBER.getMessage(),
					ResponseCode.VALIDATE_LOYALTY_PARAM_NUMBER.getCode());
		}
		return true;
	}

	public static boolean isValidProductMappingVersion(String productMappingVersion) throws Exception {
//		logger.info("validate:productMappingVersion="+productMappingVersion);
		if (productMappingVersion.isEmpty()) {
			// productMappingVersion is required!
			throw new ValidateException(ResponseCode.VALIDATE_PRODUCT_MAPPING_VERSION_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_PRODUCT_MAPPING_VERSION_REQUIRED.getCode());
		} else if (productMappingVersion.length() > 12) {
			// productMappingVersion maximum length is 12
			throw new ValidateException(ResponseCode.VALIDATE_PRODUCT_MAPPING_VERSION_LENGTH.getMessage(),
					ResponseCode.VALIDATE_PRODUCT_MAPPING_VERSION_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidPiG2ProxyVersion(String piG2ProxyVersion) throws Exception {
//		logger.info("validate:piG2ProxyVersion="+piG2ProxyVersion);
		if (piG2ProxyVersion.isEmpty()) {
			// piG2ProxyVersion is required!
			throw new ValidateException(ResponseCode.VALIDATE_PI_G2_PROXY_VERSION_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_PI_G2_PROXY_VERSION_REQUIRED.getCode());
		} else if (piG2ProxyVersion.length() > 20) {
			// piG2ProxyVersion maximum length is 20
			throw new ValidateException(ResponseCode.VALIDATE_PI_G2_PROXY_VERSION_LENGTH.getMessage(),
					ResponseCode.VALIDATE_PI_G2_PROXY_VERSION_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidTerminalVersion(String terminalVersion) throws Exception {
//		logger.info("validate:terminalVersion="+terminalVersion);
		if (terminalVersion.isEmpty()) {
			// terminalVersion is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_VERSION_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_VERSION_REQUIRED.getCode());
		} else if (terminalVersion.length() > 20) {
			// terminalVersion maximum length is 20
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_VERSION_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_VERSION_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidTerminalIp(String terminalIp) throws Exception {
//		logger.info("validate:terminalIp="+terminalIp);
		if (terminalIp.isEmpty()) {
			// terminalIp is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_IP_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_IP_REQUIRED.getCode());
		} else if (terminalIp.length() > 15) {
			// terminalIp maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_IP_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_IP_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidTerminalGateway(String terminalGateway) throws Exception {
//		logger.info("validate:terminalGateway="+terminalGateway);
		if (terminalGateway.isEmpty()) {
			// Terminal Gateway is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_GATEWAY_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_GATEWAY_REQUIRED.getCode());
		} else if (terminalGateway.length() > 15) {
			// Terminal Gateway must be length=15
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_GATEWAY_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_GATEWAY_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidNii(String nii) throws Exception {
//		logger.info("validate:nii="+nii);
		if (nii.isEmpty()) {
			// nii is required!
			throw new ValidateException(ResponseCode.VALIDATE_NII_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_NII_REQUIRED.getCode());
		} else if (nii.length() > 3) {
			// nii maximum length is 3
			throw new ValidateException(ResponseCode.VALIDATE_NII_LENGTH.getMessage(),
					ResponseCode.VALIDATE_NII_LENGTH.getCode());
		} else if (!nii.matches("\\d+")) {
			// nii must be a number
			throw new ValidateException(ResponseCode.VALIDATE_NII_NUMBER.getMessage(),
					ResponseCode.VALIDATE_NII_NUMBER.getCode());
		}
		return true;
	}

	public static boolean isValidPhoneNum1(String phoneNum1) throws Exception {
//		logger.info("validate:phoneNum1="+phoneNum1);
		if (phoneNum1.isEmpty()) {
			// phoneNum1 is required!
			throw new ValidateException(ResponseCode.VALIDATE_PHONE_NUM1_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_PHONE_NUM1_REQUIRED.getCode());
		} else if (phoneNum1.length() > 15) {
			// phoneNum1 maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_PHONE_NUM1_LENGTH.getMessage(),
					ResponseCode.VALIDATE_PHONE_NUM1_LENGTH.getCode());
		} else if (!phoneNum1.matches("\\d+")) {
			// phoneNum1 must be a number
			throw new ValidateException(ResponseCode.VALIDATE_PHONE_NUM1_NUMBER.getMessage(),
					ResponseCode.VALIDATE_PHONE_NUM1_NUMBER.getCode());
		}
		return true;
	}

	public static boolean isValidPhoneNum2(String phoneNum2) throws Exception {
//		logger.info("validate:phoneNum2="+phoneNum2);
		if (phoneNum2.isEmpty()) {
			// phoneNum2 is required!
			throw new ValidateException(ResponseCode.VALIDATE_PHONE_NUM2_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_PHONE_NUM2_REQUIRED.getCode());
		} else if (phoneNum2.length() > 15) {
			// phoneNum2 maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_PHONE_NUM2_LENGTH.getMessage(),
					ResponseCode.VALIDATE_PHONE_NUM2_LENGTH.getCode());
		} else if (!phoneNum2.matches("\\d+")) {
			// phoneNum2 must be a number
			throw new ValidateException(ResponseCode.VALIDATE_PHONE_NUM2_NUMBER.getMessage(),
					ResponseCode.VALIDATE_PHONE_NUM2_NUMBER.getCode());
		}
		return true;
	}

	public static boolean isValidBatchNo(String batchNo) throws Exception {
//		logger.info("validate:batchNo="+batchNo);
		if (batchNo.isEmpty()) {
			// batchNo is required!
			throw new ValidateException(ResponseCode.VALIDATE_BATCH_NO_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_BATCH_NO_REQUIRED.getCode());
		} else if (batchNo.length() > 6) {
			// batchNo maximum length is 6
			throw new ValidateException(ResponseCode.VALIDATE_BATCH_NO_LENGTH.getMessage(),
					ResponseCode.VALIDATE_BATCH_NO_LENGTH.getCode());
		} else if (!batchNo.matches("\\d+")) {
			// batchNo must be a number
			throw new ValidateException(ResponseCode.VALIDATE_BATCH_NO_NUMBER.getMessage(),
					ResponseCode.VALIDATE_BATCH_NO_NUMBER.getCode());
		}
		return true;
	}

	public static boolean isValidHostIp1(String hostIp1) throws Exception {
//		logger.info("validate:hostIp1="+hostIp1);
		if (hostIp1.isEmpty()) {
			// hostIp1 is required!
			throw new ValidateException(ResponseCode.VALIDATE_HOST_IP1_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_HOST_IP1_REQUIRED.getCode());
		} else if (hostIp1.length() > 15) {
			// hostIp1 maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_HOST_IP1_LENGTH.getMessage(),
					ResponseCode.VALIDATE_HOST_IP1_LENGTH.getCode());
		}
		return true;
	}

	public static boolean isValidHostPort1(String hostPort1) throws Exception {
//		logger.info("validate:hostPort1="+hostPort1);
		if (hostPort1.isEmpty()) {
			// hostPort1 is required!
			throw new ValidateException(ResponseCode.VALIDATE_HOST_PORT1_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_HOST_PORT1_REQUIRED.getCode());
		} else if (hostPort1.length() > 5) {
			// hostPort1 maximum length is 5
			throw new ValidateException(ResponseCode.VALIDATE_HOST_PORT1_LENGTH.getMessage(),
					ResponseCode.VALIDATE_HOST_PORT1_LENGTH.getCode());
		} else if (!hostPort1.matches("\\d+")) {
			// hostPort1 must be a number
			throw new ValidateException(ResponseCode.VALIDATE_HOST_PORT1_NUMBER.getMessage(),
					ResponseCode.VALIDATE_HOST_PORT1_NUMBER.getCode());
		}
		return true;
	}
	
	public static boolean isValidHostIp2(String hostIp2) throws Exception {
//		logger.info("validate:hostIp2="+hostIp2);
		if (hostIp2.isEmpty()) {
			// hostIp2 is required!
			throw new ValidateException(ResponseCode.VALIDATE_HOST_IP2_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_HOST_IP2_REQUIRED.getCode());
		} else if (hostIp2.length() > 15) {
			// hostIp2 maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_HOST_IP2_LENGTH.getMessage(),
					ResponseCode.VALIDATE_HOST_IP2_LENGTH.getCode());
		}
		return true;
	}
	
	public static boolean isValidHostPort2(String hostPort2) throws Exception {
//		logger.info("validate:hostPort2="+hostPort2);
		if (hostPort2.isEmpty()) {
			// hostPort2 is required!
			throw new ValidateException(ResponseCode.VALIDATE_HOST_PORT2_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_HOST_PORT2_REQUIRED.getCode());
		} else if (hostPort2.length() > 5) {
			// hostPort2 maximum length is 5
			throw new ValidateException(ResponseCode.VALIDATE_HOST_PORT2_LENGTH.getMessage(),
					ResponseCode.VALIDATE_HOST_PORT2_LENGTH.getCode());
		} else if (!hostPort2.matches("\\d+")) {
			// hostPort2 must be a number
			throw new ValidateException(ResponseCode.VALIDATE_HOST_PORT2_NUMBER.getMessage(),
					ResponseCode.VALIDATE_HOST_PORT2_NUMBER.getCode());
		}
		return true;
	}
	
	public static boolean isValidterminalSerial(String terminalSerial) throws Exception {
//		logger.info("validate:terminalSerial="+terminalSerial);
		if (terminalSerial.isEmpty()) {
			// terminalSerial is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_SERIAL_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_SERIAL_REQUIRED.getCode());
		} else if (terminalSerial.length() > 15) {
			// terminalSerial maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_SERIAL_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_SERIAL_LENGTH.getCode());
		}
		return true;
	}
	
	public static boolean isValidterminalModel(String terminalModel) throws Exception {
//		logger.info("validate:terminalModel="+terminalModel);
		if (terminalModel.isEmpty()) {
			// terminalModel is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_MODEL_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_MODEL_REQUIRED.getCode());
		} else if (terminalModel.length() > 15) {
			// terminalModel maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_MODEL_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_MODEL_LENGTH.getCode());
		}
		return true;
	}
	
	public static boolean isValidDnsServer(String dnsServer) throws Exception {
//		logger.info("validate:dnsServer="+dnsServer);
		if (dnsServer.isEmpty()) {
			// dnsServer is required!
			throw new ValidateException(ResponseCode.VALIDATE_DNS_SERVER_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_DNS_SERVER_REQUIRED.getCode());
		} else if (dnsServer.length() > 15) {
			// dnsServer maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_DNS_SERVER_LENGTH.getMessage(),
					ResponseCode.VALIDATE_DNS_SERVER_LENGTH.getCode());
		}
		return true;
	}
	
	public static boolean isValidTerminalSubnetMark(String terminalSubnetMark) throws Exception {
//		logger.info("validate:terminalSubnetMark="+terminalSubnetMark);
		if (terminalSubnetMark.isEmpty()) {
			// terminalSubnetMark is required!
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_SUBNET_MARK_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_SUBNET_MARK_REQUIRED.getCode());
		} else if (terminalSubnetMark.length() > 15) {
			// terminalSubnetMark maximum length is 15
			throw new ValidateException(ResponseCode.VALIDATE_TERMINAL_SUBNET_MARK_LENGTH.getMessage(),
					ResponseCode.VALIDATE_TERMINAL_SUBNET_MARK_LENGTH.getCode());
		}
		return true;
	}
	
	public static boolean isValidcreditAppVersion(String creditAppVersion) throws Exception {
//		logger.info("validate:creditAppVersion="+creditAppVersion);
		if (creditAppVersion.isEmpty()) {
			// creditAppVersion is required!
			throw new ValidateException(ResponseCode.VALIDATE_CREDIT_APP_VERSION_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_CREDIT_APP_VERSION_REQUIRED.getCode());
		} else if (creditAppVersion.length() > 20) {
			// creditAppVersion maximum length is 20
			throw new ValidateException(ResponseCode.VALIDATE_CREDIT_APP_VERSION_LENGTH.getMessage(),
					ResponseCode.VALIDATE_CREDIT_APP_VERSION_LENGTH.getCode());
		}
		return true;
	}
	
//	public static boolean isValidRegisterDate(String registerDate) throws Exception {
////		logger.info("validate:registerDate="+registerDate);
//		if (registerDate.isEmpty()) {
//			// registerDate is required!
//			throw new ValidateException(ResponseCode.VALIDATE_REGISTER_DATE_REQUIRED.getMessage(),
//					ResponseCode.VALIDATE_REGISTER_DATE_REQUIRED.getCode());
//		} else if (registerDate.length() > 19) {
//			// registerDate maximum length is 19
//			throw new ValidateException(ResponseCode.VALIDATE_REGISTER_DATE_LENGTH.getMessage(),
//					ResponseCode.VALIDATE_REGISTER_DATE_LENGTH.getCode());
//		} else if (!DateUtils.isValidDateFormat(registerDate, Constants.DATE_FORMAT_yyyyMMdd)) {// hh:mm:ss
//			// registerDate must be format YYYY-MM-DD hh:mm:ss
//			throw new ValidateException(ResponseCode.VALIDATE_REGISTER_DATE_FORMAT.getMessage(),
//					ResponseCode.VALIDATE_REGISTER_DATE_FORMAT.getCode());
//		}
//		return true;
//	}
	
	public static boolean isValidAppType(String appType) throws Exception {
//		logger.info("validate:terminalId="+terminalId);
		if (appType.isEmpty()) {
			// appType is required!
			throw new ValidateException(ResponseCode.VALIDATE_APP_TYPE_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_APP_TYPE_REQUIRED.getCode());
		} else if (appType.length() > 2) {
			// appType maximum length is 2
			throw new ValidateException(ResponseCode.VALIDATE_APP_TYPE_LENGTH.getMessage(),
					ResponseCode.VALIDATE_APP_TYPE_LENGTH.getCode());
		} else if (!appType.matches("\\d+")) {
			// appType must be a number
			throw new ValidateException(ResponseCode.VALIDATE_APP_TYPE_NUMBER.getMessage(),
					ResponseCode.VALIDATE_APP_TYPE_NUMBER.getCode());
		}
		return true;
	}
	
	public static boolean isValidEnterpriseId(String enterpriseId) throws Exception {
		if (enterpriseId.isEmpty()) {
			throw new ValidateException(ResponseCode.VALIDATE_ENTERPRISEID_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_ENTERPRISEID_REQUIRED.getCode(), "enterpriseId");
		} else if (enterpriseId.length() != 8) {
			throw new ValidateException(ResponseCode.VALIDATE_ENTERPRISEID_LENGTH.getMessage(),
					ResponseCode.VALIDATE_ENTERPRISEID_LENGTH.getCode(), "enterpriseId");
		} else if (!enterpriseId.matches("\\d+")) {
			throw new ValidateException(ResponseCode.VALIDATE_ENTERPRISEID_NUMBER.getMessage(),
					ResponseCode.VALIDATE_ENTERPRISEID_NUMBER.getCode(), "enterpriseId");
		}
		return true;
	}
	
	public static boolean isValidParamVersion(String paramVersion) throws Exception {
		if (paramVersion.isEmpty()) {
			throw new ValidateException(ResponseCode.VALIDATE_PARAM_VERSION_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_PARAM_VERSION_REQUIRED.getCode(), "paramVersion");
		} else if (paramVersion.length() != 14) {
			throw new ValidateException(ResponseCode.VALIDATE_PARAM_VERSION_LENGTH.getMessage(),
					ResponseCode.VALIDATE_PARAM_VERSION_LENGTH.getCode(), "paramVersion");
//		} else if (!paramVersion.matches("\\d+")) {
//			throw new ValidateException(ResponseCode.VALIDATE_ENTERPRISEID_NUMBER.getMessage(),
//					ResponseCode.VALIDATE_ENTERPRISEID_NUMBER.getCode());
		}
		return true;
	}
	
	public static boolean isValidIsSuccess(String isSuccess) throws Exception {
		if (isSuccess.isEmpty()) {
			throw new ValidateException(ResponseCode.VALIDATE_IS_SUCCESS_REQUIRED.getMessage(),
					ResponseCode.VALIDATE_IS_SUCCESS_REQUIRED.getCode(), "isSuccess");
		} else if (isSuccess.length() != 1) {
			throw new ValidateException(ResponseCode.VALIDATE_IS_SUCCESS_LENGTH.getMessage(),
					ResponseCode.VALIDATE_IS_SUCCESS_LENGTH.getCode(), "isSuccess");
		} else if (!isSuccess.matches("\\d+")) {
			throw new ValidateException(ResponseCode.VALIDATE_IS_SUCCESS_NUMBER.getMessage(),
					ResponseCode.VALIDATE_IS_SUCCESS_NUMBER.getCode(), "isSuccess");
		}
		return true;
	}
	
}
