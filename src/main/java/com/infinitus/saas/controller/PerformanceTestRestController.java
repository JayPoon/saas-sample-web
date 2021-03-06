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
        long res = 0;
        long st = System.currentTimeMillis();
        for (int i = 0; i < outloop; i++) {
            for (int j = 0; j < innerloop; j++) {
                res += accumulate(innerloop);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long et = System.currentTimeMillis() - st;

        return "Total spent: " + et + "ms" + "res:" + res;

    }

   private long accumulate(long max) {
        long ret = 0;
        for(long i = 1; i <= max; i++) {
            ret += i;
        }
        return ret;
    }

    @RequestMapping(value={"/memidle"}, method={RequestMethod.GET})
    public @ResponseBody String memIdle(int mb, int holdtime )
    {
        long res = 0;
        long st = System.currentTimeMillis();
        long et = System.currentTimeMillis() - st;

        int MB = 1024 * 1024;
        int size = mb * MB;
        byte[] cache = new byte[MB];


        try {
            Thread.sleep(holdtime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Total size: " + size + "mb | hold time:" + holdtime +" ms" ;

    }


}