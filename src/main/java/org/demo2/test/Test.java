package org.demo2.test;


import org.apache.log4j.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        logger.debug("debug measdssage");
        logger.info("info messadasdge");
        logger.error("error meddsssage");
        System.out.println("hahah");
    }
}
