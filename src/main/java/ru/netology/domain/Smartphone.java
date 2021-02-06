package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Smartphone extends Product {
    private String Manufacturer;
    public Smartphone(int id, String name, int price, String Manufacturer) {
        super(id, name, price);
        this.Manufacturer = Manufacturer;
    }

    public boolean matches(String search) {
        if (super.matches(search))
            return true;
        if (getManufacturer().equalsIgnoreCase(search)) {
            return true;
        } else return false;
    }
}
