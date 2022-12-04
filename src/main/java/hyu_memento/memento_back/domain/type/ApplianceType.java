package hyu_memento.memento_back.domain.type;

public enum ApplianceType {
    WASHING_MACHINE("세탁기"),
    DISH_MACHINE("식기 세척기"),
    CLOTH_DRYER("건조기"),
    STYLER("스타일러"),
    AIR_CLEANER("공기 청정기"),
    WATER_MACHINE("정수기");

    private final String appliance_name;
    private ApplianceType(String name) {
        this.appliance_name = name;
    }

    @Override
    public String toString() {
        return appliance_name;
    }
}
