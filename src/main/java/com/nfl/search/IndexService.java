package com.nfl.search;

public interface IndexService<T extends Searchable> {
	void add(T obj);
}

