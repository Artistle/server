package server.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import server.entity.Remind;

import java.util.Date;


@RestController
@RequestMapping("/hello")
public class ReminderController {

    @RequestMapping(value = "/remainder", method = RequestMethod.GET)
    @ResponseBody
    public Remind getRemainder(ModelMap model){
        return CreateMockRemind();
    }

    private Remind CreateMockRemind() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setTitle("title");
        remind.setRemindDate(new Date());

        return remind;
    }
}
