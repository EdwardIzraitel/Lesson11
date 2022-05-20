import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        /** Uncomment to see methods in action **/
//        xmlWriter();
//        xmlReader();dsfsfsdf
        //sdfsdfds
        jsonWriter();
        //
//        jsonReader();sadasda
//        yamlWriter();
//        yamlReader(); askjdhkasjdhsa
    }
    public static void yamlReader(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            List<Employee> employees = mapper.readValue(new File("yamlFile.yaml"), new TypeReference<List<Employee>>(){});
            for(Employee e: employees){
                System.out.println(e);
            }
        }catch(IOException e){}
    }
    public static void yamlWriter(){
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        Employee e2 = new Employee();
        e2.name = "Micheal";
        e2.address = "Somewhere";
        e2.SSN = 123;
        e2.number = 202;
        /** Boss object to see how yaml will look like if Employee was an attribute  **/
//        Boss b = new Boss();
//        b.e = e2;
//        b.title = "Boss";

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e);
        employeeList.add(e2);


        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File("yamlFile.yaml"), employeeList);
            /** uncomment this line and comment the above line to see how the file would look like **/
//            mapper.writeValue(new File("yamlFile.yaml"), b);
        }catch(IOException x){}
    }
    public static void jsonReader(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Employee> employees = mapper.readValue(new File("jsonFile.json"), new TypeReference<List<Employee>>(){});
            for(Employee e: employees){
                System.out.println(e);
            }
        }catch(IOException e){}
    }
    public static void jsonWriter() throws IOException {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
//        e.number = 101;
        Employee e2 = new Employee();
        e2.name = "Micheal";
        e2.address = "Somewhere";
        e2.SSN = 123;
        e2.number = 202;

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e);
        employeeList.add(e2);

        ObjectMapper mapper = new ObjectMapper();
        FileOutputStream outStream = new FileOutputStream(new File("jsonFile.json"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);

        try {
            e.writeExternal(objectOutputStream);
//            mapper.writeValue(new File("jsonFile.json"), employeeList);
        }catch(IOException x){}
    }

    public static void xmlReader(){
        XMLDecoder decoder=null;
        try{
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("test2.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File dvd.xml");
        }
        Employee employee = (Employee) decoder.readObject();
        System.out.println(employee);
    }

    public static void xmlWriter(){
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;


        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("test2.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File dvd.xml");
        }
        encoder.writeObject(e);
        encoder.close();
    }
}
