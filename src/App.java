
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import calculadora.CalculadoraServer;

public class App {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://127.0.0.1:3000/api/calc?wsdl");
        QName qName = new QName("http://calculadora/", "CalculadoraServerImplService");

        Service ws = Service.create(url, qName);

        CalculadoraServer calc = (CalculadoraServer) ws.getPort(CalculadoraServer.class);

        Integer soma = calc.soma(10, 10);
        System.out.println("Soma = " + soma);
    }
}
