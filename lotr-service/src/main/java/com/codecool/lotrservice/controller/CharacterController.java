package com.codecool.lotrservice.controller;

import com.codecool.lotrservice.component.RemoteURLReader;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private RemoteURLReader remoteURLReader;

    private String urlEndPoint = "https://the-one-api.dev/v2/character";

    @GetMapping
    public Json getCharacters() throws IOException, JSONException {
        String result = remoteURLReader.readFromUrl(urlEndPoint);
        JSONObject resultJson = new JSONObject(result);
        resultJson.put("status", "200 OK");
        System.out.println(resultJson);
        return new Json(resultJson.toString());
    }
}
