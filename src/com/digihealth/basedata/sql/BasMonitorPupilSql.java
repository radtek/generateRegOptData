package com.digihealth.basedata.sql;

public class BasMonitorPupilSql {
	public static final String deleteByRegOptId = "DELETE FROM bas_monitor_pupil WHERE regOptId IN(SELECT t.regOptId FROM bas_reg_opt t WHERE t.beid = ? AND t.name LIKE ?)";
}
