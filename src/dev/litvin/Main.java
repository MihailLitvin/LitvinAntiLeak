package dev.litvin;

import dev.litvin.impl.CheckHWID;
import dev.litvin.impl.CheckNetwork;
import java.io.IOException;

/**
 * @author litvin 
 * @codded in 2024 year
 **/

public class Main {
    public static String url = "PASTEBIN PROTECTION YRAA $$$$";
    public static void checking() throws IOException {
        CheckNetwork.internet();
        CheckHWID.check();
    }
}