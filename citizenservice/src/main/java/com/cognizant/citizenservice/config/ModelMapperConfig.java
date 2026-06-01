package com.cognizant.citizenservice.config;


import com.cognizant.citizenservice.dto.feedback.FeedbackResponse;
import com.cognizant.citizenservice.dto.report.CitizenReportResponse;
import com.cognizant.citizenservice.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        return modelMapper;
    }
}

