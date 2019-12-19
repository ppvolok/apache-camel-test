package routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class JsonToXmlRoute extends RouteBuilder {
    private static final String SOURCE_FOLDER = "src/test/data/in";
    private static final String DESTINATION_FOLDER = "src/test/data/out";

    public void configure() {
        XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
        xmlJsonFormat.setRootName("data");
        from("file:" + SOURCE_FOLDER + "?fileName=data.json&noop=true")
                .unmarshal(xmlJsonFormat)
                .to("file:" + DESTINATION_FOLDER + "?fileName=data.xml");
    }
}
