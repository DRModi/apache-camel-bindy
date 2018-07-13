# learncamel-bindy
-------------------
CSV to Java UnMarshalling:
**************************

- add following bindy maven dependency

    <!-- https://mvnrepository.com/artifact/org.apache.camel/camel-bindy -->
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-bindy</artifactId>
        <version>2.20.1</version>
    </dependency>

 - Define CsvRecord annotation with separator and skip first line.. at class level

    @CsvRecord(separator = "//*", skipFirstLine = true)

- On each field required to define the corrosponding position in CSV file.. at field level

    @DataField(pos = 0)

 - Add Bindy Data format while unmarshalling:

    DataFormat dataFormat = new BindyCsvDataFormat(Employee.class);
