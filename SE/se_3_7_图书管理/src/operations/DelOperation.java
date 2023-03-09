package operations;
import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    public void work(BookList bookList) {
        //删除图书
        System.out.println("输入删除的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int current = bookList.getUsedSize();
        for (int i = 0; i < current; i++) {
            Book books = bookList.getPos(i);
            if (name.equals(books.getName())) {
                //System.out.println("找到了这本书！");
                for (int j = i; j < bookList.getUsedSize(); j++) {
                    bookList.books[j] = bookList.books[j + 1];
                }
                bookList.books[current + 1] = null;
                System.out.println("删除图书成功！");
                bookList.setUsedSize(current - 1);
                return;
            }
        }
    }


}
