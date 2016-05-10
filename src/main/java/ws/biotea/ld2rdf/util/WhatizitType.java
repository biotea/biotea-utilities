package ws.biotea.ld2rdf.util;

public enum WhatizitType {
    GO("go"),
    UNIPROT("uniprot"),
    E("e"),
    SPECIES("species"),
    CHEBI("chebi"),
    DISEASE("disease"),
    DRUG("drug");

    private String type;
    private WhatizitType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
