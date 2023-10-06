package az.ematrix.matrix154springlearning.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private String name;
    private String surname;

}
