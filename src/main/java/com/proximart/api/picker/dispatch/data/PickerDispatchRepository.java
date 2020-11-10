package com.proximart.api.picker.dispatch.data;

import com.proximart.api.picker.dispatch.ui.model.PickerNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PickerDispatchRepository {

    Map<String, PickerEntity> pickerEntityByUserId = new HashMap<>();

    public void pickerLogIn(String userId, String storeId) {
        PickerEntity pickerEntity = new PickerEntity.Builder()
                .withUserId(userId)
                .withStoreId(storeId)
                .build();
        pickerEntityByUserId.put(userId, pickerEntity);
    }

    public void pickerLogOff(String userId) {
        pickerEntityByUserId.remove(userId);
    }

    public List<String> getPickerUserIdsForStoreId(String storeId) {
        return pickerEntityByUserId.values().stream()
                .filter(pickerEntity -> pickerEntity.getStoreId().equals(storeId))
                .map(pickerEntity -> pickerEntity.getUserId())
                .collect(Collectors.toList());
    }

    public void addOrderIdToPicker(String pickerUserId, String orderId) {
        Optional.ofNullable(pickerEntityByUserId.get(pickerUserId))
                .orElseThrow(() -> new PickerNotFoundException(pickerUserId))
                .addAssignedOrderId(orderId);
    }

    public void removeOrderIdFromPicker(String pickerUserId, String orderId) {
        Optional.ofNullable(pickerEntityByUserId.get(pickerUserId))
                .orElseThrow(() -> new PickerNotFoundException(pickerUserId))
                .removeAssignedOrderId(orderId);
    }
}
