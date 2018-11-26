package com.db.javito.math_python;

import javax.script.*;
import java.io.*;

public class PythonMath {


    public static void runPython() throws IOException, ScriptException, InterruptedException {

        // set up the command and parameter
        String pythonScriptPath = "python/test.py";
        String[] cmd = {"python", pythonScriptPath};

        // create runtime to execute external command
        ProcessBuilder pb = new ProcessBuilder(cmd);

        // retrieve output from python script
        pb.redirectError();

        Process p = pb.start();
        System.out.println("Process Started...");
        p.waitFor();

        String line;
        StringBuilder ret = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = in.readLine()) != null)
            ret.append(line);

        System.out.println("value is : " + ret);

    }

}
