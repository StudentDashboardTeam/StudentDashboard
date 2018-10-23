package com.codeup.studentdashboard.seeder;

import com.codeup.studentdashboard.dao.repository.EventTypeRepository;
import com.codeup.studentdashboard.dao.repository.HAUOptionsRepository;
import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.models.EventType;
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
    private EventTypeRepository eventTypeRepository;

    @Autowired
    public DatabaseSeeder(PaymentOptionsRepository paymentOptionsRepository,
                          HAUOptionsRepository hauOptionsRepository,
                          EventTypeRepository eventTypeRepository) {
        this.paymentOptionsRepository = paymentOptionsRepository;
        this.hauOptionsRepository = hauOptionsRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedPaymentOptions();
        seedHAUOptions();
        seedEventTypes();
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

    private void seedEventTypes() {
        long count = StreamSupport.stream(
            eventTypeRepository.findAll().spliterator(),
                false)
                .count();
        if (count < 27) {
            EventType eventType[] = {
                    new EventType("Applied"),
                    new EventType("Phone Interview Scheduled"),
                    new EventType("Phone Interview"),
                    new EventType("Tour Scheduled"),
                    new EventType("Tour"),
                    new EventType("Problem Solving Challenge"),
                    new EventType("Command Line Review Assigned"),
                    new EventType("Command Line Review Completed"),
                    new EventType("Behavior Interview Scheduled"),
                    new EventType("Behavior Interview"),
                    new EventType("Pre-Work Assigned"),
                    new EventType("Pre-Work Assessment"),
                    new EventType("Rejected"),
                    new EventType("Acceptance Phone Call"),
                    new EventType("Verbal Accepted"),
                    new EventType("Verbal Rejected"),
                    new EventType("Do Not Contact"),
                    new EventType("Enrollment Email Send"),
                    new EventType("Deposit Payed"),
                    new EventType("Deposit Not Payed"),
                    new EventType("Financial Call"),
                    new EventType("Finance Arranged"),
                    new EventType("Finance Not Arranged"),
                    new EventType("Student"),
                    new EventType("No show"),
                    new EventType("Withdrawn"),
                    new EventType("Graduate")
            };
            eventTypeRepository.save(Arrays.asList(eventType));
        }
    }
}
