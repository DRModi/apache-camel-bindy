package com.learncamel.routes.csv;

import com.learncamel.domain.Address;
import com.learncamel.domain.EmployeeWithAddress;
import com.learncamel.routes.csv.LinkJavaToCSVMarshallingRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LinkJavaToCSVMarshallingRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder(){
        return new LinkJavaToCSVMarshallingRoute();
    }

    @Test
    public void LinkJavaToCsvTest() throws InterruptedException {

        Address address = new Address("255 Coggins Drive","Pleasant Hill", "California","94523", "USA");

        EmployeeWithAddress employee = new EmployeeWithAddress("001","Dixit","Modi",address);
        EmployeeWithAddress employee1 = new EmployeeWithAddress("002","Arti","Modi",address);
        EmployeeWithAddress employee2 = new EmployeeWithAddress("003","Aaradhy","Modi",address);

        List<EmployeeWithAddress> employeeWithAddressList = new ArrayList<EmployeeWithAddress>();

        employeeWithAddressList.add(employee);
        employeeWithAddressList.add(employee1);
        employeeWithAddressList.add(employee2);

        template.sendBody("direct:inputJavaObjectList", employeeWithAddressList);


        File file = new File("data/csv/output/csvOutputWithAddress.txt");

        Thread.sleep(3000);

        assertTrue(file.exists());
    }
}
