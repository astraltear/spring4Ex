package sample.spring.chapter02.bankapp.controller;

import sample.spring.chapter02.bankapp.service.FixedDepositService;
import sample.spring.chapter02.domain.FixedDepositDetails;

public interface FixedDepositController {
	FixedDepositService getFixedDepositService();
	boolean submit();
	FixedDepositDetails get();
}
