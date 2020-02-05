package agua.agua.co.mz.model;

public class Clientes {
    private String uid  , bairo , nome , apelido ,zona , nr_da_casa , telefone , latitude , logitude , data;
    private long  posicao;
    private Boolean activo;


    public Clientes(String uid, String bairo, String nome, String apelido, String zona, String nr_da_casa, String telefone, String latitude, String logitude, String data, long posicao, Boolean activo) {
        this.uid = uid;
        this.bairo = bairo;
        this.nome = nome;
        this.apelido = apelido;
        this.zona = zona;
        this.nr_da_casa = nr_da_casa;
        this.telefone = telefone;
        this.latitude = latitude;
        this.logitude = logitude;
        this.data = data;
        this.posicao = posicao;
        this.activo = activo;
    }

    public Clientes() {
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBairo() {
        return bairo;
    }

    public void setBairo(String bairo) {
        this.bairo = bairo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNr_da_casa() {
        return nr_da_casa;
    }

    public void setNr_da_casa(String nr_da_casa) {
        this.nr_da_casa = nr_da_casa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogitude() {
        return logitude;
    }

    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getPosicao() {
        return posicao;
    }

    public void setPosicao(long posicao) {
        this.posicao = posicao;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
