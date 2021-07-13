package exception;

import com.test.demo.entity.Product;

public class NotEnoughProductsInStock extends Exception{

	 private static final String DEFAULT_MESSAGE = "Not enough products in stock";

	    public NotEnoughProductsInStock() {
	        super(DEFAULT_MESSAGE);
	    }

	    public NotEnoughProductsInStock(Product product) {
	        super(String.format("Not enough %s products in stock. Only %d left", product.getName(), product.getQuantity()));
	    }
}
