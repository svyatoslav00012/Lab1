package test.tests;

import org.junit.jupiter.api.Test;
import test.testUtils.Test2VUtils;

public class Test2V {

    Test2VUtils test2VUtils = new Test2VUtils();

    @Test
    public void test2Var1InverseMatrix(){
        test2VUtils.testInverseMatrix(1);
    }

    @Test
    public void test2Var2InverseMatrix(){
        test2VUtils.testInverseMatrix(2);
    }

    @Test
    public void test2Var3InverseMatrix(){
        test2VUtils.testInverseMatrix(3);
    }

}
