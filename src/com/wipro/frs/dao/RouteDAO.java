package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.RouteBean;
import java.util.List;

public interface RouteDAO {


	
	
	String createRoute(RouteBean routeBean);
	
	boolean updateRoute(RouteBean routeBean);
	
	int deleteRoute(ArrayList<String> routeId);
	
	RouteBean FindByRouteId(String routeId);
	
	ArrayList<RouteBean> FindAllRoutes();
	
	int rseqgen();
	
	public List<String> findRouteID ( String source,  String destination);
	
}
