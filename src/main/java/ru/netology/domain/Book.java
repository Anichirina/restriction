package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String Author="";
    public Book(int id, String name, int price, String Author) {
        super(id, name, price);
        this.Author = Author;
    }


    public boolean matches(String search) {
        if (super.matches(search))
            return true;
        if (getAuthor().equalsIgnoreCase(search)) {
            return true;
        } else return false;
    }
}
