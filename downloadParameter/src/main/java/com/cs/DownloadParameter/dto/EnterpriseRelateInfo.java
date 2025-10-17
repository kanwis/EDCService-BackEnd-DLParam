package com.cs.DownloadParameter.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EnterpriseRelateInfo {
	private Integer enIdPk;
	private String enterpriseId;
	private Integer merchantIdPk;
	private String merchantId;
	private Integer terminalIdPk;
	private String terminalId;

}
