package project.ws;

import project.model.Greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "GreetingService")
public interface GreetingService {

    @WebMethod()
    Greeting sayHello(@WebParam(name = "GreetingsRequest") String name);

    @WebMethod()
    Greeting sayBye(@WebParam(name = "GreetingsRequest") String name);
}
