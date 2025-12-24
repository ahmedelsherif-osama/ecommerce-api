package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.cart.Cart;
import org.springframework.stereotype.Service;

@Service
public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentMethodType supports() {
        return PaymentMethodType.CASH;
    }

    @Override
    public Payment process(Cart cart, PaymentMethodEntity method) {
        Payment payment = new Payment();
        payment.setCart(cart);
        payment.setPaymentMethod(method);
        payment.setAmount(cart.getTotalPrice());
        payment.setSuccess(true);
        return payment;
    }
}

//@Primary
//@Service
//public class CashPaymentService implements PaymentService {
//    private final PaymentRepository paymentRepository;
//    public CashPaymentService(PaymentRepository paymentRepository){
//        this.paymentRepository = paymentRepository;
//    }
//
//    @Override
//    public Payment processPayment(Cart cart, UUID paymentMethodId, UUID userId) {
//        final PaymentMethodEntity method = paymentRepository.findById(paymentMethodId).orElseThrow(()->new EntityNotFoundException(paymentMethodId.toString()));
//
//        if (!"CASH".equals(method.getType())) {
//            throw new IllegalArgumentException("CashPaymentService only supports CASH");
//        }
//
//
//        if (!method.isActive()) {
//            throw new IllegalStateException("Payment method is inactive");
//        }
//
//        if (!method.getUser().getId().equals(userId)) {
//            throw new SecurityException("Payment method does not belong to user");
//        }
//
//        Payment payment = new Payment();
//        payment.setCart(cart);
//        payment.setPaymentMethod(method);
//        payment.setAmount(cart.getTotalPrice());
//        payment.setSuccess(true);
//
//        // persist payment
//        // paymentRepository.save(payment);
//
//        return payment;
//    }
//}
