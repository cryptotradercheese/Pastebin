package pastebin.analytics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class AnalyticsController {
    @PostMapping
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public void generate500Error() {
    }
}
