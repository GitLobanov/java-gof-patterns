package by.lobanov.javagofpatterns.strategy.sealedclasses;

import by.lobanov.javagofpatterns.strategy.sealedclasses.service.TaxService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "by.lobanov.javagofpatterns.strategy.sealedclasses")
public class Main {

    public static void main(String[] args) {
        // В реальном приложении Spring будет управлять зависимостями
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        TaxService taxService = context.getBean(TaxService.class);

        System.out.println(taxService.calculateTax("USA", 100.0)); // Вывод: 10.0
        System.out.println(taxService.calculateTax("Germany", 100.0)); // Вывод: 20.0
        System.out.println(taxService.calculateTax("France", 100.0)); // Вывод: 15.0

        context.close();
    }
}
