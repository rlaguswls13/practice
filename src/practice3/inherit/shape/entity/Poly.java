package practice3.inherit.shape.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Poly extends Point {
    int degree;
    int sideLength;
}
