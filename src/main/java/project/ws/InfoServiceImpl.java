package project.ws;

import org.springframework.stereotype.Service;
import project.model.Greeting;

import java.util.Date;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Greeting sayHowAreYou(String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage("How are you " + name + "!!!");
        greeting.setDate(new Date());
        return greeting;
    }
}
