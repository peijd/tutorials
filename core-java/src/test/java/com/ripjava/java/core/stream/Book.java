package com.ripjava.java.core.stream;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private  String name;
    private  int pages;

    public Book(String name, int pages){
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
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages);
    }

    @Override
    public int compareTo(Book o) {
        if (o == null) return  1;
        Book book = (Book) o;
        int result = name.compareTo(book.getName());
        if(result == 0){
            return  pages - ((Book) o).pages;
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
