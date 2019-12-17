package com.energizeglobal.internship;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOExample {
    private static String FILE_PATH = "C:\\Users\\armanar\\IdeaProjects\\java-io\\new.txt";
    public static void main(String[] args) throws IOException {
        try (final FileOutputStream fileOutputStream =
                     new FileOutputStream(FILE_PATH);
             final FileChannel channel = fileOutputStream.getChannel();) {
            final ByteBuffer byteBuffer = ByteBuffer.allocate(5000);
            for (int x = 0; x < 5000; x++) {
                byteBuffer.put((byte) x);
            }
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                channel.write(byteBuffer);
            }
            channel.force(false);
        }

        readFromFile(FILE_PATH);
    }

    public static void readFromFile(String filePath) throws IOException {
        try (final FileChannel srcChannel = new FileInputStream(filePath).getChannel();
             final FileChannel destChannel = new FileOutputStream(filePath + ".txt").getChannel()) {
            final ByteBuffer byteBuffer = ByteBuffer.allocate(20 * 1024);
            while (srcChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    destChannel.write(byteBuffer);
                }
                byteBuffer.clear();
            }
        }
    }
}
