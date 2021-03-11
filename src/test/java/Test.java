import org.apache.log4j.Logger;
import org.demo2.enums.Color;
import org.demo2.enums.PlatForm;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        System.out.println(Color.GREEN.toString().equals("GREEN"));

    }
}
