package operations;
import book.Book;
import book.BookList;
import java.util.Scanner;

public class FindOperation implements IOperation{
    public void work(BookList bookList) {
        //查找图书
        //System.out.println("查找图书");
        System.out.println("输入你要查找的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book books = bookList.getPos(i);
            if (name.equals(books.getName())) {
                System.out.println("找到了这本书！");
                System.out.println(books.toString());
                return;
            }
        }
        System.out.println("没找到！");
        return;
    }
}
