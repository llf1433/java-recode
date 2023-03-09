package operations;
import book.Book;
import book.BookList;
import java.util.Scanner;

public class BorrowOperation implements IOperation{
    public void work(BookList bookList) {
        //借阅图书
        System.out.println("输入图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.books[i];
            if (name.equals(book.getName())) {
                if (book.isBorrow()) {
                    System.out.println("此书已被借出！");
                    return;
                } else {
                    book.setBorrow(true);
                    System.out.println("借阅成功！");
                    return;
                }
            }
        }
        System.out.println("为找到你要借书");
    }
}
