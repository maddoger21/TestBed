package ru.samsung.itschool.testbed;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.os.Message;

public class AndroidInputStream extends java.io.InputStream {

	
		boolean valid = false;

	MainActivity activity;

	AndroidInputStream(MainActivity activity)
	{
		this.activity = activity;
	}


		@Override
		public int read() throws IOException  {
			
			if (!valid)
			{
				bytes = (getString()+"\n").getBytes();
				in = new ByteArrayInputStream(bytes);
			}
			
			int x = in.read();
			if (x == -1)
			{
				valid = false;
			}	
				
			else
			{
				valid = true;
			}
			return x;
		}
		


		 void process(String c) {
			try {
				readLineArrayList.put(c);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		private String getString() {
			 
			Message m = activity.hIn.obtainMessage(0, "");
			activity.hIn.sendMessage(m);

			try {
				String s = readLineArrayList.take();
				System.out.println(s);
				return s;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
	
		
		private byte[] bytes;
		private ByteArrayInputStream  in;
		private BlockingQueue<String> readLineArrayList =  new LinkedBlockingQueue<String>();
		
		
	}
