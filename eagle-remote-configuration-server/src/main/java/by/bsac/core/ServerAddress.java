package by.bsac.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ServerAddress {

    //Class variables
    @Getter
    @Setter
    private PROTOCOL server_protocol;
    @Getter
    @Setter
    private String server_ip;
    @Getter
    @Setter
    private int server_port;;

    public enum PROTOCOL {
        HTTP,
        HTTPS
    }

    public String getServerAddress() {
        return String.format("%s://%s:%s", this.server_protocol.toString().toLowerCase(), this.server_ip, this.server_port);
    }


}
