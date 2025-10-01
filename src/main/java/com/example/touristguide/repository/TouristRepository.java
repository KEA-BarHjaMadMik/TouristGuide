package com.example.touristguide.repository;

import com.example.touristguide.model.AttractionTags;
import com.example.touristguide.model.CurrencyRates;
import com.example.touristguide.model.DanishCity;
import com.example.touristguide.model.TouristAttraction;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions;
    private final List<DanishCity> cities;
    private final List<AttractionTags> tags;

    public TouristRepository() {
        this.attractions = new ArrayList<>();
        this.cities = Arrays.asList(DanishCity.values());
        this.tags = Arrays.asList(AttractionTags.values());
        populateAttractions();
    }

    private void populateAttractions() {
        addAttraction(new TouristAttraction(
                        "Gokart",
                        "Oplev fart, sjov og adrenalin på vores gokartbane! Udfordr venner, familie eller kolleger i spændende løb, hvor skarpe sving og høj fart giver den ultimative køreglæde. Perfekt til både nybegyndere og fartentusiaster.",
                        DanishCity.SKIVE,
                        Arrays.asList(
                                AttractionTags.GOKART,
                                AttractionTags.SJAELLAND,
                                AttractionTags.FART
                        )
                )
        );

        addAttraction(new TouristAttraction(
                        "Prøvekør Drømmebilen - Porsche 911 Carrera S",
                        """
                                Lej din drømmebil for en dag! Oplev drømmen og prøv en af verdens mest berømte biler - Porsche 911 Carrera S. Bilen er i sort metallic med sort læderindtræk og baghjulstræk ligesom en rigtig Porsche 911 skal være.
                                
                                Bilen er desuden udstyret med et sportsudstødningssystem for at få mere lyd i bilen og et Bose lydsystem, så du kan nyde din yndlingsmusik, mens du kører. Udover det er den også udstyret med lir i form af Porsche active suspension management, 8-trins dobbeltkoblingsboks, Apple carplay og glassoltag.
                                """,
                        DanishCity.AALBORG,
                        Arrays.asList(
                                AttractionTags.MALMOE,
                                AttractionTags.BILER,
                                AttractionTags.PORSCHE,
                                AttractionTags.FART,
                                AttractionTags.LUKSUS
                        ),
                        2699
                )
        );

        addAttraction(new TouristAttraction(
                        "Tandemspring",
                        """
                                Den ultimative oplevelse med et andet menneske! Tag din ven eller kæreste i hånden, spring ud i det og oplev suset i maven sammen. Denne oplevelse vil uden tvivl knytte bånd for livet.
                                
                                Vores professionelle og specialuddannede instruktører vil guide jer til at udfordre egne grænser i sikre rammer.
                                
                                Et tandemspring er den perfekte anledning til at komme hinanden ved, idet at i fastspændes i hver jeres body-harness, og tager springet sammen.""",
                        DanishCity.HERNING,
                        Arrays.asList(
                                AttractionTags.TANDEM,
                                AttractionTags.HOEJDER,
                                AttractionTags.FRIT_FALD
                        )
                )
        );

        addAttraction(new TouristAttraction(
                        "Bungeejump",
                        """
                                Få et adrenalinsus ud over det sædvanlige med Københavns vildeste oplevelse: bungee jump fra en kran på hele 69 meters højde midt på Refshaleøen. Her får du en unik kombination af fart, frihed og udsigt – du svæver frit med Københavns skyline, havnen og Øresund som baggrund.
                                
                                Uanset om du er erfaren eventyrer eller førstegangshopper, står professionelle instruktører klar til at guide dig trygt gennem oplevelsen. Alt sikkerhedsudstyr er inkluderet, og du får en oplevelse, der garanteret sætter sig på nethinden for livet.
                                
                                Perfekt som gave, som en grænseoverskridende udfordring til dig selv – eller som et uforglemmeligt højdepunkt på dit besøg i København.
                                
                                Er du klar til at tage springet?""",
                        DanishCity.KOEBENHAVN,
                        Arrays.asList(
                                AttractionTags.BUNGEEJUMP,
                                AttractionTags.SJAELLAND,
                                AttractionTags.SNOR
                        ),
                        645
                )
        );
    }

    public List<TouristAttraction> getAttractions() {
        return attractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
        return attraction;
    }

    public TouristAttraction updateAttraction(TouristAttraction updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(updatedAttraction.getName())) {
                attractions.set(i, updatedAttraction);
                return attractions.get(i);
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        TouristAttraction attraction = findAttractionByName(name);
        if (attraction != null) {
            attractions.remove(attraction);
            return attraction;
        }
        return null;
    }

    public List<DanishCity> getCities() {
        return cities;
    }

    public List<AttractionTags> getTags() {
        return tags;
    }

    public CurrencyRates getCurrencyRates() throws IOException {
        //Se evt. mere her: https://forexvalutaomregner.dk/pages/api);
        URL url = new URL("https://cdn.forexvalutaomregner.dk/api/latest.json");

        // Indlæsning af valutakurser
        try (BufferedReader inputFromUrl = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return new Gson().fromJson(inputFromUrl, CurrencyRates.class);
        }
    }
}
