package az.ematrix.matrix154springlearning.controller;


import static org.mockito.Mockito.when;

import az.ematrix.matrix154springlearning.dto.PersonDto;
import az.ematrix.matrix154springlearning.service.StudentsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {


    @Mock
    StudentsService service;


    @InjectMocks
    StudentsController controller;


    @Test
    void getMethodSuccessTest() {
        PersonDto dto = PersonDto.builder().name("Kamil").build();

        when(service.get(1L)).thenReturn(dto);

        PersonDto personDto = controller.get(1L);

        Assertions.assertEquals("Kamil", personDto.getName());
    }

    @Test
    void testDeleteMethod1Case() {
        HttpStatus s = controller.delete(1L);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, s);
    }

    @Test
    void testDeleteMethodElseCase() {
        HttpStatus s = controller.delete(2L);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, s);
    }
}
