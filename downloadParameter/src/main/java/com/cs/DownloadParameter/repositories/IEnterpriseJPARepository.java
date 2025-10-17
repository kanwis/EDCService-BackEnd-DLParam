package com.cs.DownloadParameter.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.DownloadParameter.entities.Enterprise;

@Repository
public interface IEnterpriseJPARepository extends JpaRepository<Enterprise,Integer>{
	
	
	final String queryEnterprise = """ 
			
			SELECT 
			  e.id
			, e.enterprise_id
			, m.id
			, m.merchant_id
			, t.id
			, t.terminal_id 
			FROM enterprise e 
			LEFT JOIN merchant m on e.id = m.enterprise_id 
			LEFT JOIN terminal t on t.merchant_id = m.id 
			WHERE (:enterpriseId IS NULL OR e.enterprise_id = :enterpriseId) 
			AND (:merchantId IS NULL OR m.merchant_id = :merchantId)
			AND (:terminalId IS NULL OR t.terminal_id = :terminalId)
			
			""";
	@Query(value = queryEnterprise, nativeQuery = true)
	List<Object[]> getRelateEnterpriseMerchantTerminal(@Param("enterpriseId") String enterpriseId, @Param("merchantId") String merchantId, @Param("terminalId") String terminalId);
	
	
}
