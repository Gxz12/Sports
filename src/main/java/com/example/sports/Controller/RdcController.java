package com.example.sports.Controller;

import com.example.sports.Service.RdcService;
import com.example.sports.entity.RunningDataCollection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController // This means that this class is a Controller
@RequestMapping(value="rdc") // This means URL's start with /demo (after Application path)

public class RdcController {

    @Resource
    RdcService rdcService;

    @RequestMapping(value = "searchData")
       public String searchData(){ return "searchData";}

    @RequestMapping(value="/result")
    public String result(Date date){

        // String username = req.getParameter("username");
        // String password = req.getParameter("password");

       RunningDataCollection rdc = new RunningDataCollection();
       rdc.setDate(date);

        boolean flag = rdcService.search(rdc);

        if(flag==true){
            return "success";
        }else {
            return "Fail";
        }
    }

    @RequestMapping(value = "/update")
    public String uploadData(){return "update";}

    @RequestMapping(value="/dataEnd")
    public String end(HttpServletRequest req, HttpServletResponse resp){

        String time = req.getParameter("time");
        String speed = req.getParameter("speed");

        RunningDataCollection rdc = new RunningDataCollection();
        rdc.setTime(time);
        rdc.setSpeed(speed);
        boolean flag = rdcService.update(rdc);
        if(flag==true){
            return "End1";
        }else{
            return "End2";
        }
    }
}

