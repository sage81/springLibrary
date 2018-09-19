package ua.yava.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.yava.library.dao.GenreDao;
import ua.yava.library.domain.Genre;
import ua.yava.library.spring.repository.GenreRepository;

import java.util.List;

@Service
@Transactional
public class GenreImpl implements GenreDao {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> search(String[] searchString) {

        return null;
    }

    @Override
    public Genre get(long id) {

        return genreRepository.getOne(id);
    }

    @Override
    public Genre save(Genre genre) {

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public void delete(Genre genre) {

        genreRepository.delete(genre);
    }

    @Override
    public List<Genre> getAll(Sort sort) {

        return genreRepository.findAll(sort);
    }

    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {

        return genreRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String[] searchString) {
        return null;
    }
}
