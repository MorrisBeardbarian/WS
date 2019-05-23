//package soap;
//
//import java.net.URL;
//import javax.xml.namespace.QName;
//import javax.xml.ws.Service;
//
//public class TesterClient {
//	public static void main(String[] args) throws Exception {
//	
//		URL url = new URL("http://127.0.0.1:8081/jaws?wsdl");
//		QName qname = new QName("http://www.myimagehost.com/", "ImageServiceImpl");
//		Service service = Service.create(url, qname);
//		ImageService imgserv = service.getPort(ImageService.class);
//	
//		System.out.println(imgserv.getImageData(1));
//	}
//
//}
