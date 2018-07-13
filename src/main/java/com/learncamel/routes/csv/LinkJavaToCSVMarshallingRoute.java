package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class LinkJavaToCSVMarshallingRoute extends RouteBuilder {

    public void configure() throws Exception {

        DataFormat bindyDataFormat = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("direct:inputJavaObjectList")
                .to("log:?level=INFO&showBody=true")
                .marshal(bindyDataFormat)
                .log("Message After Marshalling and Body is : ${body}")
                .to("file:data/csv/output?fileName=csvOutputWithAddress.txt");

    }
}
