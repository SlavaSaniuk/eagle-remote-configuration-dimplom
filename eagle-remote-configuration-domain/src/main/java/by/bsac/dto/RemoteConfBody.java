package by.bsac.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString
public class RemoteConfBody {

    private RemoteConfProperties conf_properties;
    private RemoteConfUser conf_user;

}
