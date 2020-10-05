package cs544.exercise11_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//		IBookService bookService = new BookService();
        ApplicationContext context = new
                ClassPathXmlApplicationContext("springconfig.xml");

        IBookService bookService = context.getBean("bookService", IBookService.class);

//		bookService.buy(new Book("123433267", "Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
//        bookService.buy(new Book("888832678", "Harry Potter and the Sorcerer's Stone" , "J.K. Rowling"));
//        bookService.buy(new Book("999923156", "Harry Potter and the Goblet of Fire" ,"J.K. Rowling"));

        bookService.addSupplier(context.getBean("amazon", IBookSupplier.class));
        bookService.addSupplier(context.getBean("barnesAndNoble", IBookSupplier.class));
        bookService.addSupplier(context.getBean("eBooks", IBookSupplier.class));
        bookService.addSupplier(context.getBean("borders", IBookSupplier.class));

        bookService.buy(context.getBean("book1", Book.class));
        bookService.buy(context.getBean("book2", Book.class));
        bookService.buy(context.getBean("book3", Book.class));


    }
}
