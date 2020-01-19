package jack.java8.completablefuture.completablefuture;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-10-26
 */
public class Shops {

    /**
     * 使用 顺序流 或 并行流 进行异步调用
     * @param product
     * @return
     */
    public List<String> findPrices(String product) {
        return Shop.SHOPS
//                .stream()
                .parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    /**
     * 使用 CompletableFuture 完成 异步调用
     * @param product
     * @return
     */
    public List<String> findPriceByCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFuture = Shop.SHOPS.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
                .collect(toList());

        return priceFuture.stream()
            .map(future -> future.join())
            .collect(toList());
    }

    @Test
    public void availableProcessors() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    /**
     *
     */
    @Test
    public void testFindPrices() {
        long start = System.nanoTime();
        System.out.println(findPrices("jack"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        // 1毫秒 = 1000 微妙 = 1,000,000 纳秒
        System.out.println("Done in " + duration + " millisecond");
    }

    @Test
    public void testFindPricesAsync() {
        long start = System.nanoTime();
        System.out.println(findPriceByCompletableFuture("jack"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        // 1毫秒 = 1000 微妙 = 1,000,000 纳秒
        System.out.println("Done in " + duration + " millisecond");
    }

}
