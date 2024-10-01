package com.wholesale.backend.models;


import com.wholesale.backend.embeddables.SalesReportId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales_report")
public class SalesReport {
    
    @Id
    private SalesReportId salesReportId;

    private Integer totalSales;

    private Integer totalOrders;

    @OneToOne
    private Product topSellingProduct;

}
