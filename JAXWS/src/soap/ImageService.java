package soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ImageService {
	@WebMethod
	public String getImageData(Integer id);
	
	@WebMethod
	public void getImages(Integer page, @WebParam(name = "ids", mode = WebParam.Mode.OUT) Holder ids,
            @WebParam(name = "sources", mode = WebParam.Mode.OUT) Holder sources);

	@WebMethod
	public Integer getNumberOfPages();
	
}
