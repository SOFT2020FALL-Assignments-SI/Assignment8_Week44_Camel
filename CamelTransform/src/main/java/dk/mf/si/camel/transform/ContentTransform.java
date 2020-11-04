package dk.mf.si.camel.transform;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentTransform extends RouteBuilder
{
    private static final String SOURCE  = "CamelTransform/src/data/producer"; //src/data/producer - Hvis det ikke er oprettet i særskilt module
    private static final String DESTINATION1  = "CamelTransform/src/data/consumer1"; //src/data/consumer1 - Hvis det ikke er oprettet i særskilt module
    //private static final String DESTINATION2 = "CamelTransform/src/data/consumer2"; //src/data/consumer2 - Hvis det ikke er oprettet i særskilt module

    @Override
    public void configure() throws Exception
    {
        from("file:" + SOURCE + "?delete=true")
                .process(new ContentProcessor())
                .to("file:" + DESTINATION1);
    }
}
