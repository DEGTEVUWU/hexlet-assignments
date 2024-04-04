package exercise.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Setter
@Getter
public class GuestCreateDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    //    @Size(min = 11, max = 13)
    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$")
    private String clubCard;

    @FutureOrPresent
    private LocalDate cardValidUntil;
}
// END
