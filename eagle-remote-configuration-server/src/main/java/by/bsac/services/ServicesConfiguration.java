package by.bsac.services;

import by.bsac.services.remote.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicesConfiguration.class);
    //Class variables
    private static final String CONSTRUCT_BEAN_PATTERN = "Construct new bean [%s] of class [%s] with implementation [%s];";
    private static final String CREATED_BEAN_PATTERN = "Bean with name [%s] was created;";

    private static final String SET_BEAN_PATTERN = "Set [%s] bean to [%s] bean;";

    @Bean("WebClientsFactory")
    public WebClientsFactory getWebClientsFactory() {

        LOGGER.info(String.format(CONSTRUCT_BEAN_PATTERN,
                "WebClientsFactory", WebClientsFactory.class.getCanonicalName(), WebClientsFactoryImpl.class.getCanonicalName()));
        WebClientsFactoryImpl service = new WebClientsFactoryImpl();

        LOGGER.info(String.format(CREATED_BEAN_PATTERN, "WebClientsFactory"));
        return service;

    }

    @Bean("WebClientsStore")
    public WebClientsStore getWebClientsStore() {

        LOGGER.info(String.format(CONSTRUCT_BEAN_PATTERN,
                "WebClientsStore", WebClientsStore.class.getCanonicalName(), WebClientsStoreImpl.class.getCanonicalName()));
        WebClientsStoreImpl service = new WebClientsStoreImpl();

        LOGGER.info(String.format(SET_BEAN_PATTERN, "WebClientsFactory", "WebClientsStore"));
        service.setWebClientsFactory(this.getWebClientsFactory());

        LOGGER.info(String.format(CREATED_BEAN_PATTERN, "WebClientsStore"));
        return service;
    }

    @Bean("RemoteConfigurationClient")
    public RemoteConfigurationClient getRemoteConfigurationClient() {

        LOGGER.info(String.format(CONSTRUCT_BEAN_PATTERN,
                "RemoteConfigurationClient", RemoteConfigurationClient.class.getCanonicalName(), RemoteConfigurationClientImpl.class.getCanonicalName()));
        RemoteConfigurationClientImpl service = new RemoteConfigurationClientImpl();

        LOGGER.info(String.format(SET_BEAN_PATTERN, "WebClientsStore", "RemoteConfigurationClient"));
        service.setWebClientsStore(this.getWebClientsStore());

        LOGGER.info(String.format(CREATED_BEAN_PATTERN, "RemoteConfigurationClient"));
        return service;

    }
}
