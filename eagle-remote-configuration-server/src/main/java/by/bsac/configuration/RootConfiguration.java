package by.bsac.configuration;

import by.bsac.services.ServicesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServicesConfiguration.class)
public class RootConfiguration {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RootConfiguration.class);
}
