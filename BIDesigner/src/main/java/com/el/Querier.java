package com.el;

import java.util.Iterator;

public interface Querier extends Iterator<String>{
	int start();
	int end();
	void reset(String exp, int start);
}
