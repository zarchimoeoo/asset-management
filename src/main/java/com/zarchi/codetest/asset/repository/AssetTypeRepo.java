package com.zarchi.codetest.asset.repository;

import com.zarchi.codetest.asset.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetTypeRepo extends JpaRepository<AssetType, Integer> {

}
