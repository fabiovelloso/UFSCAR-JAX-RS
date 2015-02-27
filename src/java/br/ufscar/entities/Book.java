/**
 * Copyright 2015 Fabio Velloso
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.ufscar.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabio
 */
@XmlRootElement

public class Book {

    private int id;
    private String name;
    private String author;
    private String ISBN;
    private String ISBN13;

    public Book() {
    }

    public Book(int id, String name, String author, String ISBN, String ISBN13) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.ISBN13 = ISBN13;

    }

    public Book get(int i) {

        switch (i) {
            case 1:
                return new Book(1, "Java the Good Parts", "Jim Waldo", "0-596-80373-7", "978-0-596-80373-5");
            case 2:
                return new Book(2, "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "0-201-63361-2", "978-0-201-63361-0");
        }
        return null;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the ISBN13
     */
    public String getISBN13() {
        return ISBN13;
    }

    /**
     * @param ISBN13 the ISBN13 to set
     */
    public void setISBN13(String ISBN13) {
        this.ISBN13 = ISBN13;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book = book.get(2);
        System.out.println(book.getAuthor());
    }

}
