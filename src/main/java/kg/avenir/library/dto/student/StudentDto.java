package kg.avenir.library.dto.student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String universityId;
}
