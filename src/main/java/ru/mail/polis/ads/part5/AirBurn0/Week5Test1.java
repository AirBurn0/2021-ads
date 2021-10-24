package ru.mail.polis.ads.part5.AirBurn0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

//https://www.e-olymp.com/ru/submissions/9638825
public final class Week5Test1 {
    private Week5Test1() {
        // Should not be instantiated
    }
    
    private final static float DELTA = 1 + 1.0e-6f;

    private static void solve(final FastScanner in, final PrintWriter out) {
        final float c = in.nextFloat();
        float min = 0.5248886f;
        float max = (float) Math.sqrt(c);
        float x;

        float sq;
        while(max / min > DELTA) {
            x = (min + max) / 2.0f;
            sq = c - x * x; 
            if(sq * sq < x) {
                max = x;
            } else {
                min = x;
            }
        }
        out.println(max);
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }
    }

    public static PrintWriter createPrintWriterForLocalTests() {
        return new PrintWriter(System.out, true);
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
