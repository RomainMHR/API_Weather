package com.example.ubo.weatherapi.mapper;

import dto.weatherapi.VisibilityEnum;

public class VisibilityMapper {

    public static VisibilityEnum fromOpenWeather(int visibility) {
        if (visibility <= 1000) {
            return VisibilityEnum.NEIGE; // ou ORAGEUX selon météo extrême
        } else if (visibility <= 4000) {
            return VisibilityEnum.PLUVIEUX;
        } else if (visibility < 10000) {
            return VisibilityEnum.NUAGEUX;
        } else { // visibilité maximale
            return VisibilityEnum.ENSOLEILLE;
        }
    }
}

