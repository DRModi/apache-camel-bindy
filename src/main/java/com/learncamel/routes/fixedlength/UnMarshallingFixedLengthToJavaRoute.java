package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class UnMarshallingFixedLengthToJavaRoute extends RouteBuilder {


    public void configure() throws Exception {

        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("file:data/fixedlength/input?fileName=inputFixedLength.txt&noop=true")
                .log("Received input message is ${body}")
                .unmarshal(bindy)
                .log("After conversion output message is ${body}")
                .to("direct:outputObjects");
    }
}
