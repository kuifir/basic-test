import java.io.File;

public class FilenameFilter {
    public  static  void main(String[] args){
        File file=new File("G:\\code\\workspace\\src");
        String[] filenames = file.list(new java.io.FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java")||new File(name).isDirectory();
            }
        });
        String[] filenames2 = file.list(( dir,  name)-> {
                return name.endsWith(".java")||new File(name).isDirectory();
            }
        );
        for (String name:filenames) {
            System.out.println(name);
        }
        for (String name:filenames2) {
            System.out.println(name);
        }
    }
}
