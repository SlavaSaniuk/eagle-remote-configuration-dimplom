package by.bsac.services.remote;

import by.bsac.core.ServerConfigurationUrl;
import by.bsac.core.ServerService;
import by.bsac.dto.RemoteConfResponse;

public interface RemoteConfigurationClient{

    RemoteConfResponse loadProperties(ServerService service, ServerConfigurationUrl urls);
}
