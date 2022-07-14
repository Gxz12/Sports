package com.example.sports.DAO;

import com.example.sports.entity.RunningDataCollection;

import java.util.Date;

public interface RdcMapper {
    public RunningDataCollection selectRdcByDate(Date date);

    public RunningDataCollection selectRdcById(long id);
    public int insertRdc(RunningDataCollection rdc);
}
