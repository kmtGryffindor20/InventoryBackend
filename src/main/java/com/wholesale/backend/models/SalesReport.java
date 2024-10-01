package com.wholesale.backend.models;


import java.sql.Date;
import java.util.Set;

import com.wholesale.backend.embeddables.SalesReportId;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
