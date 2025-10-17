package com.cs.DownloadParameter.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DownloadParamResponse {
	
	private String transactionId;
	private String paramVersion;
	private String param;

}
