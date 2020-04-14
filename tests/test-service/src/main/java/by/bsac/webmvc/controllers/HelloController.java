package by.bsac.webmvc.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("HelloController")
public class HelloController {

    @GetMapping(value = "/body/get", headers = "content-type=application/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getBody() {

        ResponseBody body = new ResponseBody();

        body.setWord("Hello");
        body.setOtherWord("world");
        body.setAnyChar('!');

        System.out.println(body);

        return body;

    }

    @Getter @Setter
    static class ResponseBody {

        private String word;
        private String other_word;
        private char any_char;

        @Override
        public String toString() {
            return String.format("%s %s %s", word, other_word, any_char);
        }
    }

}
