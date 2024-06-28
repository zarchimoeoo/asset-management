package com.zarchi.codetest.asset.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ASSET_TYPE")
public class AssetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer assetTypeId;

    @Column(name = "ASSET_TYPE")
    private String assetType;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @CreationTimestamp
    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

}
