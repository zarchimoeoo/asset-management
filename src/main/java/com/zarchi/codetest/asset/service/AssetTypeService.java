package com.zarchi.codetest.asset.service;

import com.zarchi.codetest.asset.entity.AssetType;
import com.zarchi.codetest.asset.repository.AssetTypeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AssetTypeService {
    @Autowired
    AssetTypeRepo assetTypeRepo;

    public AssetType createAssetType(AssetType assetType){
       return assetTypeRepo.save(assetType);
    }

    public void deleteAllAssets(){
       assetTypeRepo.deleteAll();
    }

    public ResponseEntity<String> deleteAssetType(Integer id) {
        Optional<AssetType> assetTypeRes = assetTypeRepo.findById(id);
        if (assetTypeRes.isPresent()) {
            assetTypeRepo.deleteById(id);
            return ResponseEntity.ok().body("Deleted successfully asset type with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Optional<AssetType> getAssetTypeById(Integer id){
        return assetTypeRepo.findById(id);
    }

    public ResponseEntity<AssetType> updateAssetType(Integer id, AssetType assetType){
        Optional<AssetType> assetTypeRes = assetTypeRepo.findById(id);
        if(assetTypeRes.isPresent()){
            AssetType updateAssetType = assetTypeRes.get();
            updateAssetType.setAssetTypeId(updateAssetType.getAssetTypeId());
            updateAssetType.setAssetType(assetType.getAssetType());
            updateAssetType.setCreatedAt(updateAssetType.getCreatedAt());
            updateAssetType.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            assetTypeRepo.save(updateAssetType);
            return new ResponseEntity<>(updateAssetType, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<AssetType>> getAllAssetTypeList(){
        try{
            List<AssetType> assetTypeList = new ArrayList<AssetType>();
            assetTypeList = assetTypeRepo.findAll();
            if(!assetTypeList.isEmpty()){
                return new ResponseEntity<>(assetTypeList, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
