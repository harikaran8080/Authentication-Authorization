package Security.Practice.Authentication.And.Authorization.service;

import Security.Practice.Authentication.And.Authorization.common.APIresponse;
import Security.Practice.Authentication.And.Authorization.dto.LoginDto;
import Security.Practice.Authentication.And.Authorization.dto.SignUpDto;
import Security.Practice.Authentication.And.Authorization.entity.Studentss;

public interface WorkerImplement {

	APIresponse login(LoginDto dto);

	APIresponse signup(SignUpDto dto);

	APIresponse privateapi(String authorization) throws Exception;
	
	////////////////////////////////Other API\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


}
