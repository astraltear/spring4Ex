package com.astraltear.callback;

public interface LineCallback<T> {
	T doSomethingWithLine(String line, T value);
}
