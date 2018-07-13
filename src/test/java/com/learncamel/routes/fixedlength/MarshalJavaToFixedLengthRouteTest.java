package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarshalJavaToFixedLengthRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new MarshalJavaToFixedLengthRoute();
    }

    @Test
    public void MarshalJavaToFixedLengthTest() throws InterruptedException {

        LocalDate dJoiningDate = LocalDate.of(2018,03,01);
        EmployeeWithFixedLength employee = new EmployeeWithFixedLength("001","Dixit M.","Work Hard", dJoiningDate,32, new BigDecimal(1000000));

        LocalDate artiJoiningDate = LocalDate.of(2018,03,07);
        EmployeeWithFixedLength employee2 = new EmployeeWithFixedLength("002","Arti M.","Great Mom", artiJoiningDate,31,new BigDecimal(250000));

        LocalDate aadhuJoiningDate = LocalDate.of(2018,03,11);
        EmployeeWithFixedLength employee3 = new EmployeeWithFixedLength("003","Aaradhy M.","Great Boy", aadhuJoiningDate,04,new BigDecimal(25000));

        List<EmployeeWithFixedLength> employeeWithFixedLengthList = new ArrayList();

        employeeWithFixedLengthList.add(employee);
        employeeWithFixedLengthList.add(employee2);
        employeeWithFixedLengthList.add(employee3);

        template.sendBody("direct:inputObjectList",employeeWithFixedLengthList);

        Thread.sleep(5000);

        File file = new File("data/fixedlength/output/outputFixedLength.txt");

        assertTrue(file.exists());


    }
}
