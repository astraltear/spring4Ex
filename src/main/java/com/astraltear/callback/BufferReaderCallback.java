package com.astraltear.callback;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferReaderCallback {
	Integer doSomthingWithReader(BufferedReader br) throws NumberFormatException, IOException;
}
