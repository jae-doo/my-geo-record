package site.jaedoo.mygeorecord.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Row {
    private double latitude;
    private double longitude;
    private Map<String, Field> data;
}
