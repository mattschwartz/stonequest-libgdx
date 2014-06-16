package com.barelyconscious.stonequest.items;

public enum Material {

    cloth,
    leather,
    metal,
    ether,
    mystic;

    @Override
    public String toString() {
        switch (this) {
            case cloth:
                return "cloth";

            case leather:
                return "leather";

            case metal:
                return "metal";

            case ether:
                return "ether";

            case mystic:
                return "mystic";

            default:
                return "";
        }
    }

}
