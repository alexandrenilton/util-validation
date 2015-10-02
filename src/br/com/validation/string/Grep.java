package br.com.validation.string;

/*
grep.java

Searches for patterns in input files. This is obsolete. Use the
grep that comes with gnu.regexp instead.

by Patrick C. Beard.
*/


import java.io.*;
import java.util.*;


public class Grep {
	private static void grep(String pattern, InputStream in) throws IOException {
		PrintStream out = System.out;
		BufferedReader data = new BufferedReader(new InputStreamReader(in));
		String line = data.readLine();
		while (line != null) {
			if (line.indexOf(pattern) >= 0)
				out.println(line);
			line = data.readLine();
		}
	}

	private static void usage() {
		System.err.println("usage: grep pattern file1 file2 ..");
	}

	public static void main(String[] args) {
		int length = args.length;
		if (length == 0) {
			usage();
			return;
		}
	
		String pattern = args[0];
	
		try {
			if (length > 1) {
				for (int i = 1; i < length; i++) {
					InputStream in = new FileInputStream(args[i]);
					grep(pattern, in);
					in.close();
				}
			} else {
				grep(pattern, System.in);
			}
		} catch (IOException ioe) {
		
		}
	}
}

