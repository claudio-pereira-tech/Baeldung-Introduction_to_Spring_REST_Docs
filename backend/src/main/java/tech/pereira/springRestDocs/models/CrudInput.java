package tech.pereira.springRestDocs.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.net.URI;
import java.util.Collections;
import java.util.List;

public class CrudInput {

    @NotNull
    private long id;

    @NotBlank
    private String title;

    private String body;

    private List<URI> tagUris;

    @JsonCreator
    public CrudInput(@JsonProperty("id") long id, @JsonProperty("title") String title, @JsonProperty("body") String body, @JsonProperty("tags") List<URI> tagUris) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tagUris = tagUris == null ? Collections.<URI> emptyList() : tagUris;
    }

    @NotNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("tags")
    public List<URI> getTagUris() {
        return tagUris;
    }

    public void setTagUris(List<URI> tagUris) {
        this.tagUris = tagUris;
    }
}
