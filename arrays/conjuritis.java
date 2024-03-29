package arrays;

import java.io.IOException;
import java.io.InputStream;

public class conjuritis {

    public static void main(String[] args) {

        final FastIO r = new FastIO(System.in);
        int[] hechizos = new int[200_000];
        long suma, target;
        int c, left, right;

        while (true) {

            c = r.readInt(); if (c == 0) break;

            suma = 0L;
            for (int i = 0; i < c; i++) {
                hechizos[i] = r.readInt(); suma += hechizos[i];
            }

            target = suma - r.readLong();

            left = 0; right = c - 1;
            while (hechizos[left] + hechizos[right] != target)
                if (hechizos[left] + hechizos[right] > target) right--;
                else left++;

            System.out.println(hechizos[left] + " " + hechizos[right]);
        }

    }

}

class FastIO {
    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public FastIO(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String readString() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c))
            c = read();
        do {
            stringBuilder.append((char) c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

}
