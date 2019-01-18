package com.master.employeeservice.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.master.employeeservice.domain.EmployeeEntity;
import com.master.employeeservice.model.EmployeeCmd;
import com.master.employeeservice.repository.EmployeeRepository;
import com.master.employeeservice.sheard.exception.ValidationException;
import com.master.employeeservice.sheard.validation.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeValidator(
            final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Component
    public class Add {

        public void validate(EmployeeCmd employeeCmd) {

            String personalIndentificationNumber = employeeCmd.getPersonalIdentificationNumber();
            final Optional<EmployeeEntity> employeeEntity = employeeRepository.findByPersonalIdentificationNumber(
                    personalIndentificationNumber);

            List<Error> errors = new ArrayList<>();

            if (employeeEntity.isPresent()) {
                errors.add(new Error("Employee with this personal indentification number already exists"));
            }

            Error error = DateValidator.dateInPast(employeeCmd.getDateOfBirth(), "Date of birth");
            if (error != null) {
                errors.add(error);
            }

            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }

        }
    }

    @Component
    public class Edit {

        public void validate(Long employeeId, EmployeeCmd employeeCmd) {

            String personalIndentificationNumber = employeeCmd.getPersonalIdentificationNumber();
            final Optional<EmployeeEntity> employee = employeeRepository.findByPersonalIdentificationNumber(
                    personalIndentificationNumber);

            List<Error> errors = new ArrayList<>();

            if (employee.isPresent()) {
                if (!employee.get().getId().equals(employeeId)) {
                    errors.add(new Error("Employee with this personal indentification number already exists"));
                }
            }

            EmployeeEntity employeeEntity = employeeRepository
                    .findById(employeeId)
                    .orElseThrow(() -> new ValidationException(new Error("Employee with that id does not exists")));
            ;

            Error error = DateValidator.dateInPast(employeeCmd.getDateOfBirth(), "Date of birth");

            if (error != null) {
                errors.add(error);
            }

            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }

        }
    }

    @Component
    public class Delete {

        public void validate(Long employeeId) {

            EmployeeEntity employeeEntity = employeeRepository
                    .findById(employeeId)
                    .orElseThrow(() -> new ValidationException(new Error("Employee with that id does not exists")));
        }
    }

}
