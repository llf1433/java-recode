package book;

public class BookList {
    public Book[] books = new Book[10];//书的数组,设定大小
    public int usedSize; //存储书的数量

    /**
     * 通过构造，初始化时预先在数组存储三本书，usedSize = 3
     */
    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 50, "小说" );
        books[1] = new Book("西游记", "吴承恩", 49, "小说" );
        books[2] = new Book("红楼梦" , "曹雪芹", 49, "小说");
        this.usedSize = 3;
    }



}
