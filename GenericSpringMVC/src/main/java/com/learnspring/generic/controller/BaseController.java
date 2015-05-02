package com.learnspring.generic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseController {
	/** Logger for all sub-class Controller */
	protected final Log logger = LogFactory.getLog(getClass());
}
