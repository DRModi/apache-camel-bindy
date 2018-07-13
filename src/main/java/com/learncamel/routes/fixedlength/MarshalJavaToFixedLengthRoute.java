package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class MarshalJavaToFixedLengthRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        DataFormat bindyDataFormat = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("direct:inputObjectList")
                .log("Received Input Object List message Body is ${body}")
                .marshal(bindyDataFormat)
                .log("After conversion the message is ${body}")
                .to("file:data/fixedlength/output?fileName=outputFixedLength.txt&noop=true");

    }
}
