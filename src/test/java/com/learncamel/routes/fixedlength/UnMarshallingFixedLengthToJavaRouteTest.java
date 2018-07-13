package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UnMarshallingFixedLengthToJavaRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new UnMarshallingFixedLengthToJavaRoute();
    }


    @Test
    public void UnmarshllingFixedLengthToJavaTest() throws InterruptedException {

        List<EmployeeWithFixedLength> employeeWithTagList = new ArrayList();

        Exchange exchange = consumer.receive("direct:outputObjects");

        employeeWithTagList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();

        Thread.sleep(5000);

        //assertEquals("Dixit WorkHard",employeeWithTagList.get(0).getName().trim() + " " + employeeWithTagList.get(0).getTag());

        assertEquals("Dixit WorkHard",employeeWithTagList.get(0).getName() + " " + employeeWithTagList.get(0).getTag());
        assertEquals("Arti GreatMom",employeeWithTagList.get(1).getName() + " " + employeeWithTagList.get(1).getTag());
        assertEquals("Aaradhy GreatBoy",employeeWithTagList.get(2).getName() + " " + employeeWithTagList.get(2).getTag());

        LocalDate expectedDate = LocalDate.of(2018,03,01);
        assertEquals(expectedDate.getYear(),employeeWithTagList.get(0).getJoiningDate().getYear());
        assertEquals(expectedDate.getMonth(),employeeWithTagList.get(0).getJoiningDate().getMonth());
        assertEquals(expectedDate.getDayOfMonth(),employeeWithTagList.get(0).getJoiningDate().getDayOfMonth());

        assertEquals(32, employeeWithTagList.get(0).getAge());
        assertEquals(31, employeeWithTagList.get(1).getAge());
        assertEquals(04, employeeWithTagList.get(2).getAge());


        BigDecimal futurExpectedDixitSalary = new BigDecimal("1000000.00");
        BigDecimal futurExpectedArtiShare = new BigDecimal("250000.00");
        BigDecimal futurExpectedAaradhyShare = new BigDecimal("25000.00");

        assertEquals(futurExpectedDixitSalary,employeeWithTagList.get(0).getAnnualSalary());
        assertEquals(futurExpectedArtiShare,employeeWithTagList.get(1).getAnnualSalary());
        assertEquals(futurExpectedAaradhyShare,employeeWithTagList.get(2).getAnnualSalary());
    }

}
