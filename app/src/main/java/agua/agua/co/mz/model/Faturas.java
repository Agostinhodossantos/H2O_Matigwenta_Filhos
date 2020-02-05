package agua.agua.co.mz.model;

public class Faturas {

    private String uid , mes , ano , dia_pagamento , valor ;
    private boolean estado;
    private long position;

    public Faturas(String uid, String mes, String ano, String dia_pagamento, String valor, boolean estado, long position) {
        this.uid = uid;
        this.mes = mes;
        this.ano = ano;
        this.dia_pagamento = dia_pagamento;
        this.valor = valor;
        this.estado = estado;
        this.position = position;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDia_pagamento() {
        return dia_pagamento;
    }

    public void setDia_pagamento(String dia_pagamento) {
        this.dia_pagamento = dia_pagamento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }
}
