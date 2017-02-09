package com.infinitus.saas.controller;

/**
 * Created by administrator on 17/2/7.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping({"/api/pt"})
public class PerformanceTestRestController
{

    @RequestMapping(value={"/cpu"}, method={RequestMethod.GET})
    public String list(String q)
    {
        return "pt_cpu";
    }


    @RequestMapping(value={"/cpuidle"}, method={RequestMethod.GET})
    public @ResponseBody String cpuIdle(int outloop , int innerloop)
    {
        long st = System.currentTimeMillis();
        for (int i = 0; i < outloop; i++) {
            for (int j = 0; j < innerloop; j++) {
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long et = System.currentTimeMillis() - st;

        return "Total spent: " + et + "ms";

    }


}