package com.zarchi.codetest.asset.controller;

import com.zarchi.codetest.asset.entity.AssetType;
import com.zarchi.codetest.asset.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/apis")
public class AssetTypeController {
    @Autowired
    AssetTypeService assetTypeService;

    @PostMapping("/create-asset-type")
    public AssetType creteAssetType(@RequestBody AssetType assetType) {
        return assetTypeService.createAssetType(assetType);
    }

    @DeleteMapping("/delete-all-assets")
    public ResponseEntity<String> deleteAllAssets(){
        assetTypeService.deleteAllAssets();
        return ResponseEntity.ok().body("Deleted all asset type successfully!");
    }

    @DeleteMapping("/delete-type/{id}")
    public ResponseEntity<String> deleteAssetType(@PathVariable Integer id){
         return assetTypeService.deleteAssetType(id);
    }

    @GetMapping("/get-asset-type/{id}")
    public ResponseEntity<AssetType> getAssetType(@PathVariable Integer id){
        Optional<AssetType> assetType = assetTypeService.getAssetTypeById(id);
        if(assetType.isPresent()){
            return new ResponseEntity<>(assetType.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update-asset-type/{id}")
    public ResponseEntity<AssetType> updateAssetType(@PathVariable Integer id,
                                @RequestBody AssetType assetType){
        return assetTypeService.updateAssetType(id, assetType);
    }

    @GetMapping("/get-list")
    public ResponseEntity<List<AssetType>> getAllAssetTypeList(){
        return assetTypeService.getAllAssetTypeList();
    }
}
