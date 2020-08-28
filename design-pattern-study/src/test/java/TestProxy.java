import com.xgit.stater.jdkproxy.HelloWord;
import com.xgit.stater.jdkproxy.HelloWorldImpl;
import com.xgit.stater.jdkproxy.JdkProxyExample;
import com.xgit.stater.observer.JingdongObserver;
import com.xgit.stater.observer.ProductList;
import com.xgit.stater.observer.TaobaoObserver;
import org.testng.annotations.Test;

/**
 * Created by tianxuanxuan
 * On 2020-08-28 09:40
 */



public class TestProxy {
    @Test
    public void testJdkProxy() {
        //真实对象
        HelloWorldImpl real = new HelloWorldImpl();
        JdkProxyExample jdk = new JdkProxyExample();
        //将真实对象绑定到代理对象
        HelloWord proxy = (HelloWord) jdk.bind(real);
        //通过代理对象调用真实对象的方法
        proxy.sayHelloWorld();
    }

    @Test
    public void testObserver() {
        ProductList observable = ProductList.getInstance();
        TaobaoObserver taobaoObserver = new TaobaoObserver();
        JingdongObserver jingdongObserver = new JingdongObserver();
        observable.addObserver(taobaoObserver);
        observable.addObserver(jingdongObserver);
        observable.addProduct("新商品");
    }
}
