package ru.samsung.itschool.testbed;

import java.io.IOException;
import java.util.Arrays;

public class AndroidOutputStream extends java.io.OutputStream {

	private final int MAXLEN = 100; // MAXLEN OF OUTPUT TEXT

	private TextFlusher flusher;
	private byte[] text = new byte[MAXLEN];
	private int nBytes = 0;

	public AndroidOutputStream(TextFlusher flusher) {
		this.flusher = flusher;
	}

	@Override
	public void write(int oneByte) throws IOException {
		text[nBytes++] = (byte) oneByte;
		if (oneByte == '\n' || nBytes == MAXLEN) {
			this.flush();
		}
	}

	@Override
	public void flush() throws IOException {
		if (nBytes == 0) {
			return;
		}
		flusher.flush(new String(text, 0, nBytes));

		nBytes = 0;
		Arrays.fill(text, (byte) 0);
	}

}
