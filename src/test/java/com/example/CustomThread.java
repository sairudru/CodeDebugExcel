package com.example;

public class CustomThread extends Thread{
    String browser;
    AmazonTest test;
    CustomThread(String threadName, String browser){
        super(threadName);
        this.browser=browser;
        test= new AmazonTest();
    }
    @Override
    public void run(){

        try{
            System.out.println("Thead Started Running :" +Thread.currentThread().getName());
            Thread.sleep(1000);
            test.setUp(browser);
            test.amzonTest(Thread.currentThread().getName());

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            test.tearDown();
        }

    }
}
