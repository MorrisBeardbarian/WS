package soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {
	
	@WebMethod
	public boolean register(String email, String username, String password);
	
	@WebMethod
	public boolean changePassword(String email, String olderPassword, String newPassword);
	
	@WebMethod
	public void findUser(String in_username, @WebParam(name = "id", mode = WebParam.Mode.OUT) Holder<Integer> id,
            @WebParam(name = "username", mode = WebParam.Mode.OUT) Holder<String> username);

}
