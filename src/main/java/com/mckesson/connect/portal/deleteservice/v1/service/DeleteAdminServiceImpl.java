package com.mckesson.connect.portal.deleteservice.v1.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckesson.connect.portal.deleteservice.v1.dao.IDeleteAdminDao;
import com.mckesson.connect.portal.deleteservice.v1.dto.DeleteResponse;
import com.mckesson.connect.portal.deleteservice.v1.model.DeleteResource;

@Service
public class DeleteAdminServiceImpl implements IDeleteAdminService{

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IDeleteAdminDao deleteAdminDao;
	

	@Override
	public DeleteResponse deleteResources(List<DeleteResource> resources) {
		DeleteResponse resp = new DeleteResponse();
		if(resources.size()>0) {
			resources.forEach(resource -> {
				if("DA".equalsIgnoreCase(resource.getAction())) {
					if(resource.getAppNames().isEmpty()) {
						log.debug("we are going to delete accounts from all applications....");
						if(resource.getAccounts().isEmpty()) {
							log.debug("Accounts are not present in request.");
							resp.setMessage("Accounts are not present in request.");
						}
						else {
							boolean result = deleteAccountsFromLegacyOrd(resource.getAccounts());
							if(result) {
								log.debug("Accounts are deleted successfully from legacy ordering application.");
								resp.setMessage("Accounts are deleted successfully from legacy ordering application.");
							}
							else {
								log.debug("There is a problem in deleting accounts from legacy ordering app. Please contact administrator.");
								resp.setMessage("There is a problem in deleting accounts from legacy ordering app. Please contact administrator.");
							}
						}
					}
					else {
						log.debug("we will write code to delete accounts from specific app");
						resp.setMessage("we will write code to delete accounts from specific app");
					}
				}
				else if("DU".equalsIgnoreCase(resource.getAction())) {
					log.debug("we will write code to delete user from Portal application....");
					resp.setMessage("we will write code to delete user from Portal application....");
				}
			});
		}
		else {
			resp.setMessage("No resource found to be deleted....");
		}
		return resp;
		
	}

	private boolean deleteAccountsFromLegacyOrd(List<String> accounts) {
		//deleteAdminDao.deleteAccountsFromLegacyOrd(accounts);
		return true;
	}
}
