package DemoGithub.HHdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMelding {
    @RequestMapping("/")
    public String tekst() {
           return "Tekst terug";
    }
    @RequestMapping("/Melding")
    public String melding() {
        return "We sturen een andere melding";
    }

}
