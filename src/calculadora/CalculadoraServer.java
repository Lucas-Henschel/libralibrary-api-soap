package calculadora;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding
public interface CalculadoraServer {

    @WebMethod
    Integer soma(Integer num1, Integer num2);
}
