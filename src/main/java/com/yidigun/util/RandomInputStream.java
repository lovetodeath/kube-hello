package com.yidigun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RandomInputStream extends InputStream {

    private Random random;

    public RandomInputStream() {
        this(System.currentTimeMillis());
    }

    public RandomInputStream(long seed) {
        random = new Random(seed);
    }

    @Override
    public int read() throws IOException {
        return random.nextInt();
    }
}
