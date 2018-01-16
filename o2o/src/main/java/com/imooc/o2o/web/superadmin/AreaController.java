package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin") //访问主目录
public class AreaController {
	Logger logger=LoggerFactory.getLogger(AreaService.class);
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	@ResponseBody // 将modelMap转化成json返回给前端
	private Map<String, Object> listArea() {
		logger.info("==start==");
		long starttime=System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = new ArrayList<Area>();
		try {
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		long endtime=System.currentTimeMillis();
		logger.debug("costtime:{}ms",endtime-starttime);
		logger.info("==end==");
		return modelMap;
	}
}
