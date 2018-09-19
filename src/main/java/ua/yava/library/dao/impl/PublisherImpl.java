package ua.yava.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.yava.library.dao.PublisherDao;
import ua.yava.library.domain.Publisher;
import ua.yava.library.spring.repository.PublisherRepository;

import java.util.List;


@Service
@Transactional
public class PublisherImpl implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> search(String[] searchString) {
        return null;
    }

    @Override
    public Publisher get(long id) {

        return publisherRepository.getOne(id);
    }

    @Override
    public Publisher save(Publisher publisher) {

        publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public void delete(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public List<Publisher> getAll(Sort sort) {

        return publisherRepository.findAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {

        return publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection,
                                  String[] searchString) {
        return null;
    }
}
