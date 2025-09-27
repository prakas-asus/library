package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.dto.ProvinceByStoreDto;
import com.example.library.entity.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Long> {
     @Query(nativeQuery = true, value = "SELECT s FROM Store s " +
           "WHERE s.active=true AND s.deleted=false " +
           "AND (LOWER(s.branch.province.name) LIKE LOWER(CONCAT('%', :provinceName, '%')) " +
           "     OR s.whitelisted=true)")
    List<Stores> findActiveByProvinceNameOrWhitelisted(@Param("provinceName") String provinceName);

    @Query(nativeQuery = true, value = "select\r\n" + //
                "\ts.id as storeId,\r\n" + //
                "\ts.name as storeName ,\r\n" + //
                "\tp.name as provinceName \r\n" + //
                "from\r\n" + //
                "\tstores s\r\n" + //
                "inner join branches b on\r\n" + //
                "\ts.branch_id = b.id\r\n" + //
                "inner join provinces p on\r\n" + //
                "\tb.province_id = p.id\r\n" + //
                "where\r\n" + //
                "\tp.\"name\" like '%' || :province || '%' and s.\"name\"  like '%' || :store || '%' ; ")
    List<ProvinceByStoreDto> findByBranch_Province_NameContainingIgnoreCaseAndNameContainingIgnoreCase(@Param("province") String province, @Param("store") String store);
}
