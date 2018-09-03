package test.testUtils;

import java.io.File;

public class FileUtils {
    private static final String PREFIX_1 = "matrix1_";
    private static final String PREFIX_2 = "matrix2_";
    private static final String EXTENSION = ".txt";
    private static final String ANSWER = "_answer" + EXTENSION;
    private static final String EXPECTED = "_expected" + EXTENSION;
    private static final String TASK = "_task" + EXTENSION;

    public static File get1VTaskFile(int num){
        return new File(PREFIX_1 + num + TASK);
    }

    public static File get1VExpectedFile(int num){
        return new File(PREFIX_1 + num + EXPECTED);
    }

    public static File get1VAnswerFile(int num){
        return new File(PREFIX_1 + num + ANSWER);
    }

    public static File get2VTaskFile(int num){
        return new File(PREFIX_2 + num + TASK);
    }

    public static File get2VExpectedFile(int num){
        return new File(PREFIX_2 + num + EXPECTED);
    }

    public static File get2VAnswerFile(int num){
        return new File(PREFIX_2 + num + ANSWER);
    }

}
