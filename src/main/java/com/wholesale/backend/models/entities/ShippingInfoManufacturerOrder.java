package com.wholesale.backend.models.entities;



import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "manufacturer_order_shipping_info")
public class ShippingInfoManufacturerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shippingId;

    private Date shipmentDate;

    private Date expectedDeliveryDate;

    private String shipmentStatus;

    @ManyToOne
    private ManufacturerOrder manufacturerOrder;
}
