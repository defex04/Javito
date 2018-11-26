package com.db.javito;

import com.db.javito.math_python.PythonMath;
import com.db.javito.service.interf.EurPredictService;
import com.db.javito.service.interf.GbpPredictService;
import com.db.javito.service.interf.UsdPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.db.javito.service.interf.MainService;

import javax.script.ScriptException;
import java.io.IOException;

@SpringBootApplication
public class JavitoApplication {

    @Autowired
    public static MainService mainService;
    @Autowired
    public static EurPredictService eurPredictService;
    @Autowired
    public static UsdPredictService usdPredictService;
    @Autowired
    public static GbpPredictService gbpPredictService;

    public static void main(String[] args) throws IOException, ScriptException, InterruptedException {

        ApplicationContext context = SpringApplication.run(JavitoApplication.class, args);
        System.out.println("Javito");

        mainService = context.getBean(MainService.class);
        eurPredictService = context.getBean(EurPredictService.class);
        usdPredictService = context.getBean(UsdPredictService.class);
        gbpPredictService = context.getBean(GbpPredictService.class);

        PythonMath.runPython();

    }
}