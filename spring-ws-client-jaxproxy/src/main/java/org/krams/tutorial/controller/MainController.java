package org.krams.tutorial.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.oxm.SubscriptionPort;
import org.krams.tutorial.oxm.SubscriptionRequest;
import org.krams.tutorial.oxm.SubscriptionResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

/**
 * Handles and retrieves the subscription request
 */
@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="subscriptionJaxProxyService")
	private SubscriptionPort subscriptionJaxProxyService;
	
    /**
     * Handles and retrieves the subscribe page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage(Model model) {
    	logger.debug("Received request to show subscribe page");

    	// Prepare the formBackingObject or commandObject
    	model.addAttribute("subscriptionAttribute", new SubscriptionRequest());
    	
    	// Show the subscribe page
    	// This will resolve to /WEB-INF/jsp/subscribepage.jsp
    	return "subscribepage";
	}
    
    /**
     * Handles the subscription request
     */
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public String doSubscribe(@ModelAttribute("subscriptionAttribute") SubscriptionRequest request,  Model model) {
    	logger.debug("Received request to subscribe");
    
    	// The "subscriptionAttribute" model has been passed to the controller from the JSP
    	// We use the name "subscriptionAttribute" because the JSP uses that name
    	
    	// Delegate to webServiceTemplate for the actual subscription
    	try {
	        SubscriptionResponse response = subscriptionJaxProxyService.subscription(request);
	        
	        // The message has been sent
	        // But it doesn't mean we're subscribed successfully
	        logger.debug(response.getCode());
	        logger.debug(response.getDescription());
	        
	        // Add response to model so that we know if successful or not
	        if (response.getCode().equals("SUCCESS") == true) { 
	        	model.addAttribute("response", "Success! " + response.getDescription());
	        } else {
	        	model.addAttribute("response", "Failure! " + response.getDescription());
	        }
    		
    	} catch (SoapFaultClientException sfce) {
    		
    		// This indicates there's something wrong with our message
    		// For example a validation error
    		logger.error("We sent an invalid message", sfce);
    		
    		// Add error to model
    		model.addAttribute("error", "Validation error! We cannot process your subscription");
    		
    	} catch (Exception e) {
    		// Expect the unexpected
    		logger.error("Unexpected exception", e);
    		
    		// Add error to model
    		model.addAttribute("error", "Server error! A unexpected error has occured");
    	}
    	
    	// Prepare the formBackingObject or commandObject
    	// Resend the same contents of the form
    	model.addAttribute("subscriptionAttribute", request);
    	
    	// Show the subscribe page again regardless if successful or not
    	// This will resolve to /WEB-INF/jsp/subscribepage.jsp
    	return "subscribepage";
	}

}
