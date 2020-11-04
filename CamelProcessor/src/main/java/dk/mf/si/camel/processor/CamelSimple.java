package dk.mf.si.camel.processor;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelSimple extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("stream:in?promptMessage=Enter message:")
                .choice()
                .when(bodyAs(String.class).contains("Camel"))
                .to("file:CamelProcessor/src/main/resources/Camel") //file:src/main/resources/Camel - Hvis det ikke er oprettet i særskilt module
                .otherwise()
                .to("file:CamelProcessor/src/main/resources/Others") //file:src/main/resources/Others - Hvis det ikke er oprettet i særskilt module
                .end();
    }
}
