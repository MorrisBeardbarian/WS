package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {
	
	@WebMethod
	public boolean register(String email, String username, String password);
	
	@WebMethod
	public boolean changePassword(String email, String olderPassword, String newPassword);

}
