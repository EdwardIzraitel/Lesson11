import java.io.Serializable;

public class Boss implements Serializable {
    public String title;
    public Employee e;


    @Override
    public String toString() {
        return "Boss{" +
                "title='" + title + '\'' +
                '}';
    }
}
