package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVtoJavaUnmarshallingRoute extends RouteBuilder {


    public void configure() throws Exception {

        DataFormat dataFormat = new BindyCsvDataFormat(Employee.class);

        from("file:data/csv/input?fileName=inputCSV.txt&noop=true")
                .log("Received input from file and Body is ${body}")
                .unmarshal(dataFormat)
                .log("After Un-Marshalling and Body is ${body}")
                .to("direct:unmarshalOutput");
    }
}
