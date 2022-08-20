package com;

import javax.jws.WebService;

@WebService
public class Cal {
	public int add(int a, int b) {
		return a+b;
	}
}
