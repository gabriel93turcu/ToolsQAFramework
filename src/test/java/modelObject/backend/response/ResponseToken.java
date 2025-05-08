package modelObject.backend.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseToken {
    private String token;
    private String expires;
    private String status;
    private String result;
}
