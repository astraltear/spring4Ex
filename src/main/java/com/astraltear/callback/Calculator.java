package com.astraltear.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public Integer fileReadTemplate(String filepath, BufferReaderCallback callback) throws NumberFormatException, IOException {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filepath));

			int ret = callback.doSomthingWithReader(br);
			return ret;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}

	public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws Exception {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filepath));

			T res = initVal;
			String line = null;
			
			while ((line = br.readLine()) != null) {
				res = callback.doSomethingWithLine(line, res);
			}
			
			return res;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}

	public Integer calcSum(String filepath) throws Exception {
		LineCallback<Integer> sumCallback = new LineCallback<Integer>() {
			
			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}

		};
		
		return lineReadTemplate(filepath, sumCallback, 0);
		
		/*BufferReaderCallback sumCallback = new BufferReaderCallback() {

			@Override
			public Integer doSomthingWithReader(BufferedReader br) throws NumberFormatException, IOException {
				Integer sum = 0;
				String line = null;

				while ((line = br.readLine()) != null) {
					sum += Integer.valueOf(line);
				}
				return sum;
			}
		};

		return fileReadTemplate(filepath, sumCallback);*/
	}

	public Integer calcMultiply(String filepath) throws Exception {
		
		LineCallback<Integer> multiplyCallback = new LineCallback<Integer>() {
			
			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(filepath, multiplyCallback, 1);
		
		/*BufferReaderCallback sumCallback = new BufferReaderCallback() {

			@Override
			public Integer doSomthingWithReader(BufferedReader br) throws NumberFormatException, IOException {
				Integer sum = 1;
				String line = null;

				while ((line = br.readLine()) != null) {
					sum *= Integer.valueOf(line);
				}
				return sum;
			}
		};

		return fileReadTemplate(filepath, sumCallback);*/
	}
	
	public String concat(String filepath) throws Exception {
		LineCallback<String> conCallback = new LineCallback<String>() {
			
			@Override
			public String doSomethingWithLine(String line, String value) {
				return value + line;
			}
		};
		
		return lineReadTemplate(filepath, conCallback, "");
	}
}
