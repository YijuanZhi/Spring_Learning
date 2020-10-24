package com.antra.webclienttest.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    //converting from a json object, the property name has be to matched
    //so when original json object includes upper case name, this will not match
    //in this case, we can use the annotation: @JsonProperty("Name") to use "name" as the variable name

    private long id;
    private String quote;

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }

}
