package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class LinkCSVtoJavaUnMarshallingRoute extends RouteBuilder {


    public void configure() throws Exception {

        DataFormat bindyDataFormate = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("file:data/csv/input?fileName=inputCSVwithAddress.txt&noop=true")
                .log("Input Request before Un-marshalling and body is ${body}")
                .unmarshal(bindyDataFormate)
                .log("Message after unmarshalling and body is ${body}")
                .to("direct:outputObjectList");
    }
}
