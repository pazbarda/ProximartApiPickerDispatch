package com.proximart.api.picker.dispatch.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PickerEntity {
    private String userId;
    private String storeId;
    private List<String> assignedOrdersIds = new ArrayList<>();

    private PickerEntity() {
    }

    public String getUserId() {
        return userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public List<String> getAssignedOrdersIds() {
        return assignedOrdersIds;
    }

    public void addAssignedOrderId(String orderId) {
        this.assignedOrdersIds.add(orderId);
    }

    public void removeAssignedOrderId(String orderId) {
        this.assignedOrdersIds.remove(orderId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PickerEntity that = (PickerEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(storeId, that.storeId) &&
                Objects.equals(assignedOrdersIds, that.assignedOrdersIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, storeId, assignedOrdersIds);
    }

    @Override
    public String toString() {
        return "PickerEntity{" +
                "userId='" + userId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", assignedOrdersIds=" + assignedOrdersIds +
                '}';
    }

    public static class Builder {
        private String userId;
        private String storeId;
        private List<String> assignedOrdersIds = new ArrayList<>();

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withStoreId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder withAssignedOrdersIds(List<String> assignedOrdersIds) {
            this.assignedOrdersIds = assignedOrdersIds;
            return this;
        }

        public PickerEntity build() {
            PickerEntity pickerEntity = new PickerEntity();
            pickerEntity.userId = this.userId;
            pickerEntity.storeId = this.storeId;
            pickerEntity.assignedOrdersIds = new ArrayList<>(this.assignedOrdersIds);
            return pickerEntity;
        }
    }
}
