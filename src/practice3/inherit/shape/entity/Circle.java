package practice3.inherit.shape.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import practice3.inherit.shape.constant.MarkMessage;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Circle extends Point {

    private int radius;

    @Override
    public String toString() {
        return this.getX() + MarkMessage.SPLIT_MARK + this.getY() + MarkMessage.SPLIT_MARK + this.getRadius();
    }
}
