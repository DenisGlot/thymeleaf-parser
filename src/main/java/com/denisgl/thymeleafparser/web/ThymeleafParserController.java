package com.denisgl.thymeleafparser.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class ThymeleafParserController {

    private final TemplateEngine emailTemplateEngine;
    private final ObjectMapper objectMapper;

    @PostMapping("/")
    public String parseThymeleafTemplate(
            @RequestParam("params") String params,
            @RequestParam("file") MultipartFile file) throws IOException {
        Context context = new Context();
        context.setVariables(objectMapper.readValue(params, HashMap.class));
        return emailTemplateEngine.process(new String(file.getBytes()), context);
    }
}
