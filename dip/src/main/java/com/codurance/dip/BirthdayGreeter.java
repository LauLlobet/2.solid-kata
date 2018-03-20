package com.codurance.dip;

import java.time.LocalDate;
import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private EmailSender sender;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock, EmailSender sender) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
        this.sender = sender;
    }

    public void sendGreetings() {
        employeeRepository.findEmployeesBornOn(monthDayOfToday())
                .stream()
                .map(employee -> emailFor(employee))
                .forEach(email -> sender.send(email));
    }

    private MonthDay monthDayOfToday() {
        LocalDate today = clock.today();
        return MonthDay.of(today.getMonth(), today.getDayOfMonth());
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}