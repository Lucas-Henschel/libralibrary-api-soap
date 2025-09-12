package calculadora;

import javax.jws.WebService;

@WebService(endpointInterface = "calculadora.CalculadoraServer")
public class CalculadoraServerImpl implements CalculadoraServer {

    @Override
    public Integer soma(Integer num1, Integer num2) {
        return num1 + num2;
    }

}
