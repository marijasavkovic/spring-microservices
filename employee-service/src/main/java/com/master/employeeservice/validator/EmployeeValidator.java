package com.master.employeeservice.validator;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

//    private final EmployeeRepository employeeRepository;
//    private final CourseRepository courseRepository;
//
//    @Autowired
//    public EmployeeValidator(
//        final EmployeeRepository employeeRepository, final CourseRepository courseRepository)
//    {
//        this.employeeRepository = employeeRepository;
//        this.courseRepository = courseRepository;
//    }
//
//    @Component
//    public class Add {
//
//        public void validate(EmployeeCmd employeeCmd) {
//
//            String personalIndentificationNumber = employeeCmd.getPersonalIdentificationNumber();
//            final Optional<EmployeeEntity> employeeEntity = employeeRepository.findByPersonalIdentificationNumber(
//                personalIndentificationNumber);
//
//            List<Error> errors = new ArrayList<>();
//
//            if (employeeEntity.isPresent()) {
//                errors.add(new Error("Employee with this personal indentification number already exists"));
//            }
//
//            Error error = DateValidator.dateInPast(employeeCmd.getDateOfBirth(), "Date of birth");
//            if (error != null) {
//                errors.add(error);
//            }
//
//            if (!errors.isEmpty()) {
//                throw new ValidationException(errors);
//            }
//
//        }
//    }
//
//    @Component
//    public class Edit {
//
//        public void validate(Long employeeId, EmployeeCmd employeeCmd) {
//
//            String personalIndentificationNumber = employeeCmd.getPersonalIdentificationNumber();
//            final Optional<EmployeeEntity> employee = employeeRepository.findByPersonalIdentificationNumber(
//                personalIndentificationNumber);
//
//            List<Error> errors = new ArrayList<>();
//
//            if (employee.isPresent()) {
//                if (!employee.get().getId().equals(employeeId)) {
//                    errors.add(new Error("Employee with this personal indentification number already exists"));
//                }
//            }
//
//            EmployeeEntity employeeEntity = employeeRepository
//                .findById(employeeId)
//                .orElseThrow(() -> new ValidationException(new Error("Employee with that id does not exists")));
//            ;
//
//            Error error = DateValidator.dateInPast(employeeCmd.getDateOfBirth(), "Date of birth");
//
//            if (error != null) {
//                errors.add(error);
//            }
//
//            if (!errors.isEmpty()) {
//                throw new ValidationException(errors);
//            }
//
//        }
//    }
//
//    @Component
//    public class Delete {
//
//        public void validate(Long employeeId) {
//
//            EmployeeEntity employeeEntity = employeeRepository
//                .findById(employeeId)
//                .orElseThrow(() -> new ValidationException(new Error("Employee with that id does not exists")));
//
//            List<CourseEntity> courseEntities = courseRepository.findByEmployeeId(employeeId);
//
//            if (!courseEntities.isEmpty()) {
//                throw new ValidationException(
//                    new Error("Employee can not be deleted, because he is a lecturer on the subject!"));
//            }
//        }
//
//    }

}
