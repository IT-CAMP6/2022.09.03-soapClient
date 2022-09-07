package pl.camp.it.clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pl.camp.it.countries.Country;
import pl.camp.it.countries.GetCountryRequest;
import pl.camp.it.countries.GetCountryResponse;

public class SoapClient extends WebServiceGatewaySupport {

    public Country getCountry(String name) {
        GetCountryRequest getCountryRequest = new GetCountryRequest();
        getCountryRequest.setName(name);

        GetCountryResponse getCountryResponse = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(getCountryRequest);
        return getCountryResponse.getCountry();
    }
}
