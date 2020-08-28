package com.xgit.stater.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by tianxuanxuan
 * On 2020-08-28 10:52
 */
public class TaobaoObserver implements Observer {
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.out.println("发送新产品【" + newProduct + "】同步到淘宝商城");
    }
}
