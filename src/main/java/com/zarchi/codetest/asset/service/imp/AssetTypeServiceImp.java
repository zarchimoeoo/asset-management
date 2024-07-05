package com.zarchi.codetest.asset.service.imp;

import com.zarchi.codetest.asset.entity.AssetType;
import com.zarchi.codetest.asset.repository.AssetTypeRepo;
import com.zarchi.codetest.asset.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class AssetTypeServiceImp implements AssetTypeService {
    @Autowired
    AssetTypeRepo assetTypeRepo;

    @Override
    public AssetType createAssetType(AssetType assetType) {
        return assetTypeRepo.save(assetType);
    }

    @Override
    public void deleteAllAssets() {
        assetTypeRepo.deleteAll();
    }

    @Override
    public ResponseEntity<String> deleteAssetType(Integer id) {
        Optional<AssetType> assetTypeRes = assetTypeRepo.findById(id);
        if(assetTypeRes.isPresent()){
            assetTypeRepo.deleteById(id);
            return ResponseEntity.ok().body("Deleted successfully asset type with ID: " + id);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<AssetType> updateAssetType(Integer id, AssetType assetType) {
        Optional<AssetType> assetTypeRes = assetTypeRepo.findById(id);
        if(assetTypeRes.isPresent()){
            AssetType updateAssetType = assetTypeRes.get();
            updateAssetType.setAssetTypeId(updateAssetType.getAssetTypeId());
            updateAssetType.setAssetType(assetType.getAssetType());
            updateAssetType.setCreatedAt(updateAssetType.getCreatedAt());
            updateAssetType.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            assetTypeRepo.save(updateAssetType);
            return new ResponseEntity<>(updateAssetType, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Page<AssetType> getAllAssetTypeList(Integer offset, Integer limit) {
        Pageable pageable = PageRequest.of(offset,limit);
        return assetTypeRepo.findAll(pageable);
    }

    @Override
    public ResponseEntity<AssetType> getAssetTypeById(Integer id) {
       Optional<AssetType> assetTypeRes = assetTypeRepo.findById(id);
       if(assetTypeRes.isPresent()){
           return new ResponseEntity<>(assetTypeRes.get(), HttpStatus.OK);
       }else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
}
