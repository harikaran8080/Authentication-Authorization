package Security.Practice.Authentication.And.Authorization.common;

import lombok.Data;

@Data
public class APIresponse {
	
	private Integer status;
	
	private Object data;
	
	private Object error;

}
