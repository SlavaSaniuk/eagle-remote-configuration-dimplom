package by.bsac.webmvc.controllers;

import by.bsac.core.HttpRemoteConfigurer;
import by.bsac.dto.RemoteConfBody;
import by.bsac.dto.RemoteConfProperties;
import by.bsac.dto.RemoteConfResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController("HttpremoteConfigurationController")
public class HttpRemoteConfigurationController implements HttpRemoteConfigurer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRemoteConfigurationController.class);

    @PostMapping(path = "/remote-configuration/load", headers = "content-type=application/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Override
    public RemoteConfResponse loadProperties(@RequestBody RemoteConfBody body) {

        LOGGER.info("Load properties method.");

        Properties props = new Properties();
        props.setProperty("Hello", "world!");
        props.setProperty("Name", "Slava");
        props.setProperty("Age", "23");

        RemoteConfResponse resp = new RemoteConfResponse();
        resp.setConfProperties(RemoteConfProperties.of(props));
        return resp;
    }

    @Override
    public RemoteConfResponse saveProperties(RemoteConfBody body) {
        return null;
    }
}
