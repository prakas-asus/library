package com.example.library.service;

import com.example.library.dto.DealerDto;
import com.example.library.entity.Dealer;
import com.example.library.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
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

    public byte[] exportToCsv(List<DealerDto> dealers) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        
        writer.println("ID,Nama Dealer,Address,Latitude,Longitude,No Telepon,Email,Rating,Jam Operasional,Nama Kota,Nama Provinsi");
        
        for (DealerDto dealer : dealers) {
            writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
                dealer.getId(),
                dealer.getNamaDealer(),
                dealer.getAddress(),
                dealer.getLatitude(),
                dealer.getLongitude(),
                dealer.getNoTelepon(),
                dealer.getEmail(),
                dealer.getRating(),
                dealer.getJamOperasional(),
                dealer.getNamaKota(),
                dealer.getNamaProvinsi());
        }
        
        writer.flush();
        return outputStream.toByteArray();
    }
}