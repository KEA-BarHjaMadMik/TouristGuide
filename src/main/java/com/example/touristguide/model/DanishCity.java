package com.example.touristguide.model;

public enum DanishCity {
    KOEBENHAVN,
    AARHUS,
    ODENSE,
    AALBORG,
    ESBJERG,
    RANDERS,
    HORSENS,
    KOLDING,
    VEJLE,
    ROSKILDE,
    SILKEBORG,
    HERNING,
    HOERSHOLM,
    HELSINGOER,
    NAESTVED,
    VIBORG,
    FREDERICIA,
    KOEGE,
    TAASTRUP,
    HOLSTEBRO,
    HILLEROED,
    SLAGELSE,
    HOLBAEK,
    SOENDERBORG,
    SVENDBORG,
    HJOERRING,
    NOERRESUNDBY,
    RINGSTED,
    OELSTYKKE_STENLOESE,
    FREDERIKSHAVN,
    HADERSLEV,
    SMOERUMNEDRE,
    BIRKEROED,
    FARUM,
    SKANDERBORG,
    SKIVE
    ;

    public String getDisplayName() {
        String name = this.name().toLowerCase()
                .replace("_", " ")
                .replace("oe", "ø")
                .replace("ae", "æ");
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}

