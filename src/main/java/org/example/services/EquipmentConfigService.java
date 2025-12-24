package org.example.services;

public class EquipmentConfigService {

    private String currentConfig = "Скорость: 1000 Мбит/с, Режим: AUTO, VLAN: 10";

    public void viewConfig() {
        System.out.println("=== Текущие настройки оборудования ===");
        System.out.println(currentConfig);
    }

    public void changeConfig(String newConfig) {
        System.out.println("Изменение настроек оборудования...");
        this.currentConfig = newConfig;
        System.out.println("Новые настройки применены.");
    }
}


