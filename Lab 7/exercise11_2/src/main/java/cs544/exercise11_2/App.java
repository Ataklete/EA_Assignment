package cs544.exercise11_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        //	a) application running from retrieves this object from the Spring context

        ApplicationContext context = new
                ClassPathXmlApplicationContext("springconfig.xml");
        IProductService productService =
                context.getBean("productService", IProductService.class);
        IProductService productService1 =
                context.getBean("productService", IProductService.class);

        Product product1 = productService.getProduct(423);
        if (product1 != null) {
            System.out.println(product1.toString());
        }
        Product product2 = productService.getProduct(239);
        if (product2 != null) {
            System.out.println(product2.toString());
        }

        //b) Now we want to add an InventoryService object, and inject this InventoryService into
        //the ProductService using Spring dependency injection.

        System.out.println("we have " + productService.getNumberInStock(423)
                + " product(s) with productNumber 423 in stock");
        System.out.println("we have " + productService.getNumberInStock(239)
                + " product(s) with productNumber 239 in stock");
    }
}
