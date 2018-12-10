package com.db.javito.controller;

import com.db.javito.math_python.PythonMath;
import com.db.javito.model.Main;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;

import static com.db.javito.JavitoApplication.mainService;

@RestController
@EnableAutoConfiguration
public class MainController {

    @GetMapping("/hello")
    @CrossOrigin(origins = "http://localhost:3000/")
    public JSONObject greet() throws ParseException, JSONException {
        String fromDate = "2018/11/25 19";
        String toDate = "2018/11/26 15";
        return mainService.getDataPeriod(fromDate, toDate);
        //return PythonMath.test;
    }

    @RequestMapping(value="user", method = RequestMethod.GET)
    public @ResponseBody String getitem(@RequestParam("data") String itemid){
        String i = itemid;
        return i;
    }

    @RequestMapping(value="chart", method = RequestMethod.GET)
    public @ResponseBody JSONObject sendDataForGraph (@RequestParam("fromDate") String fromDate,
                                       @RequestParam("toDate") String toDate,
                                       @RequestParam("currency") String currency) throws ParseException, JSONException {

        return mainService.getDataPeriod(fromDate, toDate);
    }
}
