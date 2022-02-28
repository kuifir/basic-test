package IOTest.StreamTest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/28 13:46
 * <p>
 * Version: 0.0.1
 */
public class FileWriterTest {
    public static void main(String[] args)  {
        try(  FileWriter fw=new FileWriter("a.txt");)
        {

            fw.write("d1sfwei阿瑟很多次俩口均可零零，\n ");
            fw.write("1dsfwei阿瑟很多次俩口均可零零，\n ");
            fw.write("2dsfwei阿瑟很多次俩口均可零零，\n ");
            fw.write("2dsfwei阿瑟很多次俩口均可零零，\n ");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
