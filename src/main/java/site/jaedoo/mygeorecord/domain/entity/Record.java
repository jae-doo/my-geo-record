package site.jaedoo.mygeorecord.domain.entity;

import lombok.ToString;

import java.util.Map;

@ToString
public class Record {
    private double latitude;
    private double longitude;
    private Map<String, Field> data;
}
