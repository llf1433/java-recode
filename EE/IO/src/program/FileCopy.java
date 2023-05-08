package program;

import java.io.*;
import java.util.Scanner;

public class FileCopy {

    public static void main(String[] args) throws IOException {
        System.out.print("输入要复制的文件(绝对路径OR相对路径):");
        Scanner scanner = new Scanner(System.in);
        String sourcePath = scanner.next();
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()){
            System.out.println("文件不存在!");
            return;
        }
        if (!sourceFile.isFile()) {
            System.out.println("不是普通文件!");
            return;
        }

        System.out.print("输入要复制到的目标路径:");
        String dest = scanner.next();
        File destFile = new File(dest);
        if (destFile.exists()) {
            if (destFile.isDirectory()) {
                System.out.println("目标路径已存在,并且是一个目录,检查路径是否正确!");
                return;
            }
            if (destFile.isFile()) {
                System.out.println("目标路径已存在是否进行覆盖?(y/n)");
                String ans = scanner.next();
                if (!ans.toLowerCase().equals("y")) {
                    System.out.println("停止复制!");
                    return;
                }
            }
        }

        try(InputStream is = new FileInputStream(sourceFile)) {
            try(OutputStream os = new FileOutputStream(destFile)) {
                byte[] buf = new byte[1024];
                int len;
                while (true) {
                    len = is.read(buf);
                    if (len == -1) {
                        break;
                    }
                    os.write(buf,0, len);
                }
                os.flush();
            }
        }
        System.out.println("复制完成!");
    }
}
