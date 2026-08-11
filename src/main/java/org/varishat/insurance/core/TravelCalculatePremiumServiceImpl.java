package org.varishat.insurance.core;

import org.springframework.stereotype.Component;
import org.varishat.insurance.rest.TravelCalculatePremiumRequest;
import org.varishat.insurance.rest.TravelCalculatePremiumResponse;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        return response;
    }

}