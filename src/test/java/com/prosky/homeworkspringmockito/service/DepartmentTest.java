package com.prosky.homeworkspringmockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentTest {
    @Mock
    EmployeeService employeeServiceMoc;
//    @InjectMocks
    DepartmentService departmentService;

        @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        departmentService = new DepartmentService(employeeServiceMoc);
    }
//    @BeforeEach
//    public void beforeEach() {
//        when(employeeServiceMoc.employeeData()).thenReturn(Map.of(
//                "Иванов11ИванИванович",
//                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
//                "Петров11ПетрПетрович",
//                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
//                "Сидоров11СидорСидорович",
//                new Employee("Сидоров11", "Сидор", "Сидорович", 3, 13000),
//                "Васильев11ВасилийИванович",
//                new Employee("Васильев11", "Василий", "Иванович", 4, 16000),
//                "Соловьев11СтепанВасильевич",
//                new Employee("Соловьев11", "Степан", "Васильевич", 2, 22000),
//                "Степанов11ГригорийМихайлович",
//                new Employee("Степанов11", "Григорий", "Михайлович", 5, 17000)
//        ));
//    }

//    public static Stream<Arguments> employeeMaxSalaryTes() {
//        return Stream.of(Arguments.of( 1,  11_000),
//                Arguments.of(2, 22_000),
//                Arguments.of(3, 13_000),
//                Arguments.of(4, 16_000),
//                Arguments.of(5, 17_000));
//    }

//    @ParameterizedTest
//    @MethodSource("employeeMaxSalaryTes")
//    public void employeeMaxSalaryTest(int department, int Arguments) {
//        Assertions.assertThat(departmentService.employeeMaxSalary(2)).isEqualTo(2);
//

    @Test
    void employeeMaxSalaryTest() {
        Map<String, Employee> employeeTest = Map.of(
                "Иванов11ИванИванович",
                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
                "Петров11ПетрПетрович",
                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
                "Сидоров11СидорСидорович",
                new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
        when(employeeServiceMoc.employeeData()).thenReturn(employeeTest);
//        assertNotNull(departmentService.employeeMaxSalary(7));
        assertEquals(employeeTest.get("Сидоров11СидорСидорович"), departmentService.employeeMaxSalary(1));
//        assertEquals(employeeTest.get("Сидоров11СидорСидорович"),  new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
//        assertEquals(new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000), departmentService.employeeMaxSalary(1));
    }
}





