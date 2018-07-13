package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import com.learncamel.routes.csv.JavaToCSVMarshallingRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaToCSVMarshallingRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new JavaToCSVMarshallingRoute();

    }


    @Test
    public void JavaToCSVMarshalTest(){

        Employee emp = new Employee("01","Dixit","Modi");
        Employee emp1 = new Employee("02","Arti","Modi");
        Employee emp2 = new Employee("03","Aaradhy","Modi");

        List<Employee> employeeList = new ArrayList();
        employeeList.add(emp);
        employeeList.add(emp1);
        employeeList.add(emp2);

        template.sendBody("direct:inputJavaObjects", employeeList);

        File outputCSVfile = new File("data/csv/output");

        assertTrue(outputCSVfile.isDirectory());
    }
}
