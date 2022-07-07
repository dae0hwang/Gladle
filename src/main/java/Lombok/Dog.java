package Lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor


public class Dog {

    private int weight;
    private int height;
    private String color;


}
