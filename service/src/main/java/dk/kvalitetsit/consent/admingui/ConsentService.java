package dk.kvalitetsit.consent.admingui;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dk.kvalitetsit.consent.admingui.dto.AddConsentTemplateRequest;
import dk.kvalitetsit.consent.admingui.dto.ConsentTemplateDTO;
import dk.kvalitetsit.consent.admingui.dto.ConsentTemplateTO;
import dk.kvalitetsit.consent.admingui.dto.ConsentTemplateTOs;
import dk.kvalitetsit.consent.admingui.dto.UpdateConsentTemplateRequest;
import org.springframework.stereotype.Component;

@Component
public class ConsentService extends SessionAddingService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsentService.class);

    @Value("${consentservice.url}")
	private String consentServiceContext;
	
	public boolean addConsentTemplate(AddConsentTemplateRequest request) {
				
		ResponseEntity<String> response = postForEntity(consentServiceContext+"/api/addConsentTemplate", request, String.class);

		return response.getStatusCode().equals(HttpStatus.OK);
		
	}
	
	public boolean updateConsentTemplate(UpdateConsentTemplateRequest request) {
		
		ResponseEntity<String> response = postForEntity(consentServiceContext+"/api/updateConsentTemplate", request, String.class);

		return response.getStatusCode().equals(HttpStatus.OK);
		
	}
	
	public List<ConsentTemplateTO> getAllActiveConsentTemplates() {
		
		ResponseEntity<ConsentTemplateTOs> response = getForEntity(consentServiceContext+"/api/getAllActiveConsentTemplates", ConsentTemplateTOs.class);		

		if (response.getStatusCode().equals(HttpStatus.OK)) {
			List<ConsentTemplateTO> rv = response.getBody().getList();
			
			rv.sort(Comparator.comparing(ConsentTemplateTO::getAppId));
			
			return rv;
		} else {
			return null;
		}
		
	}
	
	public ConsentTemplateDTO getConsentTemplate(long consentTemplateId) {
		
		ResponseEntity<ConsentTemplateDTO> response = getForEntity(consentServiceContext+"/api/getConsentTemplate?consentTemplateId="+consentTemplateId, ConsentTemplateDTO.class);		

		if (response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody();
		} else {
			return null;
		}
		
	}

	
	
}
