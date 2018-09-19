package ua.yava.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ua.yava.library.domain.Book;

import java.util.List;

public interface BookDao extends GeneralDao<Book> {
    List<Book> findTopBooks(int limit);

    byte[] getContent(long id);

    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField,
                           Sort.Direction sortDirection, long genreId);

    void updateViewCount(Book book);

    void vote(Book book, long rating);
}
