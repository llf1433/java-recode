package program;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *  扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录），并且后续询问用户是否要删除该文件
 */
public class Demo1 {
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

        scanDir(rootDir,target,ret); //深度优先遍历（递归）完成遍历
        System.out.println("共找到符合条件文件" + ret.size() + "个" + "分别是");
        for (File file: ret) {
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
        }
    }





    private static void scanDir(File rootFile,String target, List<File> ret) {
        File[] files = rootFile.listFiles();
        if (files == null) {
            return;
        }

        for (File x: files) {
            if (x.isDirectory()) {
                scanDir(x, target, ret);//
            } else {
                if (x.getName().contains(target)) {
                    ret.add(x.getAbsoluteFile());// 相对路径
                }
            }
        }
    }
}
