package org.example;

public interface CarList {
    Car get(int index);
    void  add(Car car);
    void add(Car car, int index);
    boolean remove(Car car);
    boolean removeAT(int index);
    int size();
    void clear();
}
