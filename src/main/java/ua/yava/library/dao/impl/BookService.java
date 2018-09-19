package ua.yava.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.yava.library.dao.BookDao;
import ua.yava.library.domain.Book;
import ua.yava.library.spring.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService implements BookDao{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC,
                "viewCount")));
    }

    @Override
    public byte[] getContent(long id) {
        return new byte[0];
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField,
                                  Sort.Direction sortDirection, long genreId) {

        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize,
                                            Sort.by(sortDirection, sortField)));
    }

    @Override
    public void updateViewCount(Book book) {

        book.setViewCount(book.getViewCount() + 1);
        bookRepository.save(book);
    }

    @Override
    public void vote(Book book, long rating) {

        book.setTotalRating(rating);
        book.setTotalVoteCount(book.getTotalVoteCount() + 1);
        book.setAvgRating((int) (book.getTotalRating() / book.getTotalVoteCount()));

        bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> search(String[] searchString) {
        return null;
    }

    @Override
    public Book get(long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);

        if (book.getContent() != null) {
            bookRepository.updateContent(book.getContent(), book.getId());
        }

        return book;
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField,
                             Sort.Direction sortDirection) {

        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize,
                Sort.by(sortDirection, sortField)));

    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField,
                             Sort.Direction sortDirection, String[] searchString) {
        return null;
    }
}
