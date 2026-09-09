package org.varishat.insurance.core;

import org.springframework.stereotype.Component;
import org.varishat.insurance.rest.TravelCalculatePremiumRequest;
import org.varishat.insurance.rest.TravelCalculatePremiumResponse;

import java.math.BigDecimal;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private final DateTimeService dateTimeService;

    public TravelCalculatePremiumServiceImpl(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementPrice(BigDecimal.valueOf(dateTimeService.getDiffOfDays
                (request.getAgreementDateFrom(), request.getAgreementDateTo())));
        return response;
    }
}