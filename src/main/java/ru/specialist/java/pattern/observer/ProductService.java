package ru.specialist.java.pattern.observer;

/**
 * addProduct/sellProduct - Сервис, который отвечает за
 * поставку и продажу продуктов, товаров
 * subscribe - подписка на товары
 * unsubscribe - отписка
 */
public interface ProductService {

    void addProduct(String product);

    void sellProduct(String product);

    void subscribe(User user, String product);

    void unsubscribe(User user, String product);

}
