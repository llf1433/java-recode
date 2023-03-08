package operations;
import book.BookList;
public class ReturnOperation implements IOperation{
    public void work(BookList bookList) {
        //归还图书
        System.out.println("归还图书");
    }
}
