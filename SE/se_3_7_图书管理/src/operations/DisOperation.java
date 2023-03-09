package operations;
import book.BookList;
public class DisOperation implements IOperation{
    public void work(BookList bookList) {
        //显示所有图书
        System.out.println("显示所有图书");
        for(int i = 0; i < bookList.getUsedSize(); i++) {
            System.out.println(bookList.books[i]);
        }
    }
}
