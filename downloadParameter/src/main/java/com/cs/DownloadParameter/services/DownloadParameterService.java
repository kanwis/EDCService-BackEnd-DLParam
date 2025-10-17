package com.cs.DownloadParameter.services;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cs.DownloadParameter.constants.ResponseCodeRelate;
import com.cs.DownloadParameter.dao.IEnterpriseDao;
import com.cs.DownloadParameter.dao.ITscfDDao;
import com.cs.DownloadParameter.dao.ITscfHDao;
import com.cs.DownloadParameter.dto.DownloadParamRequest;
import com.cs.DownloadParameter.dto.EnterpriseRelateInfo;
import com.cs.DownloadParameter.dto.TscfDataInfo;
import com.cs.DownloadParameter.utils.ValidateUtils;

@Controller
public class DownloadParameterService {
	
	Logger logger = LoggerFactory.getLogger(DownloadParameterService.class);
	
	@Autowired
	private IEnterpriseDao enterpriseDao;
	
	@Autowired
	private ITscfHDao tscfHDao;
	
	@Autowired
	private ITscfDDao tscfDDao;
	
	public TscfDataInfo DownloadParameter(DownloadParamRequest req) throws Exception {
		TscfDataInfo info = null;
		List<EnterpriseRelateInfo> listRelate = null;
		ValidateUtils.isValidTransactionId(req.getTransactionId());
		ValidateUtils.isValidEnterpriseId(req.getEnterpriseId());
		ValidateUtils.isValidMerchantId(req.getMerchantId());
		ValidateUtils.isValidTerminalId(req.getTerminalId());
		
		listRelate = enterpriseDao.getRelateEnterpriseMerchantTerminal(req.getEnterpriseId(), req.getMerchantId(), req.getTerminalId());
		if(listRelate !=null && listRelate.size() >0) {
			info = tscfHDao.getTscfInfo(req.getTerminalId());
			if(info != null) {
				info.setTscfString(convertTscfToString(info.getTscfTag()));
				try {
					tscfDDao.updateRequest(info.getTscfDId());
					logger.info("Update request successfully!.");
				}catch (Exception e) {
					logger.error("ERROR Update request :"+ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getMessage()+", "+e.getMessage());
					throw new Exception(ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getCode());
				}
				
			}else {
				logger.info(ResponseCodeRelate.NOT_FOUND_PARAMETER_RELATE.getMessage());
				throw new Exception(ResponseCodeRelate.NOT_FOUND_PARAMETER_RELATE.getCode());
			}
		}else {
			logger.info(ResponseCodeRelate.NOT_FOUND_RELATE.getMessage());
			throw new Exception(ResponseCodeRelate.NOT_FOUND_RELATE.getCode());
		}
		return info;
	}
	
	private String convertTscfToString(byte [] bytes)throws Exception {
		
		if(bytes == null) {
			return null;
		}
		String tscfJson = new String(bytes, StandardCharsets.UTF_8);
		logger.info("---------------------------------");
		logger.info("\n"+tscfJson);
		
		return tscfJson;
	}
	
	public TscfDataInfo DownloadParameterStatus(DownloadParamRequest req) throws Exception {
		TscfDataInfo info = null;
		ValidateUtils.isValidTransactionId(req.getTransactionId());
		ValidateUtils.isValidEnterpriseId(req.getEnterpriseId());
		ValidateUtils.isValidMerchantId(req.getMerchantId());
		ValidateUtils.isValidTerminalId(req.getTerminalId());
		ValidateUtils.isValidParamVersion(req.getParamVersion());
		ValidateUtils.isValidIsSuccess(req.getIsSuccess());
		boolean isSuccess = false;
		
		info = tscfHDao.getTscfParamVersionInfo(req.getEnterpriseId(), req.getMerchantId(), req.getTerminalId(), req.getParamVersion());
		if(info != null) {
			try {
				 if("1".equals(req.getIsSuccess())) {
					isSuccess = Boolean.TRUE;
				}
				tscfDDao.updateSuccess(info.getTscfDId(),isSuccess);
				logger.info("Update success successfully!.");
			}catch (Exception e) {
				logger.error("ERROR Update success :"+ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getMessage()+", "+e.getMessage());
				throw new Exception(ResponseCodeRelate.CAN_NOT_UPDATE_RELATE.getCode()); 
			}
		}else {
			logger.info(ResponseCodeRelate.NOT_FOUND_PARAMETER_STATUS_RELATE.getMessage());
			throw new Exception(ResponseCodeRelate.NOT_FOUND_PARAMETER_STATUS_RELATE.getCode());
		}
		return info;
	}

}
