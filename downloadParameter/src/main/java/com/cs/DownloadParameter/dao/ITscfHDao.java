package com.cs.DownloadParameter.dao;


import com.cs.DownloadParameter.dto.TscfDataInfo;


public interface ITscfHDao {
	
	public TscfDataInfo getTscfInfo(String terminalId) throws Exception;
	public TscfDataInfo getTscfParamVersionInfo(String enterpriseId, String merchantId, String terminalId, String paramVersion) throws Exception;
	
	
}
