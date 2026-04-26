package br.com.fdrdev.repairtipsapi.service;

import java.util.List;

public interface BaseService<T> {

    List<T> getAll();
}