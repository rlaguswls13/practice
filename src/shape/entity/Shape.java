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
    private int type;
    private double height;
    private double width;

    @Builder.Default
    private String color = "white";

    public String information() {
        return height + " " + width + " " + color;
    }
}
