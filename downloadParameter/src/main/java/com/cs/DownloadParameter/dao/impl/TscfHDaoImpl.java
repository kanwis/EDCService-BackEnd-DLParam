package com.cs.DownloadParameter.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.DownloadParameter.dao.ITscfHDao;
import com.cs.DownloadParameter.dto.TscfDataInfo;
import com.cs.DownloadParameter.repositories.ITscfHJPARepository;
import com.cs.DownloadParameter.utils.DateUtils;


@Service
public class TscfHDaoImpl implements ITscfHDao{
	
	private Logger logger = LoggerFactory.getLogger(TscfHDaoImpl.class);

	@Autowired
	private ITscfHJPARepository repo;
	
	
	
	@Override
	public TscfDataInfo getTscfInfo(String terminalId) throws Exception {
		TscfDataInfo info = null;
		List<Object[]> objects = repo.getTscfInfo(terminalId);
		if(objects != null && objects.size() >0) {
			info = new TscfDataInfo();
			for (Object[] row : objects) {
				info.setTscfHId(row[0] !=null ? (int)row[0]: null);
				info.setTscfDId(row[1] !=null ? (int)row[1]: null);
				info.setTerminalIdPk(row[2] !=null ? (int)row[2]: null);
				info.setTerminalId(row[3] !=null ? row[3].toString(): null);
				info.setTerminalParameterVersion(row[4] !=null ? row[4].toString(): null);
				info.setCreatedDate(row[5] !=null ? DateUtils.convertToDate(row[5]): null);
				info.setTscfTag(row[6] !=null ? (byte[])row[6]: null);
				break;
			}
			
		}
		return info;
	}

	@Override
	public TscfDataInfo getTscfParamVersionInfo(String enterpriseId, String merchantId, String terminalId, String paramVersion) throws Exception {
		
		List<TscfDataInfo> list = null;
		TscfDataInfo info = null;
		List<Object[]> objects = repo.getTscfParamVersionInfo(enterpriseId, merchantId, terminalId ,paramVersion);
		if(objects != null && objects.size() >0) {
			list = new ArrayList<TscfDataInfo>();
			info = new TscfDataInfo();
			for (Object[] row : objects) {
				info.setTscfHId(row[0] !=null ? (int)row[0]: null);
				info.setTscfDId(row[1] !=null ? (int)row[1]: null);
				info.setTerminalIdPk(row[2] !=null ? (int)row[2]: null);
				info.setTerminalId(row[3] !=null ? row[3].toString(): null);
				info.setTerminalParameterVersion(row[4] !=null ? row[4].toString(): null);
				info.setEnterpriseIdPk(row[5] !=null ? (int)row[5]: null);
				info.setMerchantIdPk(row[6] !=null ? (int)row[6]: null);
				info.setEnterpriseId(row[7] !=null ? row[7].toString(): null);
				info.setMerchantId(row[8] !=null ? row[8].toString(): null);
				list.add(info);
			}
			if(list.size() >1) {
				logger.warn("getTscfParamVersionInfo return more than one row [enterpriseId:"+enterpriseId
						+",merchantId:"+merchantId+",terminalId:"+terminalId+",paramVersion:"+paramVersion+"]");
			}else {
				info = list.get(0);
			}
			
		}
		return info;
	}

}
