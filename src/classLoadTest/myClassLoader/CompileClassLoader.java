//package classLoadTest.myClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Package: classLoadTest
 * <p>
 * Description： TODO 注意打包位置,和编译命令行,为了简介,去掉包引用
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 17:46
 * <p>
 * Version: 0.0.1
 */
public class CompileClassLoader  extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (args.length<1){
            System.out.println("缺少目标类，请按如下格式运行Java源文件：");
//            System.out.println("java classLoadTest.myClassLoader.ComplieClassLoader ClassName");
            System.out.println("java ComplieClassLoader  ClassName");
        }
        // 第一个参数需要运行的类
        String progClass = args[0];
        // 剩下的参数将作为运行目标时的参数
        // 将这些参数赋值到一个新数组中
        String[] proArgs = new String[args.length-1];
        System.arraycopy(args,1,proArgs,0,proArgs.length);
        CompileClassLoader cc1 =new CompileClassLoader();
        // 加载需要运行的类
        System.out.println("36======"+progClass);
        Class<?> clazz = cc1.loadClass(progClass);
        // 获取需要运行的类的主方法
        Method main = clazz.getMethod("main",(new String[0].getClass()));
        Object argeArray[] ={proArgs};
        main.invoke(null,argeArray);

    }
    // 读一个文件的内容
    private byte[] getBytes(String filename) throws IOException{
        File file =new File(filename);
        long len = file.length();
        byte[] raw =new byte[(int)len];
        try( FileInputStream fin = new FileInputStream(file))
        {
           // 一次读取Class文件的全部二进制数据
            int r =fin.read(raw);
            if(r != len) throw new IOException("无法读取全部文件");
            return raw;
        }
    }
    // 定义编译指定java文件的方法
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompliceClassLoder:正在编译"+javaFile+"...");
        Process p =Runtime.getRuntime().exec("javac -encoding UTF-8 "+javaFile);
        try {
            p.waitFor();
        }catch (InterruptedException ie){
            System.out.println("64======="+ie);
        }
        // 获取javac线程的退出值
        int ret = p.exitValue();
        //返回编译是否成功
        return ret==0;
    }
    // 重写Classoader的findClass()方法
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("73============="+name);
        Class clazz =null;
        // 将包路径的 "." 替换成"/"
        String fileStub = name.replace("." ,"/");
        String javaFilename = fileStub+".java";
        String classFilename = fileStub + ".class";
        File javaFile =new File(javaFilename);
        File classFile =new File(classFilename);
        System.out.println(javaFilename);
        // 当指定java源文件存在，且Class文件不存在，或者Java源文件的修改时间比Class文件的修改时间更晚时，重新编译
        System.out.println("83============="+javaFile.exists());
        if(javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())){
            try {
                // 如果编译失败，或者该Class文件不存在
                if(!compile(javaFilename) || ! classFile.exists()){
                throw new ClassNotFoundException("ClassNotFondException:"+javaFilename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 如果Class文件存在，系统负责将该文件转换成Class对象
        if (classFile.exists()){
            try {
                // 将Class文件的二进制数据读入数组
                byte[] raw = getBytes(classFilename);
                // 调用ClassLoader的defineClass方法将二进制数据转换成Class对象
                clazz = defineClass(name,raw,0,raw.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(clazz == null){
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }
}
