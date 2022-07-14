package com.example.sports.Service;
import com.example.sports.entity.RunningDataCollection;
import com.example.sports.DAO.RdcMapper;
import com.example.sports.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class RdcService {

    @Resource
    private RdcMapper rdcMapper;


    public RunningDataCollection selectRdcById(long id){
        return rdcMapper.selectRdcById(id);
    }

    public boolean update(RunningDataCollection rdc){
        int x = rdcMapper.insertRdc (rdc);
        if(x>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean search(RunningDataCollection rdc){
        Date date = rdc.getDate();
        RunningDataCollection rdc1 =  rdcMapper.selectRdcByDate(date);
        if(rdc1==null){
            return false;
        }else{
            return true;
            }
        }
}