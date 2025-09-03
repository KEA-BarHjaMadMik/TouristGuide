package com.example.touristguide.repository;

import com.example.touristguide.model.AttractionTags;
import com.example.touristguide.model.DanishCity;
import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions;
    private final List<DanishCity> cities;
    private final List<AttractionTags> tags;
    private int attractionId;

    public TouristRepository() {
        this.touristAttractions = new ArrayList<>();
        this.cities = Arrays.asList(DanishCity.values());
        this.tags = Arrays.asList(AttractionTags.values());
        populateAttractions();
    }

    private int nextAttractionId() {
        return ++attractionId;
    }

    private void populateAttractions() {
        addAttraction(new TouristAttraction(
                        "GOKART",
                        "Oplev fart, sjov og adrenalin på vores gokartbane! Udfordr venner, familie eller kolleger i spændende løb, hvor skarpe sving og høj fart giver den ultimative køreglæde. Perfekt til både nybegyndere og fartentusiaster.",
                        "Struer",
                        Arrays.asList(
                                AttractionTags.GOKART,
                                AttractionTags.SJAELLAND,
                                AttractionTags.FART
                        )
                )
        );

        addAttraction(new TouristAttraction(
                        "PRØVEKØR_DRØMMEBILEN_-_PORSCHE_911_CARRERA_S",
                        "Lej din drømmebil for en dag! Oplev drømmen og prøv en af verdens mest berømte biler - Porsche 911 Carrera S. Bilen er i sort metallic med sort læderindtræk og baghjulstræk ligesom en rigtig Porsche 911 skal være. Bilen er desuden udstyret med et sportsudstødningssystem for at få mere lyd i bilen og et Bose lydsystem, så du kan nyde din yndlingsmusik, mens du kører. Udover det er den også udstyret med lir i form af Porsche active suspension management, 8-trins dobbeltkoblingsboks, Apple carplay og glassoltag.",
                        "Malmö",
                        Arrays.asList(
                                AttractionTags.MALMOE,
                                AttractionTags.BILER,
                                AttractionTags.PORSCHE,
                                AttractionTags.FART,
                                AttractionTags.LUKSUS
                        )
                )
        );

        addAttraction(new TouristAttraction(
                        "TANDEMSPRING",
                        "DEN ULTIMATIVE OPLEVELSE MED ET ANDET MENNESKE! TAG DIN VEN ELLER KÆRESTE I HÅNDEN, SPRING UD I DET OG OPLEV SUSET I MAVEN SAMMEN. DENNE OPLEVELSE VIL UDEN TVIVL KNYTTE BÅND FOR LIVET.\n" +
                                "\n" +
                                "Vores professionelle og specialuddannede instruktører vil guide jer til at udfordre egne grænser i sikre rammer.\n" +
                                "\n" +
                                "Et tandemspring er den perfekte anledning til at komme hinanden ved, idet at i fastspændes i hver jeres body-harness, og tager springet sammen.",
                        "Herning",
                        Arrays.asList(
                                AttractionTags.TANDEM,
                                AttractionTags.HOEJDER,
                                AttractionTags.FRITFALD
                        )
                )
        );

        addAttraction(new TouristAttraction(
                        "BUNGEEJUMPING", "Få et adrenalinsus ud over det sædvanlige med Københavns vildeste oplevelse: bungee jump fra en kran på hele 69 meters højde midt på Refshaleøen. Her får du en unik kombination af fart, frihed og udsigt – du svæver frit med Københavns skyline, havnen og Øresund som baggrund.\n" +
                        "\n" +
                        "Uanset om du er erfaren eventyrer eller førstegangshopper, står professionelle instruktører klar til at guide dig trygt gennem oplevelsen. Alt sikkerhedsudstyr er inkluderet, og du får en oplevelse, der garanteret sætter sig på nethinden for livet.\n" +
                        "\n" +
                        "Perfekt som gave, som en grænseoverskridende udfordring til dig selv – eller som et uforglemmeligt højdepunkt på dit besøg i København.\n" +
                        "\n" +
                        " Er du klar til at tage springet?",
                        "København S",
                        Arrays.asList(
                                AttractionTags.BUNGEEJUMP,
                                AttractionTags.SJAELLAND,
                                AttractionTags.SNOR
                        )
                )
        );
    }

    public List<TouristAttraction> getAttractions() {
        return touristAttractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attraction.setAttractionId(nextAttractionId());
        touristAttractions.add(attraction);
        return attraction;
    }

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        TouristAttraction oldAttraction = findAttractionByName(attraction.getName());
        if (oldAttraction != null) {
            oldAttraction.setDescription(attraction.getDescription());
            return oldAttraction;
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        TouristAttraction attraction = findAttractionByName(name);
        if (attraction != null) {
            touristAttractions.remove(attraction);
            return attraction;
        }
        return null;
    }
    
    public List<DanishCity> getCities(){
        return cities;
    }

    public List<AttractionTags> getTags(){
        return tags;
    }
}
