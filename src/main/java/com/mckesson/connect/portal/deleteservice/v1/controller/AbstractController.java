package com.mckesson.connect.portal.deleteservice.v1.controller;

import com.mckesson.lib.spring.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController extends RestController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
}
