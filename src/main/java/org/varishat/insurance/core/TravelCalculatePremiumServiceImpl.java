package org.varishat.insurance.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.varishat.insurance.rest.TravelCalculatePremiumRequest;
import org.varishat.insurance.rest.TravelCalculatePremiumResponse;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private final DateTimeService dateTimeService;

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