package com.codeup.studentdashboard.seeder;

import com.codeup.studentdashboard.dao.repository.HAUOptionsRepository;
import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.models.student.HAUOption;
import com.codeup.studentdashboard.models.student.PaymentOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Component
public class DatabaseSeeder {
    private PaymentOptionsRepository paymentOptionsRepository;
    private HAUOptionsRepository hauOptionsRepository;

    @Autowired
    public DatabaseSeeder(PaymentOptionsRepository paymentOptionsRepository,
                          HAUOptionsRepository hauOptionsRepository) {
        this.paymentOptionsRepository = paymentOptionsRepository;
        this.hauOptionsRepository = hauOptionsRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedPaymentOptions();
        seedHAUOptions();
    }

    private void seedPaymentOptions() {
        //Get the current amount of records in the database
        long count = StreamSupport.stream(
                paymentOptionsRepository.findAll().spliterator(),
                false)
                .count();
        if (count < 5) {
            //seed the table
            PaymentOption paymentOptions[] = {
                    new PaymentOption("Self Payment"),
                    new PaymentOption("VA Benefits"),
                    new PaymentOption("Loan"),
                    new PaymentOption("Grant"),
                    new PaymentOption("Other payment option")
            };

            paymentOptionsRepository.save(Arrays.asList(paymentOptions));
            System.out.println();
        }
    }

    private void seedHAUOptions() {
        long count = StreamSupport.stream(
                hauOptionsRepository.findAll().spliterator(),
                false)
                .count();
        if (count < 14) {
            HAUOption hauOption[] = {
                    new HAUOption("Twitter or Facebook"),
                    new HAUOption("YouTube"),
                    new HAUOption("The Muse"),
                    new HAUOption("Billboard"),
                    new HAUOption("TV"),
                    new HAUOption("Radio"),
                    new HAUOption("News"),
                    new HAUOption("Web Search"),
                    new HAUOption("Geekdom"),
                    new HAUOption("Friend or Family"),
                    new HAUOption("Employer"),
                    new HAUOption("Codeup Student"),
                    new HAUOption("Job or school fair"),
                    new HAUOption("Other")
            };
            hauOptionsRepository.save(Arrays.asList(hauOption));
        }
    }
}
