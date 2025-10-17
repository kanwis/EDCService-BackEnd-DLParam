package com.cs.DownloadParameter.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.DownloadParameter.entities.TscfD;

import jakarta.transaction.Transactional;

@Repository
public interface ITscfDJPARepository extends JpaRepository<TscfD, Integer>{
	
	final String updateRequest = "UPDATE mst_tscf_d m SET m.is_request= true,m.request_datetime=CURRENT_TIMESTAMP WHERE m.id = :tscfDId";
	@Modifying
	@Transactional
	@Query(value = updateRequest, nativeQuery = true)
	void updateRequest(@Param("tscfDId")int tscfDId);
	
	final String updateSuccess = "UPDATE mst_tscf_d m SET m.is_success= :isSuccess ,m.success_datetime=CURRENT_TIMESTAMP WHERE m.id = :tscfDId";
	@Modifying
	@Transactional
	@Query(value = updateSuccess, nativeQuery = true)
	void updateSuccess(@Param("tscfDId")int tscfDId, @Param("isSuccess") boolean isSuccess);
}
