package dev.litvin.impl;

import java.io.IOException;
import java.net.InetAddress;

public class CheckNetwork {
    public static void internet() throws IOException {
        InetAddress address = InetAddress.getByName("www.google.com"); // Сайт который будет пинговаться для проверки соединения
        boolean isReachable = address.isReachable(5000); // Проверка каждые 5 секунд
        if (isReachable) {
            System.out.println("success"); // Успешное соединение
        } else {
            System.out.println("error"); // Нет соединения
            System.exit(-1); // Выход
        }
    }
}
