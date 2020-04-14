package by.bsac.services.remote;

import by.bsac.core.ServerAddress;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

//@Service("WebClientFactory")
public class WebClientsFactoryImpl implements WebClientsFactory {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientsFactoryImpl.class);
    //Class variables
    private static final Map<String, WebClient> CLIENTS_STORE = new HashMap<>();

    public WebClient addWebClient(String service, ServerAddress address) {

        LOGGER.debug(String.format("Construct new WebClient instance for [%s] service name with [%s] server address;", service, address.getServerAddress()));
        //Construct new client
        final WebClient client = WebClient.builder()
                .baseUrl(address.getServerAddress())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();

        //Put client to store
        CLIENTS_STORE.put(service, client);
        LOGGER.debug(String.format("WebClient instance for [%s] service name with [%s] server address was created;", service, address.getServerAddress()));

        return client;
    }

    public WebClient getClientForService(String service) {
        LOGGER.debug(String.format("Get WebClient instance for service[%s];", service));
        return CLIENTS_STORE.get(service);
    }

    @Override
    public Map<String, WebClient> getClientsStore() {
        return CLIENTS_STORE;
    }
}
