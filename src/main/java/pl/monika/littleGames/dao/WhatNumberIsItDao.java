package pl.monika.littleGames.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.monika.littleGames.model.WhatNumberIsItComment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WhatNumberIsItDao {
    private static final Logger LOG = Logger.getLogger(WhatNumberIsItDao.class.getName());
    private ObjectMapper objectMapper;

    public WhatNumberIsItDao() {
        this.objectMapper = new ObjectMapper();
    }

    public String showDescription() {
        try {
            String description = Files.readString(Paths.get("./WhatNumberIsItDescription.txt"));
            return description;
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on showDescription", e);
            return "";
        }
    }

    public List<WhatNumberIsItComment> getComments() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./WhatNumberIsItComments.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on findAllComments", e);
            return new ArrayList<>();
        }
    }

    public List<WhatNumberIsItComment> findAllComments() {
        return getComments();
    }

    public void addComment(WhatNumberIsItComment whatNumberIsItComment) {
        try {
            List<WhatNumberIsItComment> whatNumberIsItComments = getComments();
            whatNumberIsItComments.add(whatNumberIsItComment);
            Files.writeString(Paths.get("./WhatNumberIsItComments.txt"), objectMapper.writeValueAsString(whatNumberIsItComments));
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addComment", e);
        }
    }

    public void removeComment(WhatNumberIsItComment whatNumberIsItComment) {
        try {
            List<WhatNumberIsItComment> whatNumberIsItComments = getComments();
            whatNumberIsItComments.remove(whatNumberIsItComment);
            Files.writeString(Paths.get("./WhatNumberIsItComments.txt"), objectMapper.writeValueAsString(whatNumberIsItComments));
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on deleteComment", e);
        }
    }
}
