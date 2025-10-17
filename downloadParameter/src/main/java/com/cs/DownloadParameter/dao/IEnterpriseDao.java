package com.cs.DownloadParameter.dao;

import java.util.List;

import com.cs.DownloadParameter.dto.EnterpriseRelateInfo;

public interface IEnterpriseDao {
	
	public List<EnterpriseRelateInfo> getRelateEnterpriseMerchantTerminal(String enterpriseId, String merchantId, String terminalId) throws Exception;

}
