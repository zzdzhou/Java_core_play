package jack.java8.completablefuture.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-10-24
 */
public class Shop {

    public static final List<Shop> SHOPS = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ThymeleafShop")/*,
            new Shop("DellBoutique")*/);

    private String name;
    private Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random();
    }

    public String getName() {
        return name;
    }

    /**
     * 同步获取价格
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 异步获取价格
     * @param product
     * @return
     */
    public Future<Double> getPricesAsync(String product) {
        CompletableFuture<Double> priceFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                priceFuture.complete(price);
            } catch (Exception e) {
                priceFuture.completeExceptionally(e);
            }
        }).start();

        return priceFuture;
    }

    /**
     * 使用{@link CompletableFuture} 异步和获取价格
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);

    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
