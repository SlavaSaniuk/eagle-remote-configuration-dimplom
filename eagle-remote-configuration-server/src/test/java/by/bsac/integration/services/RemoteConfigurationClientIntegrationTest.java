package by.bsac.integration.services;

import by.bsac.Main;
import by.bsac.core.ServerAddress;
import by.bsac.core.ServerConfigurationUrl;
import by.bsac.core.ServerService;
import by.bsac.dto.RemoteConfResponse;
import by.bsac.services.remote.RemoteConfigurationClient;
import by.bsac.services.remote.WebClientsStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest(classes = Main.class)
public class RemoteConfigurationClientIntegrationTest {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteConfigurationClientIntegrationTest.class);
    //Spring beans
    @Autowired
    private RemoteConfigurationClient TEST_SERVICE;

    @Autowired
    private WebClientsStore CLIENTS_STORE;

    @Test
    void loadProperties_webClientAlreadyAdded_shouldRetrieveConfigurationProperties() {

        //Add WebClient
        ServerAddress addr = new ServerAddress();
        addr.setServerProtocol(ServerAddress.PROTOCOL.HTTP);
        addr.setServerIp("localhost");
        addr.setServerPort(8080);
        this.CLIENTS_STORE.addWebClient("test-service", addr);

        ServerService service = new ServerService();
        service.setServiceName("test-service");

        ServerConfigurationUrl urls = new ServerConfigurationUrl();
        urls.setLoadUrl("/remote-configuration/load");

        RemoteConfResponse response = this.TEST_SERVICE.loadProperties(service, urls);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getConfProperties());

        LOGGER.debug("Configuration properties: " +response);

    }
}
