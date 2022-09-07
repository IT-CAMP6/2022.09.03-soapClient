package pl.camp.it;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.camp.it.clients.SoapClient;

@Configuration
public class AppConfiguration {

    @Bean
    public Jaxb2Marshaller countriesMarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("pl.camp.it.countries");

        return jaxb2Marshaller;
    }

    @Bean
    public SoapClient soapClient(Jaxb2Marshaller countriesMarshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setMarshaller(countriesMarshaller);
        soapClient.setUnmarshaller(countriesMarshaller);
        soapClient.setDefaultUri("http://localhost:8080/ws/");

        return soapClient;
    }
}
