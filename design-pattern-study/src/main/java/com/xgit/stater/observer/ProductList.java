package com.xgit.stater.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by tianxuanxuan
 * On 2020-08-28 10:42
 */
public class ProductList extends Observable {
    private List<String> productLsit = null;//产品列表

    private static ProductList instance;

    private ProductList(){}

    public static ProductList getInstance(){
        if (instance == null){
            instance = new ProductList();
            instance.productLsit = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 增加观察者，电商接口
     */
    public void addProduceListObserver(Observer observer){
        this.addObserver(observer);
    }

    /**
     * 新增产品
     */
    public void addProduct(String newProduct){
        productLsit.add(newProduct);
        System.out.println("产品列表新增了产品：" + newProduct);
        this.setChanged();//设置被观察者对象发生了变化
        this.notifyObservers(newProduct);//通知观察者，传递新产品
    }
}
