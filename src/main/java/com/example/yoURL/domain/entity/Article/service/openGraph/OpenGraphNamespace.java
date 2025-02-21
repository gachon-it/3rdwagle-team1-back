package com.example.yoURL.domain.entity.Article.service.openGraph;

public class OpenGraphNamespace
{
    private String prefix;
    private String schemaURI;

    public OpenGraphNamespace(String prefix, String schemaURI)
    {
        this.prefix = prefix;
        this.schemaURI = schemaURI;
    }

    public String getPrefix()
    {
        return prefix;
    }


    public String getSchemaURI()
    {
        return schemaURI;
    }
}