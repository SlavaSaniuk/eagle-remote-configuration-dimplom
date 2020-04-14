package by.bsac.services.remote;

import by.bsac.core.ServerAddress;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

public interface WebClientsFactory {

    WebClient addWebClient(String service, ServerAddress address);

    WebClient getClientForService(String service);

    Map<String, WebClient> getClientsStore();

}
