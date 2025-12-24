package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.cart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentMethodService paymentMethodService;
    private final Map<PaymentMethodType, PaymentProcessor> processors;

    public PaymentService(
            PaymentMethodService paymentMethodService,
            List<PaymentProcessor> processorList
    ) {
        this.paymentMethodService = paymentMethodService;
        this.processors = processorList.stream()
                .collect(Collectors.toMap(
                        PaymentProcessor::supports,
                        p -> p
                ));
    }

    public Payment processPayment(Cart cart, UUID paymentMethodId, UUID userId) {
        PaymentMethodEntity method =
                paymentMethodService.getForUser(userId, paymentMethodId);

        PaymentProcessor processor =
                Optional.ofNullable(processors.get(method.getType()))
                        .orElseThrow(() ->
                                new IllegalStateException("No processor for " + method.getType())
                        );

        return processor.process(cart, method);
    }
}
