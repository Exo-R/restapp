package ru.java.restapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeSight {

    BUILDING("BUILDING", 1),
    CONSTRUCTION("CONSTRUCTION", 2),
    MUSEUM("MUSEUM", 3),
    MONUMENT("MONUMENT", 4),
    RESERVE("RESERVE", 5);

    private final String code;
    private final int value;

    public static TypeSight fromValue(String par) throws Exception {

            TypeSight[] values = TypeSight.values();
            for(TypeSight value: values){

                if(value.getCode().equals(par)){
                    return value;
                }
            }
            throw new Exception("TypeSight not found");
    }
}
