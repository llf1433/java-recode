package operations;
import java.util.Scanner;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation{
    public void work(BookList bookList) {
        //添加图书
        System.out.println("输入图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("输入作者名：");
        String author = scanner.nextLine();
        System.out.println("输入价格：");
        //scanner.nextLine();
        int piece = scanner.nextInt();
        System.out.println("输入类型：");
        String type = scanner.nextLine();
        Book book = new Book(name,author,piece,type);
        int currentSize = bookList.getUsedSize();
        bookList.books[currentSize] = book;
        bookList.setUsedSize(currentSize + 1);
        System.out.println("添加成功！");
    }
}
