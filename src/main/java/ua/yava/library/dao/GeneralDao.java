package ua.yava.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDao<T> {
    List<T> getAll();

    List<T> search(String[] searchString);

    T get(long id);
    T save(T obj);
    void delete(T object);

    List<T> getAll(Sort sort);

    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String[] searchString);

}
