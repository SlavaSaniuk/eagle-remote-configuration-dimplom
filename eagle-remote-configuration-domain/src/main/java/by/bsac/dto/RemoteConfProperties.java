package by.bsac.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@NoArgsConstructor
@Getter @Setter
@ToString
public class RemoteConfProperties {

    private Map<String, String> configuration_properties = new HashMap<>();

    public static RemoteConfProperties of(Properties props) {
        RemoteConfProperties p = new RemoteConfProperties();
        props.forEach((key, value) -> p.getConfigurationProperties()
                .put(key.toString(), value.toString()));
        return p;
    }

}
