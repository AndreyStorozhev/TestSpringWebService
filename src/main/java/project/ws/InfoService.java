package project.ws;

import project.model.Greeting;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "InfoService")
public interface InfoService {
    @WebMethod()
    Greeting sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);
}
