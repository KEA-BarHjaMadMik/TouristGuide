package com.example.touristguide.model;

public enum AttractionTags {
    BILER,
    BUNGEEJUMP,
    FART,
    FRIT_FALD,
    FYN,
    GOKART,
    HOEJDER,
    JYLLAND,
    LUKSUS,
    MALMOE,
    PORSCHE,
    SJAELLAND,
    SNOR,
    TANDEM;

    public String getDisplayName() {
        String name = this.name().toLowerCase()
                .replace("_", " ")
                .replace("oe", "ø")
                .replace("ae", "æ");
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
