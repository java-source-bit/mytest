package cn.yizhangwo.test;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularTest {
    public static void main(String[] args) {
        String s = "《.*》";
        String s1 = "《是不是这样的夜晚你才会这样的想起我》 --吴宗宪 《最好的时代也是最坏的时代我们看不到过去也看不到未来》--钣机  《那些你们喜欢32313133353236313431303231363533e59b9ee7ad9431333365633861的不喜欢的我都喜欢的女孩》==123";
        //String s1 = "《是不是这样的夜晚你才会这样的想起我》";
        boolean matches = s1.matches(s);
        System.out.println(matches);
        String[] split = s1.split(s);
        System.out.println(Arrays.toString(split));
        //
        Pattern compile = Pattern.compile(s);
        String[] split1 = compile.split(s1);
        System.out.println(Arrays.toString(split1));
    }

    @Test
    public void fun03() throws IOException {
        //《是不是这样的夜晚你才会这样的想起我》--吴宗宪
        StringBuffer buffer = new StringBuffer(Files.readString(Paths.get("d:/歌曲名称.txt"), StandardCharsets.UTF_8));
        String regex = "《.+》";
        Pattern pattern = Pattern.compile(regex);
        //List<String> collect = pattern.matcher(buffer).results().map(result -> result.group()).collect(Collectors.toList());
        List<String> collect = pattern.matcher(buffer).results().map(result -> result.group()).map(s -> s.replace("《", "")).map(s -> s.replace("》", "")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void fun02() throws IOException {
        //《是不是这样的夜晚你才会这样的想起我》--吴宗宪
        StringBuffer buffer = new StringBuffer(Files.readString(Paths.get("d:/歌曲名称.txt"), StandardCharsets.UTF_8));
        String regex = "《.+》";
       /* String[] split = buffer.toString().split(regex);
        System.out.println(Arrays.toString(split));*/
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(buffer);
        while (matcher.find()) {
            String s2 = Optional.of(matcher.group()).map(s -> s.replace("《", "")).map(s -> s.replace("》", "")).orElse("");
            System.out.println(s2);
        }

    }

    @Test
    public void fun01() throws IOException {
        Scanner scanner = new Scanner(Paths.get("d:/歌曲名称.txt"), StandardCharsets.UTF_8);
      /*  scanner.tokens().forEach(System.out::println);
        System.out.println(scanner);
*/
        String s = scanner.toString();
        System.out.println(s);
    }
}
