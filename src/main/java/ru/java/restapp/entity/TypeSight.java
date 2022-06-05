package ru.java.restapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.java.restapp.exception.ValidationException;

@Getter
@AllArgsConstructor
public enum TypeSight {

    BUILDING("BUILDING", 1),
    CONSTRUCTION("CONSTRUCTION", 2),
    MUSEUM("MUSEUM", 3),
    MONUMENT("MONUMENT", 4),
    RESERVE("RESERVE", 5);

    private final String value;
    private final int code;

    public static TypeSight fromValue(String param) throws ValidationException {

            TypeSight[] values = TypeSight.values();
            for(TypeSight value: values){
                if(value.getValue().equals(param)){
                    return value;
                }
            }
            throw new ValidationException("TypeSight not found");
    }
}
