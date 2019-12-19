import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;
import routes.JsonToXmlRoute;
import routes.TimerRoute;

public class Main {
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        CamelContext context = new DefaultCamelContext();
        try {
            TimerRoute timerRoute = new TimerRoute();
            JsonToXmlRoute jsonToXmlRoute = new JsonToXmlRoute();
            context.addRoutes(timerRoute);
            context.addRoutes(jsonToXmlRoute);
            context.start();
            Thread.sleep(10000);
        } finally {
            context.stop();
        }
    }
}
