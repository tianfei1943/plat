package redis.res;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4610884460960483296L;
	
	@Setter
	@Getter
	private String respCode;//响应结果
	@Setter
	@Getter
	private String respMsg;//响应描述
	
	public void setBaseResponseData(String respCode,String respMsg) {
		this.setRespCode(respCode);
		this.setRespMsg(respMsg);
	}

	
}
