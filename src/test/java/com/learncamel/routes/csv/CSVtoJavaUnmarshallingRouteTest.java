package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import com.learncamel.routes.csv.CSVtoJavaUnmarshallingRoute;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CSVtoJavaUnmarshallingRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new CSVtoJavaUnmarshallingRoute();
    }


    @Test
    public void CSVtoJavaUnmarshallingTest(){

        Exchange exchange = consumer.receive("direct:unmarshalOutput");

        List<Employee> employeeList = (List<Employee>) exchange.getIn().getBody();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("Dixit", employeeList.get(0).getFirstName());
        assertEquals("Arti", employeeList.get(1).getFirstName());
        assertEquals("Aaradhy", employeeList.get(2).getFirstName());

    }
}
