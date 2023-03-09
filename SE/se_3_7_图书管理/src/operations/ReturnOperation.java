package operations;
import book.BookList;
import java.util.Scanner;
public class ReturnOperation implements IOperation{
    public void work(BookList bookList) {
        //归还图书
        System.out.println("输入归还图书的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if (name.equals(bookList.books[i].getName()) && !bookList.books[i].isBorrow()) {
                bookList.books[i].setBorrow(true);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("未找到此书！");
    }
}
