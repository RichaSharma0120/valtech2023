package com.valtech.training.day3;

import java.io.IOException;
import java.io.Reader;

public class Rot13Reader extends Reader{
	
	private Reader src;
	public Rot13Reader(Reader src) {
		this.src = src;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {	
		int bytesRead = src.read(cbuf,off,len);
		for (int i = 0; i < bytesRead; i++) {
			cbuf[off + i] = Rot13Helper.rotate(cbuf[off + i]);
		}
		return bytesRead;
	}

	@Override
	public void close() throws IOException {
		src.close();
		
	}

}
