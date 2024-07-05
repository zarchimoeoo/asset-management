package com.zarchi.codetest.asset.service;

import com.zarchi.codetest.asset.entity.AssetType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AssetTypeService {
    AssetType createAssetType(AssetType assetType);
    void deleteAllAssets();
    ResponseEntity<String> deleteAssetType(Integer id);
    ResponseEntity<AssetType> updateAssetType(Integer id, AssetType assetType);
    Page<AssetType> getAllAssetTypeList(Integer offset, Integer limit);
    ResponseEntity<AssetType> getAssetTypeById (Integer id);
    }





