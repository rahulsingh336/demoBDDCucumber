/*
package com.example.demoBDDCucumber;

import com.example.demoBDDCucumber.model.Book;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

public class BookTableTransformer implements TableTransformer<Book> {

    @Override
    public Book transform(DataTable table) throws Throwable {

        Book catalog = new Book();

        table.cells()
                .stream()
                .skip(1)        // Skip header row
                .map(fields -> new Book(fields.get(0), fields.get(1)))
                .forEach(catalog::addBook);

        return catalog;
    }
}
}*/
