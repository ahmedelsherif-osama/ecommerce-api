package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.payment.dto.CreatePaymentMethodRequest;
import com.ahmed.ecommerce.ecommerce.payment.dto.PaymentMethodResponse;
import com.ahmed.ecommerce.ecommerce.user.CurrentUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;
    private final CurrentUserService currentUserService;

    public PaymentMethodController(PaymentMethodService paymentMethodService,
                                   CurrentUserService currentUserService) {
        this.paymentMethodService = paymentMethodService;
        this.currentUserService = currentUserService;
    }

    @GetMapping
    public List<PaymentMethodResponse> getMyPaymentMethods() {
        return paymentMethodService
                .getAllForUser(currentUserService.getCurrentUserId())
                .stream()
                .map(PaymentMethodMapper::toResponse)
                .toList();
    }

    @PostMapping
    public PaymentMethodResponse addPaymentMethod(
            @RequestBody CreatePaymentMethodRequest request
    ) {
        return PaymentMethodMapper.toResponse(
                paymentMethodService.create(
                        currentUserService.getCurrentUserId(),
                        request
                )
        );
    }

    @DeleteMapping("/{id}")
    public void deletePaymentMethod(@PathVariable UUID id) {
        paymentMethodService.delete(
                currentUserService.getCurrentUserId(),
                id
        );
    }
}
