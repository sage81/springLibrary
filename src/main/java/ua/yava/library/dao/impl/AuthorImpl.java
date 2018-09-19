package ua.yava.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.yava.library.dao.AuthorDao;
import ua.yava.library.domain.Author;
import ua.yava.library.spring.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional
public class AuthorImpl implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    @Override
    public List<Author> search(String[] searchString) {

        return null;
    }

    @Override
    public Author get(long id) {

        return authorRepository.getOne(id);
    }

    @Override
    public Author save(Author author) {

        authorRepository.save(author);
        return author;
    }

    @Override
    public void delete(Author author) {

        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAll(Sort sort) {

        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {

        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection,
                               String[] searchString) {
        return null;
    }
}
