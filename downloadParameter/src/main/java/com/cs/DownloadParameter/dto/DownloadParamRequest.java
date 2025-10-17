package com.cs.DownloadParameter.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DownloadParamRequest {
	
	private String transactionId;
	private String enterpriseId;
	private String merchantId;
	private String terminalId;
	private String paramVersion;
	private String isSuccess;

}
