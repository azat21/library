package kg.avenir.library.filterRequest.common;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class PageRequest {

    @Max(100)
    @Min(0)
    private Long limit;
    @Min(0)
    private Integer size;
    @Min(0)
    private Integer pageNumber;
    private String byName;

}
