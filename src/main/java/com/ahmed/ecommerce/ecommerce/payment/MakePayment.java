package com.ahmed.ecommerce.ecommerce.payment;

import java.math.BigDecimal;

public abstract class MakePayment {
//
//    public BigDecimal checkWalletBalance(){
//
//    };
    public abstract boolean payWithWallet();
    public abstract boolean payWithExternalMethod();

}
