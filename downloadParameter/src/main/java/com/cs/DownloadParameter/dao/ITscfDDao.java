package com.cs.DownloadParameter.dao;

public interface ITscfDDao {
	
	public void updateRequest(int tscfDId) throws Exception;
	public void updateSuccess(int tscfDId, boolean isSuccess) throws Exception;

}
