package program;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *  扫描指定目录，并找到名称中和内容中包含指定字符的所有普通文件（不包含目录）
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要扫描的根目录(绝对路径OR相对路径)");
        String rootPath = scanner.next();
        File rootDir = new File(rootPath); //

        if (!rootDir.isDirectory()) {
            System.out.println("你输入的不是目录!");
            return;
        }

        System.out.println("输入要找出的文件名中的字符:");
        String target = scanner.next();

        List<File> ret = new ArrayList<>();

        //scanDir(rootDir,target,ret); //深度优先遍历（递归）完成遍历
        scanDirWithContent(rootDir, target, ret);
        System.out.println("共找到符合条件文件" + ret.size() + "个" + "分别是");
 /*       for (File file: ret) {
            System.out.println(file.getCanonicalPath());//绝对路径
            System.out.println("是否要删除文件? y/n");
            String  choose = scanner.next();
            if (choose.equals("y")) {
                if (file.delete()) {
                    System.out.println("删除成功!");
                } else {
                    System.out.println("删除失败!");
                }
            }

        }*/
        for (File x : ret) {
            System.out.println(x.getCanonicalPath());
        }


    }

    private static void scanDirWithContent(File rootDir, String token, List<File> result) throws IOException {
        File[] files = rootDir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirWithContent(file, token, result);
            } else {
                if (isContentContains(file, token)) {
                    result.add(file.getAbsoluteFile());
                }
            }
        }
    }

    // 全部按照utf-8的字符文件来处理
    private static boolean isContentContains(File file, String token) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = new FileInputStream(file)) {
            try (Scanner scanner = new Scanner(is, "UTF-8")) {
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine());
                    sb.append("\r\n");
                }
            }
        }
        return sb.indexOf(token) != -1;//是否存在 token
    }
}

