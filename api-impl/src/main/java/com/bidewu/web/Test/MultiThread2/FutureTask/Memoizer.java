package com.bidewu.web.Test.MultiThread2.FutureTask;

import org.apache.commons.lang3.concurrent.Computable;

import java.util.concurrent.*;

/**
 * @Author Created by zengqingzhou on 2019/9/29.
 */
public class Memoizer<A, V> implements Comparable {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null){
                    System.out.println("no cache");
                    f = ft;
                    ft.run();
                }
            }

            try {
                System.out.println("use cache");
                return f.get();
            }catch (CancellationException e){
                cache.remove(arg, f);
            }catch (ExecutionException e){
                System.out.println(e.getCause());
            }
        }
    }

}
