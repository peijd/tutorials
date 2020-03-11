package com.ripjava.java.core.stream;

import java.util.Objects;

public class NewBook implements Comparable<NewBook>{
    private  String name;
    private  int pages;
    private  int price;

    public NewBook(String name, int pages){
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewBook book = (NewBook) o;
        return pages == book.pages &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages);
    }

    @Override
    public int compareTo(NewBook o) {
        if (o == null) return  1;
        NewBook book = (NewBook) o;
        int result = name.compareTo(book.getName());
        if(result == 0){
            return  pages - ((NewBook) o).pages;
        } else {
            return result;
        }
    }

    public NewBook(String name, int pages, int price) {
        this.name = name;
        this.pages = pages;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NewBook{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
