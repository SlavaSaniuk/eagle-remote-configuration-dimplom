package by.bsac.services.remote;

import by.bsac.core.ServerConfigurationUrl;
import by.bsac.core.ServerService;
import by.bsac.dto.RemoteConfBody;
import by.bsac.dto.RemoteConfResponse;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

public class RemoteConfigurationClientImpl implements RemoteConfigurationClient {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteConfigurationClientImpl.class);
    //Spring beans
    @Setter
    private WebClientsStore web_clients_store;

    @Override
    public RemoteConfResponse loadProperties(ServerService service, ServerConfigurationUrl urls) {

        LOGGER.debug("Load configuration properties from remote configuration client;");

        //Get WebClient from store
        WebClient client = this.web_clients_store.getClientForService(service.getServiceName());

        //Create request body
        RemoteConfBody body = new RemoteConfBody();

        //Execute request
        RemoteConfResponse response = client.post().uri(urls.getLoadUrl())
                .body(BodyInserters.fromValue(body))
                .exchange().block().bodyToMono(RemoteConfResponse.class).block();

        //Handle response

        //Return response
        return response;
    }
}
