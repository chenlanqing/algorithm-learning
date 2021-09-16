package com.algorithm.interview.wordcount;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

/**
 * @author QingFan 2021-06-05
 * @version 1.0.0
 */
public class BufferGenerateCode {

    @Test
    public void gen() throws Exception {
        Random random = new Random();

        int bufferSize = 4 * 1024;
        String fileName = "word";

        BufferedOutputStream buffered = new BufferedOutputStream(new FileOutputStream(fileName), bufferSize);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10_0000_0000; i++) {
            for (int j = 0; j < 5; j++) {
                buffered.write(97 + random.nextInt(5));
            }
            buffered.write(' ');
        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void read_test() throws Exception {
        String fileName = "word";

        FileInputStream inputStream = new FileInputStream(fileName);

        long start = System.currentTimeMillis();

        int b = 0;
        while ((b = inputStream.read()) != -1) {

        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
        inputStream.close();
    }

    @Test
    public void read_test_withBuffer() throws Exception {
        String fileName = "word";

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));

        long start = System.currentTimeMillis();

        int b = 0;
        byte[] len = new byte[1024 * 8];
        while ((b = inputStream.read(len)) != -1) {

        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
        inputStream.close();
    }

    @Test
    public void read_test_nio() throws Exception {
        String fileName = "word";

        FileChannel channel = new FileInputStream(fileName).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);

        long start = System.currentTimeMillis();

        while (channel.read(buffer) != -1) {
            buffer.flip();
            buffer.clear();
        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void test_charset() throws Exception {
        String raw = "长坂桥头杀气生，横枪立马眼圆睁。一声好似轰雷震，独退曹家百万兵。";
        Charset charset = StandardCharsets.UTF_8;

//        byte[] bytes = charset.encode(raw).array();
        byte[] bytes = raw.getBytes(charset);
        byte[] bytes2 = Arrays.copyOfRange(bytes, 0, 11);

        ByteBuffer bbuf = ByteBuffer.allocate(12);
        CharBuffer cbuf = CharBuffer.allocate(12);
        bbuf.put(bytes2);
        bbuf.flip();

        // decode 这里如果不能解析就不去读
        charset.newDecoder().decode(bbuf, cbuf, true);
        cbuf.flip();

        char[] tmp = new char[cbuf.length()];
        if (cbuf.hasRemaining()) {
            cbuf.get(tmp);
            System.out.println("here:" + new String(tmp));
        }

        System.out.format("limit: %d\t position: %d", bbuf.limit(), bbuf.position());
        System.out.println();
        System.out.println("==========================");
        // 通过上面可以看到bbuf还有两个字节没有读取，然后重新再读取 bytes 剩下的字符串
        byte[] bytes3 = Arrays.copyOfRange(bytes, bbuf.position(), bytes.length);
        ByteBuffer bbuf1 = ByteBuffer.allocate(bytes.length - bbuf.position());
        CharBuffer cbuf1 = CharBuffer.allocate(bytes.length - bbuf.position());

        bbuf1.put(bytes3);
        bbuf1.flip();

        // decode 这里如果不能解析就不去读
        charset.newDecoder().decode(bbuf1, cbuf1, true);
        cbuf1.flip();

        char[] tmp1 = new char[cbuf1.length()];
        if (cbuf1.hasRemaining()) {
            cbuf1.get(tmp1);
            System.out.println("here:" + new String(tmp1));
        }
    }
}
