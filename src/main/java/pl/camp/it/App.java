package pl.camp.it;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.camp.it.clients.SoapClient;
import pl.camp.it.countries.Country;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        SoapClient soapClient = context.getBean(SoapClient.class);

        Country country = soapClient.getCountry("Polska");

        System.out.println(country.getName());
        System.out.println(country.getPopulation());
        System.out.println(country.getCapital());
        System.out.println(country.getCurrency());
    }
}
