package com.tianshouzhi.aop.spring;

public class CrudServiceImpl implements CrudService {
    @Override
    public void add() {
        System.out.println("add");
    }


    @Override
    public void search() {
        System.out.println("search");
    }


    @Override
    public void update() {
        System.out.println("update");
    }


    @Override
    public void del() {
        System.out.println("del");
    }
}
