package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.student.PaymentOption;
import org.springframework.data.repository.CrudRepository;

public interface PaymentOptionsRepository extends CrudRepository<PaymentOption, Long> {

}
