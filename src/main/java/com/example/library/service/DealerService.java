package com.example.library.service;

import com.example.library.dto.DealerDto;
import com.example.library.entity.Dealer;
import com.example.library.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;

    public List<DealerDto> getAllDealers() {
        return dealerRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DealerDto convertToDto(Dealer dealer) {
        DealerDto dto = new DealerDto();
        dto.setId(dealer.getId());
        dto.setNamaDealer(dealer.getNamaDealer());
        dto.setAddress(dealer.getAddress());
        dto.setLatitude(dealer.getLatitude());
        dto.setLongitude(dealer.getLongitude());
        dto.setNoTelepon(dealer.getNoTelepon());
        dto.setEmail(dealer.getEmail());
        dto.setRating(dealer.getRating());
        dto.setJamOperasional(dealer.getJamOperasional());
        dto.setNamaKota(dealer.getKota() != null ? dealer.getKota().getNamaKota() : null);
        dto.setNamaProvinsi(dealer.getProvinsi() != null ? dealer.getProvinsi().getNamaProvinsi() : null);
        return dto;
    }

    public Optional<Dealer> getDealerById(Long id) {
        return dealerRepository.findById(id);
    }

    public Dealer saveDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    public void deleteDealer(Long id) {
        dealerRepository.deleteById(id);
    }


}