package com.cs.DownloadParameter.restcontrollers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.DownloadParameter.constants.ResponseCode;
import com.cs.DownloadParameter.constants.ResponseCodeRelate;
import com.cs.DownloadParameter.dto.DownloadParamRequest;
import com.cs.DownloadParameter.dto.TscfDataInfo;
import com.cs.DownloadParameter.exceptions.ValidateException;
import com.cs.DownloadParameter.services.DownloadParameterService;

@RestController
@RequestMapping(path = "/api/v1/downloadParameter", produces = "application/json")
public class DownloadParameterController {
	
	Logger logger = LoggerFactory.getLogger(DownloadParameterController.class);
	
	@Autowired
	private DownloadParameterService downloadParameterService;
	
	private ResponseEntity<Map<String, Object>> mapDownloadResponse(String resultMessage, Object resultValue, String transactionId, String paramVersion, String param) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("resultValue", resultValue);
		result.put("resultMessage", resultMessage);
		result.put("transactionId", transactionId);
		result.put("paramVersion", paramVersion);
		result.put("param", param);

		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Map<String, Object>> entity = new ResponseEntity<>(result, headers, HttpStatus.CREATED);

		if (result.toString().length() > 1000) {
			logger.info("Response : " + result.toString().substring(0, 1000).concat("..."));
		} else {
			logger.info("Response : " + result.toString());
		}

		return entity;
	}
	
	private ResponseEntity<Map<String, Object>> mapDownloadStatusResponse(String resultMessage, Object resultValue, String transactionId, Object resultObject) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("resultValue", resultValue);
		result.put("resultMessage", resultMessage);
		result.put("transactionId", transactionId);
		result.put("resultObject", resultObject);
		
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Map<String, Object>> entity = new ResponseEntity<>(result, headers, HttpStatus.CREATED);
		
		if (result.toString().length() > 1000) {
			logger.info("Response : " + result.toString().substring(0, 1000).concat("..."));
		} else {
			logger.info("Response : " + result.toString());
		}
		
		return entity;
	}
	
	
	@PostMapping("/DownloadParameter")
	public ResponseEntity<Map<String, Object>> DownloadParameter(@RequestBody DownloadParamRequest req) {
		logger.info("*******[DownloadParameter]*******");
		String resultValue = ResponseCode.SUCCESS.getCode();
		String resultMessage = ResponseCode.SUCCESS.getMessage();
		TscfDataInfo info = null;
		try {
			try {
				info = downloadParameterService.DownloadParameter(req);
				
			} catch (ValidateException v) {
				throw v;
			}catch (Exception e) {
				if(ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getCode().equals(e.getMessage())){
					return mapDownloadResponse(ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getMessage(), ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getCode(), req.getTransactionId(), null, null);
				}else if(ResponseCodeRelate.NOT_FOUND_PARAMETER_RELATE.getCode().equals(e.getMessage())) {
					return mapDownloadResponse(ResponseCodeRelate.NOT_FOUND_PARAMETER_RELATE.getMessage(), ResponseCodeRelate.NOT_FOUND_PARAMETER_RELATE.getCode(), req.getTransactionId(), null, null);
				}else if(ResponseCodeRelate.NOT_FOUND_RELATE.getCode().equals(e.getMessage())) {
					return mapDownloadResponse(ResponseCodeRelate.NOT_FOUND_RELATE.getMessage(), ResponseCodeRelate.NOT_FOUND_RELATE.getCode(), req.getTransactionId(), null, null);
				}else {
					throw e;
				}
			}
		} catch (ValidateException v) {
			logger.error("ValidateException : " + v.getMessage());
			return mapDownloadResponse(ResponseCode.INVALID.formatMessage(v.getField()), ResponseCode.INVALID.getCode(), req.getTransactionId(), null, null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception : " + e.getMessage());
			return mapDownloadResponse(ResponseCode.EXCEPTION.formatMessage(e.getMessage()), ResponseCode.EXCEPTION.getCode(), req.getTransactionId(), null, null);
		}
		return mapDownloadResponse(resultMessage, resultValue, req.getTransactionId(),info.getTerminalParameterVersion(),info.getTscfString());
	}
	
	@PostMapping("/DownloadParameterStatus")
	public ResponseEntity<Map<String, Object>> DownloadParameterStatus(@RequestBody DownloadParamRequest req) {
		logger.info("*******[DownloadParameterStatus]*******");
		String resultValue = ResponseCode.SUCCESS.getCode();
		String resultMessage = ResponseCode.SUCCESS.getMessage();
		TscfDataInfo info = null;
		try {
			try {
				info = downloadParameterService.DownloadParameterStatus(req);
			} catch (ValidateException v) {
				throw v;
			}catch (Exception e) {
				if(ResponseCodeRelate.NOT_FOUND_PARAMETER_STATUS_RELATE.getCode().equals(e.getMessage())){
					return mapDownloadResponse(ResponseCodeRelate.NOT_FOUND_PARAMETER_STATUS_RELATE.getMessage(), ResponseCodeRelate.NOT_FOUND_PARAMETER_STATUS_RELATE.getCode(), req.getTransactionId(), null, null);
				}else{
					throw e;
				}
			}
		} catch (ValidateException v) {
			logger.error("ValidateException : " + v.getMessage());
			return mapDownloadStatusResponse(ResponseCode.INVALID.formatMessage(v.getField()), ResponseCode.INVALID.getCode(), req.getTransactionId(), null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception : " + e.getMessage());
			return mapDownloadStatusResponse(ResponseCode.EXCEPTION.formatMessage(e.getMessage()), ResponseCode.EXCEPTION.getCode(), req.getTransactionId(), null);
		}
		return mapDownloadStatusResponse(resultMessage, resultValue, req.getTransactionId(), null);
	}
	

}
