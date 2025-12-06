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
        StringBuilder csv = new StringBuilder();

        // Gunakan ; sebagai delimiter
        csv.append("ID;Nama Dealer;Address;Latitude;Longitude;No Telepon;Email;Rating;Jam Operasional;Nama Kota;Nama Provinsi\r\n");

        for (DealerDto dealer : dealers) {
            csv.append(safeVal(dealer.getId())).append(";")
                    .append(csvVal(dealer.getNamaDealer())).append(";")
                    .append(csvVal(dealer.getAddress())).append(";")
                    .append(safeVal(dealer.getLatitude())).append(";")
                    .append(safeVal(dealer.getLongitude())).append(";")
                    .append(csvVal(dealer.getNoTelepon())).append(";")
                    .append(csvVal(dealer.getEmail())).append(";")
                    .append(safeVal(dealer.getRating())).append(";")
                    .append(csvVal(dealer.getJamOperasional())).append(";")
                    .append(csvVal(dealer.getNamaKota())).append(";")
                    .append(csvVal(dealer.getNamaProvinsi()))
                    .append("\r\n");
        }

        return csv.toString().getBytes();
    }

    private String csvVal(String value) {
        if (value == null) return "\"\"";
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }

    private String safeVal(Object value) {
        return value == null ? "" : value.toString();
    }


}