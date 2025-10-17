package com.cs.DownloadParameter.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.DownloadParameter.entities.TscfH;


@Repository
public interface ITscfHJPARepository extends JpaRepository<TscfH, Integer>{
	
	final String queryTscf = """
			
			SELECT h.id as h_id
			, d.id as d_id
			, t.id as terminal_id_pk
			, t.terminal_id
			, h.terminal_parameter_version 
			, d.created_date
			, d.tscf_tag
			FROM mst_tscf_h h 
			LEFT JOIN mst_tscf_d d on d.tscf_h_id = h.id 
			LEFT JOIN terminal t on t.id = d.terminal_id  
			WHERE (:terminalId IS NULL OR t.terminal_id = :terminalId )
			AND is_success = false 
			ORDER BY  d.created_date desc limit 1
	
			""";
	@Query(value = queryTscf, nativeQuery = true)
	List<Object[]> getTscfInfo(@Param("terminalId")String terminalId);
	
	final String queryVersion = """
			
			SELECT 
			
			 h.id as h_id
			, d.id as d_id
			, t.id as terminal_id_pk
			, t.terminal_id
			, h.terminal_parameter_version
			, e.id as e_id
			, m.id as m_id
			, e.enterprise_id
			, m.merchant_id
			
			FROM enterprise e 
			LEFT JOIN merchant m on e. id = m. enterprise_id 
			LEFT JOIN terminal t on t. merchant_id = m. id 
			LEFT JOIN mst_tscf_d d on d. terminal_id = t. id 
			LEFT JOIN mst_tscf_h h on h. id = d. tscf_h_id 
			WHERE (:enterpriseId IS NULL OR e.enterprise_id = :enterpriseId)
			AND (:merchantId IS NULL OR m.merchant_id = :merchantId)
			AND (:terminalId IS NULL OR t.terminal_id = :terminalId) 
			AND (:paramVersion IS NULL OR h.terminal_parameter_version = :paramVersion) 
			ORDER BY h.id desc 
			
			""";
	@Query(value = queryVersion, nativeQuery = true)
	List<Object[]> getTscfParamVersionInfo(@Param("enterpriseId") String enterpriseId, @Param("merchantId") String merchantId, @Param("terminalId") String terminalId, @Param("paramVersion") String paramVersion);
	
}
