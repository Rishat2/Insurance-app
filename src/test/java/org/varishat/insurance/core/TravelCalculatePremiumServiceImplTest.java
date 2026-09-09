package org.varishat.insurance.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.varishat.insurance.rest.TravelCalculatePremiumRequest;
import org.varishat.insurance.rest.TravelCalculatePremiumResponse;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TravelCalculatePremiumServiceImplTest {

    private TravelCalculatePremiumServiceImpl service;

    @BeforeEach
    public void setUp() {
        DateTimeService timeService = new DateTimeService();
        service = new TravelCalculatePremiumServiceImpl(timeService);
    }

    @Test
    public void shouldFillPersonFirstName() {
        TravelCalculatePremiumRequest request = createRequestWithAllField();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void shouldFillPersonLastName() {
        TravelCalculatePremiumRequest request = createRequestWithAllField();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void shouldFillAgreementDateFrom() {
        TravelCalculatePremiumRequest request = createRequestWithAllField();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void shouldFillAgreementDateTo() {
        TravelCalculatePremiumRequest request = createRequestWithAllField();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void shouldFillAgreementPrice() {
        TravelCalculatePremiumRequest request = createRequestWithAllField();
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertNotNull(response.getAgreementPrice());
    }

    private TravelCalculatePremiumRequest createRequestWithAllField () {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Ivan");
        request.setPersonLastName("Ivanov");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());
        return request;
    }
}
