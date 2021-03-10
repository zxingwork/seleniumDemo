import org.apache.log4j.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        logger.debug("debug message");
        logger.info("info message");
        logger.error("error message");
    }
}
