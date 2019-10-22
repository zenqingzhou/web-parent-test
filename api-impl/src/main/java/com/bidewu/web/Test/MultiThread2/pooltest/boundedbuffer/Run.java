package com.bidewu.web.Test.MultiThread2.pooltest.boundedbuffer;

/**
 * @Author Created by zengqingzhou on 2019/10/16.
 */
public class Run {
    public static void main(String[] args) throws Exception{
//        testBoundedBuffer();
//        testTakeBlocksWhenEmpty();
    }

    /**
     * 随机数
     */
    static int xorShift(int y){
        System.out.println(y+": "+Integer.toBinaryString(y));
        y^=(y<<6);
        System.out.println(y+": "+Integer.toBinaryString(y));
        y^=(y>>>21);
        System.out.println(y+": "+Integer.toBinaryString(y));
        y^=(y<<7);
        System.out.println(y+": "+Integer.toBinaryString(y));
        return y;
    }

    /**
     * 有界缓存
     */
    static void testBoundedBuffer() throws InterruptedException {
        BoundedBuffer boundedBuffer = new BoundedBuffer(3);
        boundedBuffer.put("A");
        Object take = boundedBuffer.take();
        System.out.println(take);
        boundedBuffer.put("B");
        Object take2 = boundedBuffer.take();
        System.out.println(take2);
        boundedBuffer.put("C");
        Object take3 = boundedBuffer.take();
        System.out.println(take3);
        boundedBuffer.put("D");
        Object take4 = boundedBuffer.take();
        System.out.println(take4);
    }

    /**
     * 阻塞
     */
    static void testTakeBlocksWhenEmpty() throws InterruptedException {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(() -> {
            try {
//                bb.put(1);
                Integer take = bb.take();
                System.out.println(take);
//                fail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        taker.start();
        Thread.sleep(1000);
        taker.interrupt();
        taker.join(1000);
        System.out.println(taker.isAlive());
    }
}
