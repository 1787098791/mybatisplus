package com.freedom.mybatisplus.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author ：wujie
 * @date ：Created in 2020/8/6 10:50
 * @description：
 * @version:
 */
@Component
public class TransactionalListener {

    @TransactionalEventListener(fallbackExecution = true,phase= TransactionPhase.AFTER_COMMIT)
    //fallbackExecution=true则会在没有事务时也执行该方法，不然只有加上事务才会监听，切记。默认是false
    public void handleSupplierBillPush(Object o){
        System.out.println(o);
    }
    /**
     * 某个事务方法循环触发监听事件,直到事务提交之前,每次触发传递的信息都会暂存,当事务提交后才会一起执行
     */


    public static void main(String[] args) {
        System.out.println(Byte.valueOf("7"));
        System.out.println(Byte.valueOf("7")==7);
    }
}
