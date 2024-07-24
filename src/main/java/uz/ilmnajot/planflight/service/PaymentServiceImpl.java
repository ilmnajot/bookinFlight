package uz.ilmnajot.planflight.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.planflight.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
}
