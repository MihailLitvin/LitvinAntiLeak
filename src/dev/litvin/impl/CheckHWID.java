package dev.litvin.impl;

import dev.litvin.Main;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckHWID {
    private static final String PASTEBIN_URL = Main.url; // Ссылка на пастбин
    public static void check() {
        String hwid = getHWID();
        boolean isHWIDValid = checkHWID(hwid);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(hwid);
        clipboard.setContents(stringSelection, null);
        if (isHWIDValid) {
            System.out.println("hwid checked success");
        } else {
            System.out.println("hwid isnt in list");
            System.exit(-1);
        }
    }

    private static String getHWID() {
        String hwid = "";
        try {
            Process process = Runtime.getRuntime().exec("wmic csproduct get uuid"); // Получаем хвид пк
            process.getOutputStream().close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                hwid += line.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hwid;
    }

    private static boolean checkHWID(String hwid) {
        try {
            URL url = new URL(PASTEBIN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains(hwid)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
