package com.ngtesting.platform.service;


import java.util.List;

import com.ngtesting.platform.entity.EvtGuest;
import com.ngtesting.platform.entity.EvtService;
import com.ngtesting.platform.entity.EvtService.ServiceType;
import com.ngtesting.platform.vo.ServiceVo;

public interface ServiceService extends BaseService {

	List<EvtService> list(Long eventId, ServiceType type);
	List<EvtService> listForEdit(Long eventId, ServiceType type);

	EvtService save(ServiceVo vo);

	boolean disablePers(Long id);

}