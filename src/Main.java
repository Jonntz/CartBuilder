import creditCard.CreditCard;
import product.Product;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = scanner.nextDouble();
        CreditCard card = new CreditCard(limit);

        byte option = 1;
        while(option != 0){
            System.out.println("Digite o que quer comprar: ");
            String name = scanner.next();

            System.out.println("Digite o valor do produto: ");
            double price = scanner.nextDouble();

            Product products = new Product(name, price);

            boolean buy = card.buy(products);

            if(buy) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");

                byte choose = scanner.nextByte();
                option = choose;
            } else {
                System.out.println("Saldo insuficiente!");
                option = 0;
            }
        }

        System.out.println("*****************");
        System.out.println("COMPRAS REALIZADAS");
        System.out.println("-----------------");

        Collections.sort(card.getProducts());
        for(Product p: card.getProducts()){
            System.out.println(p.getName() +  " - " + p.getPrice());
        }

        System.out.println("-----------------\n");
        System.out.println("Saldo no cartão: " + card.getBalance());
        System.out.println("*****************");
    }
}