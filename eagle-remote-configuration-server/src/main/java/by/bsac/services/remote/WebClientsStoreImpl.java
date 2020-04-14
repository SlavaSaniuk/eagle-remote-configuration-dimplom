package by.bsac.services.remote;

import by.bsac.core.ServerAddress;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

//@Service("WebClientsStore")
public class WebClientsStoreImpl implements WebClientsStore {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientsStoreImpl.class);
    //Spring beans
    @Setter
    private WebClientsFactory web_clients_factory;

    public WebClient addWebClient(String service, ServerAddress address) {
        return this.web_clients_factory.addWebClient(service, address);
    }

    public WebClient getClientForService(String service) {
        return this.web_clients_factory.getClientForService(service);
    }

    @Override
    public Map<String, WebClient> getClientsStore() {
        return this.web_clients_factory.getClientsStore();
    }
}
