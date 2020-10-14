package com.codecool.lotrservice.controller;

import com.codecool.lotrservice.component.RemoteURLReader;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private String urlEndPoint = "https://the-one-api.dev/v2/character";

    @GetMapping
    public String getCharacters() throws IOException {
        return remoteURLReader.readFromUrl(urlEndPoint);
    }
}
