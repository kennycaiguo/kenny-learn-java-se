import java.io.File;

public class DiropDemo {
    public static void ShowDirinfo(File file) {
        if (file.isDirectory()) {
            System.out.println("Directory:" + file.getName());
            File[] files = file.listFiles();
            if (files != null) { // 注意这里用于防止文件夹中有些目录不能访问导致的异常
                System.out.println("files(or directories):");
                for (File f : files) {
                    if (f.isDirectory()) {
                        // System.out.println("Directory:" + f.getName());
                        ShowDirinfo(f);
                    } else {

                        System.out.println(f.getParent() + File.separator + f.getName());
                        // System.out.println();
                    }
                }
            }

        } else {
            System.out.println(file.getName());
        }

    }

    public static void ShowDirInfo2(File file) {
        if (file.isDirectory()) {
            System.out.println("Directory:" + file.getName());
            File[] fs = file.listFiles();
            if (fs != null) { // 防止目录不能操作的异常
                for (File f : fs) {
                    ShowDirInfo2(f);
                }
            }

        } else {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        File f = new File("Kenny");
        /*
         * String[] all = f.list(); for (String s : all) { System.out.println(s); }
         */

        ShowDirinfo(f);
    }
}
