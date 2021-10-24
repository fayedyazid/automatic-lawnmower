package Mouvement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionOriente {
    int x;
    int y;
    Direction  d ;//enumeration type


}
