package routes;

import org.apache.camel.builder.RouteBuilder;

public class TimerRoute extends RouteBuilder {

    public void configure() {
        from("timer:myTimer?period=2s")
                .setBody()
                .simple("Hello World Camel fired at ${header.firedTime}")
                .to("stream:out");
    }
}
