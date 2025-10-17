package com.cs.DownloadParameter.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.DownloadParameter.dao.ITscfDDao;
import com.cs.DownloadParameter.repositories.ITscfDJPARepository;


@Service
public class TscfDDaoImpl implements ITscfDDao{
	
	@Autowired
	private ITscfDJPARepository repo;
	

	@Transactional
	@Override
	public void updateRequest(int tscfDId) throws Exception {
		repo.updateRequest(tscfDId);
	}

	@Transactional
	@Override
	public void updateSuccess(int tscfDId, boolean isSuccess) throws Exception {
		repo.updateSuccess(tscfDId, isSuccess);
		
	}

}
