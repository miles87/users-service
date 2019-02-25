package pl.betse.beontime.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseMessage {

    private int statCode;
    private HttpStatus stat;
    private String message;

    public CustomResponseMessage(HttpStatus stat, String message) {
        this.statCode = stat.value();
        this.stat = stat;
        this.message = message;
    }

}
