package snack.entity;

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
public class Snack {
    private String kind;
    private String name;
    private String flavor;
    private int numOf;
    private int price;

    public String information() {
        return String.format("%s(%s - %s) %d개 %d원", kind, name, flavor, numOf, price);
    }
}
