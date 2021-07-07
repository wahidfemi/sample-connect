package com.mckesson.connect.portal.deleteservice.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mckesson.connect.portal.deleteservice.v1.dto.DeleteResponse;
import com.mckesson.connect.portal.deleteservice.v1.model.DeleteResource;
import com.mckesson.connect.portal.deleteservice.v1.service.IDeleteAdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Connect Portal Admin")
@RequestMapping(path = "/connect-portal", produces = { MediaType.APPLICATION_JSON_VALUE})
public class DeleteAdminController extends AbstractController {

	@Autowired
	IDeleteAdminService deleteAdminService;
	
	@ApiOperation(value = "Delete resource(users,accounts etc..) from different applications", response = String.class)
	@DeleteMapping("/resource")
	public ResponseEntity<?> getUserAccounts(@Valid @RequestBody List<DeleteResource> resources,
			BindingResult result) throws Exception {
		log.debug("going to delete resource from different applications.......");
		return new ResponseEntity<DeleteResponse>(deleteAdminService.deleteResources(resources),
				HttpStatus.OK);
	}
}
