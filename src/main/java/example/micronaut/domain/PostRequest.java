package example.micronaut.domain;

import javax.validation.constraints.NotNull;

public class PostRequest {

    @NotNull(message = "uno cannot be null")
    private String uno;

    private String dos;

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }
}
