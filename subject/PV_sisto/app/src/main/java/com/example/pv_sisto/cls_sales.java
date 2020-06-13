package com.example.pv_sisto;

public class cls_sales {



    public cls_sales(){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getFK_ID_ch() {
        return FK_ID_ch;
    }

    public void setFK_ID_ch(Integer FK_ID_ch) {
        this.FK_ID_ch = FK_ID_ch;
    }

    public Integer getID_ch() {
        return ID_ch;
    }

    public void setID_ch(Integer ID_ch) {
        this.ID_ch = ID_ch;
    }

    public Double getSubtot() {
        return subtot;
    }

    public void setSubtot(Double subtot) {
        this.subtot = subtot;
    }

    public Double getTota() {
        return tota;
    }

    public void setTota(Double tota) {
        this.tota = tota;
    }
    public Double getIv() {
        return iv;
    }

    public void setIv(Double iv) {
        this.iv = iv;
    }
    public Integer getQuantit() {
        return quantit;
    }

    public void setQuantit(Integer quantit) {
        this.quantit = quantit;
    }

    private Integer code;
    private Integer FK_ID_ch;
    private Integer ID_ch;
    private Double subtot;
    private Double tota;


    private Integer quantit;

    private Double iv;
}
