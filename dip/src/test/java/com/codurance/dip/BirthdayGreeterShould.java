package com.codurance.dip;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Collections;

import static com.codurance.dip.EmployeeBuilder.anEmployee;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreeterShould {
    private static final int CURRENT_MONTH = 7;
    private static final int CURRENT_DAY_OF_MONTH = 9;
    private static final LocalDate TODAY = LocalDate.of(2017, CURRENT_MONTH, CURRENT_DAY_OF_MONTH);


    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private Clock clock;

    private EmailSender emailSender = new EmailSender();

    private BirthdayGreeter birthdayGreeter;

    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        birthdayGreeter = new BirthdayGreeter(employeeRepository, clock, emailSender);
    }

    @Test
    public void should_send_greeting_email_to_employee() {
        System.setOut(new PrintStream(consoleContent));
        given(clock.today()).willReturn(TODAY);
        Employee employee = anEmployee().build();
        given(employeeRepository.findEmployeesBornOn(MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH))).willReturn(Collections.singletonList(employee));

        birthdayGreeter.sendGreetings();

        String actual = consoleContent.toString();
        assertThat(actual)
                .isEqualTo("To:" + employee.getEmail() + ", Subject: Happy birthday!, Message: Happy birthday, dear " + employee.getFirstName()+"!");

    }



}