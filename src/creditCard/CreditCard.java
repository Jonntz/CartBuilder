package creditCard;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Product> products;

    public CreditCard (double limit) {
        this.limit = limit;
        this.balance = limit;
        this.products = new ArrayList<>();
    }

    public double getLimit(){
        return limit;
    }

    public double getBalance(){
        return balance;
    }

    public List<Product>getProducts () {
        return products;
    }

    public boolean buy( Product product){
        if(this.balance >= product.getPrice()){
            this.balance -= product.getPrice();
            this.products.add(product);
            return true;
        }

        return false;
    }
}
