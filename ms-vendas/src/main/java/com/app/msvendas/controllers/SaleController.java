package com.app.msvendas.controllers;

import com.app.msvendas.dto.SaleDTO;
import com.app.msvendas.dto.SaleSuccessDTO;
import com.app.msvendas.dto.SaleSumDTO;
import com.app.msvendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> listSales = service.findAll(pageable);
        return ResponseEntity.ok(listSales);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> listSales = service.amountGroupedBySeller();
        return ResponseEntity.ok(listSales);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> listSales = service.successGroupedBySeller();
        return ResponseEntity.ok(listSales);
    }

}
