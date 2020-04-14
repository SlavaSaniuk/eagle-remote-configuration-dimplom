package by.bsac;

import by.bsac.configuration.RootConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RootConfiguration.class)
public class Main extends SpringBootServletInitializer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    //Class variables
    private static final String APPLICATION_NAME = "Eagle remote configuration server";

    public static void main(String[] args) {

        LOGGER.info(String.format("Start [%s] server instance;", APPLICATION_NAME));
        SpringApplication application = new SpringApplication(Main.class);

        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        LOGGER.info(String.format("Start to configure [%s] server;", APPLICATION_NAME));

        LOGGER.info("Disable Spring banner;");
        builder.bannerMode(Banner.Mode.OFF);

        return builder.sources(Main.class);
    }
}
