package com.xgit.starter;

import cn.hutool.crypto.digest.BCrypt;

/**
 * Created by tianxuanxuan
 * On 2020-09-27 09:40
 */
public class Test {
    @org.junit.Test
    public void testBCrypt(){
        String hashBCrypt = BCrypt.hashpw("secret",BCrypt.gensalt());
        String hashBCrypt2 = BCrypt.hashpw("456",BCrypt.gensalt());
        boolean checkBCrypt = BCrypt.checkpw("123", hashBCrypt);
        System.out.println("secret:  "+hashBCrypt);
        System.out.println(hashBCrypt2);
        System.out.println(checkBCrypt);
    }
}
