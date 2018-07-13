package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class JavaToCSVMarshallingRoute extends RouteBuilder {


    public void configure() throws Exception {

        DataFormat bindyDataFormat = new BindyCsvDataFormat(Employee.class);

        from("direct:inputJavaObjects")
                .log("Received Input and Body is ${body}")
                .marshal(bindyDataFormat)
                .log("After Marshalling Message and Body is ${body}")
                .to("file:data/csv/output?fileName=csvOutput.txt");
    }
}
