package com.cs.DownloadParameter.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TscfDataInfo {
	
	private Integer tscfHId;
	private Integer tscfDId;
	private Integer terminalIdPk;
	private String terminalId;
	private String terminalParameterVersion;  
	private Date createdDate;
	private byte[] tscfTag;
	private String tscfString;
	
	private Integer enterpriseIdPk;
	private Integer merchantIdPk;
	private String enterpriseId;
	private String merchantId;

}
