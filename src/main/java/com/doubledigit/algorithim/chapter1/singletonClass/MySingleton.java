package com.doubledigit.algorithim.chapter1.singletonClass;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 */
public class MySingleton {

    private static MySingleton instance = null;

    private MySingleton(){
        System.out.println(" Private Constructor");
    }

    public static MySingleton getInstance(){
        if(instance == null){
            synchronized (MySingleton.class){
                if(instance == null){
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }


}
