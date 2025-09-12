package calculadora;

import javax.xml.ws.Endpoint;

public class CalculadoraServerPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:3000/api/calc", new CalculadoraServerImpl());
    }
}
