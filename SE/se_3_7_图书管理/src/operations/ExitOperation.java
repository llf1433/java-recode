package operations;
import book.BookList;
public class ExitOperation implements IOperation{
    public void work(BookList bookList) {
        //退出系统
        System.out.println("退出系统");
    }
}
