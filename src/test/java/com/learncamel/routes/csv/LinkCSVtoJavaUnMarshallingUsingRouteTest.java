package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import com.learncamel.routes.csv.LinkCSVtoJavaUnMarshallingRoute;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkCSVtoJavaUnMarshallingUsingRouteTest extends CamelTestSupport {


    @Override
    public RouteBuilder createRouteBuilder(){
        return new LinkCSVtoJavaUnMarshallingRoute();
    }


    @Test
    public void LinkCSVtoJavaUnmarshallingTest(){

        List<EmployeeWithAddress> employeeWithAddressList = new ArrayList<EmployeeWithAddress>();

        Exchange exchange = consumer.receive("direct:outputObjectList");

        employeeWithAddressList = (List<EmployeeWithAddress>) exchange.getIn().getBody();



        assertEquals("Pleasant Hill", employeeWithAddressList.get(0).getAddress().getCity());
    }
}
