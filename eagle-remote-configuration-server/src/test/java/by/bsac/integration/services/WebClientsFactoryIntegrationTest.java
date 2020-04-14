package by.bsac.integration.services;

import by.bsac.Main;
import by.bsac.core.ServerAddress;
import by.bsac.services.remote.WebClientsFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(classes = Main.class)
public class WebClientsFactoryIntegrationTest {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientsFactoryIntegrationTest.class);
    //Spring beans
    @Autowired
    private WebClientsFactory TEST_SERVICE;

    @Test
    void addWebClient_newWebClient_shouldAddToClientsStore() {

        WebClient expected = this.TEST_SERVICE.addWebClient("test", new ServerAddress());

        Assertions.assertSame(expected, this.TEST_SERVICE.getClientsStore().get("test"));
        Assertions.assertSame(expected, this.TEST_SERVICE.getClientForService("test"));
    }
}
