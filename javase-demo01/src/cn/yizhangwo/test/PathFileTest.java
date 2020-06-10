package cn.yizhangwo.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import java.util.stream.Stream;

public class PathFileTest {
    @Test
    public void fun07() throws IOException {

    }

    /**
     * 复制文件夹
     *
     * @throws IOException
     */
    @Test
    public void fun06() throws IOException {
        Path path = Paths.get("D:\\英雄时刻\\13691413");
        Path deletePath = Paths.get("D:\\英雄时刻\\13691413\\copy");
        boolean b = Files.deleteIfExists(deletePath);
        if (Files.exists(path)) {
            Files.walk(path).forEach(p -> {
                try {
                    Path copyTarget = Paths.get("D:\\英雄时刻\\13691413\\copy");
                    if (!Files.exists(copyTarget)) {
                        copyTarget = Files.createDirectories(copyTarget);
                    }

                    Path copy = Files.copy(p, Paths.get(copyTarget.toString(),p.relativize(copyTarget).toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void fun05() throws IOException {
        Path path = Paths.get("D:\\英雄时刻\\13691413");
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path, "*.avi")) {
            paths.forEach(System.out::println);
        }
        System.out.println("----------------------------------");
        // Files.walkFileTree()

    }

    @Test
    public void fun04() throws IOException {
        Path path = Paths.get("D:\\英雄时刻\\13691413");
        try (Stream<Path> list = Files.list(path)) {
            list.forEach(System.out::println);
        }
        System.out.println("------------------------------------------");
        try (Stream<Path> walk = Files.walk(path, 1)) {
            walk.forEach(System.out::println);
        }
    }

    @Test
    public void fun03() throws IOException {
        Path path = Paths.get("d:/noi/files");
        if (!Files.exists(path)) {
            Path directories = Files.createDirectories(path);
        }
        Path filePath = Paths.get(path.toString(), "files.txt");
        if (!Files.exists(filePath)) {
            Path newFile = Files.createFile(filePath);
        }
        Path write = Files.write(filePath, "new io测试字符\r\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

    @Test
    public void fun02() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("D:\\歌曲名称.txt"));
        Path write = Files.write(Paths.get("D:\\歌曲名称02.txt"), list, StandardCharsets.UTF_8);
    /*    Files.isHidden();
        Files.isRegularFile();
        Files.isExecutable()
        Files.isHidden()*/

    }

    @Test
    public void fun01() {
        Path path = Paths.get("D:\\英雄时刻\\13691413");
        Path other = Paths.get("D:\\英雄时刻\\13691413\\ioDemo");

        Path fileName = path.getFileName();
        System.out.println(fileName);
        boolean absolute = path.isAbsolute();
        Path normalize = path.normalize();
        Path resolve = path.resolve("path.text");
        Path resolveSibling = path.resolveSibling("path2.text");

        Path relativize = path.relativize(other);
    }
}
