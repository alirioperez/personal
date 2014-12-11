package com.seabware.grocery.domain.model.enums;


public enum UnitOfMeasureEnum
{
    UNIT("unit(s)"),
    KILOS("kilo(s)"),
    GRAMS("grams"),
    BOX("box(es)");

    private String value;

    private UnitOfMeasureEnum(String value)
    {
        this.value = value;
    }
}
