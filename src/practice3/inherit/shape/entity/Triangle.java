package practice3.inherit.shape.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Triangle extends Point {
    private int width;
    private int height;
}
