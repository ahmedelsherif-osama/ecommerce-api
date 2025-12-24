package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.payment.dto.CreatePaymentMethodRequest;
import com.ahmed.ecommerce.ecommerce.user.User;
import com.ahmed.ecommerce.ecommerce.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentRepository paymentRepository;
    private final UserService userService;

    public PaymentMethodServiceImpl(PaymentRepository paymentRepository,
                                    UserService userService) {
        this.paymentRepository = paymentRepository;
        this.userService = userService;
    }

    @Override
    public PaymentMethodEntity getForUser(UUID userId, UUID paymentMethodId) {
        PaymentMethodEntity method = paymentRepository.findById(paymentMethodId)
                .orElseThrow(() -> new EntityNotFoundException("Payment method not found"));

        if (!method.getUser().getId().equals(userId)) {
            throw new SecurityException("Payment method does not belong to user");
        }

        return method;
    }

    @Override
    public List<PaymentMethodEntity> getAllForUser(UUID userId) {
        return paymentRepository.findAll().stream()
                .filter(pm -> pm.getUser().getId().equals(userId))
                .toList();
    }

    @Override
    public PaymentMethodEntity create(UUID userId, CreatePaymentMethodRequest request) {
        User user = userService.findById(userId);

        PaymentMethodEntity method = new PaymentMethodEntity();
        method.setUser(user);
        method.setType(request.type());
        method.setProvider(request.provider());
        method.setDetails(request.details());
        method.setActive(true);

        return paymentRepository.save(method);
    }

    @Override
    public void delete(UUID userId, UUID paymentMethodId) {
        PaymentMethodEntity method = getForUser(userId, paymentMethodId);

        // Soft delete is more production-like
        method.setActive(false);

        paymentRepository.save(method);
    }
}
