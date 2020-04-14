package by.bsac.core;

import by.bsac.dto.RemoteConfBody;
import by.bsac.dto.RemoteConfResponse;

public interface HttpRemoteConfigurer {

    RemoteConfResponse loadProperties(RemoteConfBody body);

    RemoteConfResponse saveProperties(RemoteConfBody body);
}
