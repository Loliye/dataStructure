package com.mikufans.test;

import java.util.List;

public interface CRUD<T>
{
    void addObject(T t);

    List<T> getAllObject();
}
