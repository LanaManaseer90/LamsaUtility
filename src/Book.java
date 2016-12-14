import java.io.Serializable;


public class Book implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String bookName;
    private String bookWriter;
    private String companyCopyRight;

    public Book() {
    }

    public Book(String bookName, String bookWriter, String companyCopyRight) {
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.companyCopyRight = companyCopyRight;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getCompanyCopyRight() {
        return companyCopyRight;
    }

    public void setCompanyCopyRight(String companyCopyRight) {
        this.companyCopyRight = companyCopyRight;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", companyCopyRight='" + companyCopyRight + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        String text = bookName + bookWriter + companyCopyRight;
        return text.hashCode();
    }

}
