package com.mckesson.connect.portal.deleteservice.v1.service;

import java.util.List;

import com.mckesson.connect.portal.deleteservice.v1.dto.DeleteResponse;
import com.mckesson.connect.portal.deleteservice.v1.model.DeleteResource;

public interface IDeleteAdminService {
	public DeleteResponse deleteResources(List<DeleteResource> resources);
}
