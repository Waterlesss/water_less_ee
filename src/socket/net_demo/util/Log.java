package socket.net_demo.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Waterless
 * @Date: 2022/07/16/10:36
 * @Description:
 */
public class Log {
    public static void println(Object o) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String now = formatter.format(localDateTime);

        String message = now + ": " + (o == null ? "null" : o.toString());

        System.out.println(message);
    }

    public static void main(String[] args) {
        println(1);
    }
}
