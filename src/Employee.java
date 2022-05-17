import com.fasterxml.jackson.annotation.*;

import java.io.*;
import java.util.Date;

@JsonPropertyOrder({ "Full Name", "address","Account Number","date" })
public class Employee implements Externalizable {
    @JsonProperty("Full Name")
    public String name;
    public String address;
    @JsonIgnore
    public int SSN;
    @JsonProperty("Account Number")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int number;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date date = new Date(System.currentTimeMillis());

    /*
    JsonIgnore --
    JsonFormat --
    JsonProperty --
    JsonInclude --
    JsonPropertyOrder --
    */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SSN=" + SSN +
                ", number=" + number +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
//        public String name;
//        public String address;
//        public int number;
//        public Date date = new Date(System.currentTimeMillis());
        if(name.compareTo("Reyan Ali")!=0) {
            System.out.println(name.compareTo("Reyan Ali")!=0);
            out.writeObject(name);
        }
        out.writeObject(address);
        out.writeInt(number);
        out.writeObject(date);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}

//<p>Hello </p> paragrah tags
//<h1>