package com.andy.study.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

interface FileCopyRunner {
    void copyFile(File source, File target);
}

/**
 * @time: 2020/10/28 十月 22:29
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class FileCopyTest {

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileCopyRunner noBufferStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileInputStream in = null;
                FileOutputStream out = null;
                try {
                    in = new FileInputStream(source);
                    out = new FileOutputStream(target);
                    int result = 0;
                    while ((result = in.read()) != -1) {
                        out.write(result);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(in);
                    close(out);
                }
            }
        };

        FileCopyRunner bufferStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                BufferedInputStream in = null;
                BufferedOutputStream out = null;
                try {
                    in = new BufferedInputStream(new FileInputStream(source));
                    out = new BufferedOutputStream(new FileOutputStream(target));
                    byte[] buffer = new byte[1024];
                    int result = 0;
                    while ((result = in.read(buffer)) != -1) {
                        out.write(buffer, 0, result);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(in);
                    close(out);
                }
            }
        };


        FileCopyRunner nioBufferCopy = new FileCopyRunner() {

            @Override
            public void copyFile(File source, File target) {
                FileChannel cin = null;
                FileChannel cout = null;

                try {
                    cin = new FileInputStream(source).getChannel();
                    cout = new FileOutputStream(target).getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int read = 0;
                    while ((read = cin.read(buffer)) != -1) {
                        buffer.flip();//由读模式转为写模式
                        while (buffer.hasRemaining()) {
                            cout.write(buffer);
                        }
                        buffer.clear();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(cin);
                    close(cout);
                }

            }
        };


        FileCopyRunner nioTransferCopy = new FileCopyRunner() {

            @Override
            public void copyFile(File source, File target) {
                FileChannel cin = null;
                FileChannel cout = null;

                try {
                    cin = new FileInputStream(source).getChannel();
                    cout = new FileOutputStream(target).getChannel();
                    long trasferd = 0L;
                    long size = cin.size();
                    while (trasferd != size) {
                        trasferd += cin.transferTo(0, size, cout);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(cin);
                    close(cout);
                }

            }
        };
    }

}
