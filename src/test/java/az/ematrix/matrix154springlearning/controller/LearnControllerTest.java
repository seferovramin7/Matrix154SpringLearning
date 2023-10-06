package az.ematrix.matrix154springlearning.controller;

import az.ematrix.matrix154springlearning.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LearnControllerTest {

    @Mock
    StudentsService cardProfileService;

    @InjectMocks
    StudentsController cardProfileController;

    @Test
    void getCardProfile() {

    }
}
