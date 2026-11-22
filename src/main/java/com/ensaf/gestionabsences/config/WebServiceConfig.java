package com.ensaf.gestionabsences.config;

import com.ensaf.gestionabsences.service.AbsenceService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Bean
    public Endpoint endpoint(Bus bus, AbsenceService absenceService) {
        EndpointImpl endpoint = new EndpointImpl(bus, absenceService);
        endpoint.publish("/absences");
        return endpoint;
    }
}