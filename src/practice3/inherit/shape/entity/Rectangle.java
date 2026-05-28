package practice3.inherit.shape.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import practice3.inherit.shape.constant.MarkMessage;

@Getter
@SuperBuilder
@NoArgsConstructor
public class Rectangle extends Point {

    private int width;
    private int height;

    @Override
    public String toString() {
        return this.getX()
                + MarkMessage.SPLIT_MARK + this.getY()
                + MarkMessage.SPLIT_MARK + this.getWidth()
                + MarkMessage.SPLIT_MARK + this.getHeight();
    }
}
