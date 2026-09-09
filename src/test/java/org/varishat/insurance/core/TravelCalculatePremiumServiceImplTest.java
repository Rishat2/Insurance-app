package org.varishat.insurance.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.varishat.insurance.rest.TravelCalculatePremiumRequest;
import org.varishat.insurance.rest.TravelCalculatePremiumResponse;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TravelCalculatePremiumServiceImplTest {

    private TravelCalculatePremiumServiceImpl service;

    private TravelCalculatePremiumRequest request;

    @BeforeEach
    public void setUp() {
        request = createRequestWithAllField();
        DateTimeService timeService = mock(DateTimeService.class);
        when(timeService.getDiffOfDays(request.getAgreementDateFrom(), request.getAgreementDateTo())).thenReturn(0L);
        service = new TravelCalculatePremiumServiceImpl(timeService);
    }

    @Test
    public void shouldFillPersonFirstName() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void shouldFillPersonLastName() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void shouldFillAgreementDateFrom() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void shouldFillAgreementDateTo() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void shouldFillAgreementPrice() {
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
