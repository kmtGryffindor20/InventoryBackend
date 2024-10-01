package com.wholesale.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.backend.embeddables.SalesReportId;
import com.wholesale.backend.models.SalesReport;

@Repository
public interface SalesReportRepository extends CrudRepository<SalesReport, SalesReportId> {
    
}
