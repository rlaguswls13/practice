package shape.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shape {
    private int numSides;
    private double sideLength;

    @Builder.Default
    private String color = "white";

    public String information() {
        return numSides + " " + sideLength + " " + color;
    }
}
