package com.tokodia.marketplace.user.Enum;

public enum RoleEnum {
    OWNER(1L),
    ADMIN(2L),
    KASIR(3L);

    private Long value;

    RoleEnum(Long newValue) {
        this.value = newValue;
    }

    public Long getValue() {
        return value;
    }

}
