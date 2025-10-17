package com.cs.DownloadParameter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.DownloadParameter.dao.IEnterpriseDao;
import com.cs.DownloadParameter.dto.EnterpriseRelateInfo;
import com.cs.DownloadParameter.repositories.IEnterpriseJPARepository;

@Service
public class EnterpriseDaoImpl implements IEnterpriseDao{
	
	Logger logger = LoggerFactory.getLogger(EnterpriseDaoImpl.class);
	
	@Autowired
	private IEnterpriseJPARepository repo;

	@Override
	public List<EnterpriseRelateInfo> getRelateEnterpriseMerchantTerminal(String enterpriseId, String merchantId, String terminalId) throws Exception {
			List<Object[]> objects = repo.getRelateEnterpriseMerchantTerminal(enterpriseId, merchantId, terminalId);
			List<EnterpriseRelateInfo> list = null;
		
			if (objects != null) {
				list = new ArrayList<EnterpriseRelateInfo>();
				for (Object[] row : objects) {
					EnterpriseRelateInfo e = new EnterpriseRelateInfo();
					e.setEnIdPk(row[0]!=null ? (int)row[0] : null);
					e.setEnterpriseId(row[1] !=null ? row[1].toString(): null);
					e.setMerchantIdPk(row[2]!=null ? (int)row[2] : null);
					e.setMerchantId(row[3] !=null ? row[3].toString(): null);
					e.setTerminalIdPk(row[4]!=null ? (int)row[4] : null);
					e.setTerminalId(row[5] !=null ? row[5].toString(): null);
					list.add(e);
				}
			}
			
		return list;
	}

}
