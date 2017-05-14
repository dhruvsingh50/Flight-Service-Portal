package com.wipro.frs.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.frs.bean.ScheduleBean;

public interface ScheduleDAO {

	String createSchedule(ScheduleBean scheduleBean);
	
	boolean updateSchedule(ScheduleBean scheduleBean);

	int deleteSchedule(ArrayList<String> scheduleId);
	
	ScheduleBean FindByScheduleId(String scheduleId);
	
	ArrayList<ScheduleBean> FindAllSchedules();
	
	public int sseqgen();
	
	public List<ScheduleBean> checkday(String day);
}
