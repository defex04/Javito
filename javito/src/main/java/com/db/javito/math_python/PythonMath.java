package com.db.javito.math_python;

import javax.script.*;
import java.io.*;

public class PythonMath {

    public static String test = "Удалить этот костыль! ";

    public static void runPython() throws IOException, ScriptException, InterruptedException {

        String pythonScriptPath = "python/test.py";
        String[] cmd = {"python", pythonScriptPath};

        ProcessBuilder pb = new ProcessBuilder(cmd);

        pb.redirectError();

        Process p = pb.start();
        System.out.println("Process Started...");
        p.waitFor();

        String line;
        StringBuilder ret = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = in.readLine()) != null)
            ret.append(line);

        test += ret;

    }

}
