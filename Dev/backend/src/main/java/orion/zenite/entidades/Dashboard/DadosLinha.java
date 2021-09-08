package orion.zenite.entidades.Dashboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vwDadosLinha")
public class DadosLinha {

    @Id
    @Column(name = "numero_da_linha")
    private String numeroLinha;

    @Column(name = "id_linha")
    private Integer idLinha;

    @Column(name = "fiscal_ida")
    private String fiscalIda;

    @Column(name = "fiscal_volta")
    private String fiscalVolta;

    @Column(name = "media_viagem")
    private Integer mediaViagem;

    @Column(name = "qtd_carros_circulando")
    private Integer qtdCarrosCirculando;

    @Column(name = "qtd_motorista")
    private Integer qtdMotorista;

    public Integer getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Integer idLinha) {
        this.idLinha = idLinha;
    }

    public Integer getQtdMotorista() {
        return qtdMotorista;
    }

    public void setQtdMotorista(Integer qtdMotorista) {
        this.qtdMotorista = qtdMotorista;
    }

    public String getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(String numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    public String getFiscalIda() {
        return fiscalIda;
    }

    public void setFiscalIda(String fiscalIda) {
        this.fiscalIda = fiscalIda;
    }

    public String getFiscalVolta() {
        return fiscalVolta;
    }

    public void setFiscalVolta(String fiscalVolta) {
        this.fiscalVolta = fiscalVolta;
    }

    public Integer getMediaViagem() {
        return mediaViagem;
    }

    public void setMediaViagem(Integer mediaViagem) {
        this.mediaViagem = mediaViagem;
    }

    public Integer getQtdCarrosCirculando() {
        return qtdCarrosCirculando;
    }

    public void setQtdCarrosCirculando(Integer qtdCarrosCirculando) {
        this.qtdCarrosCirculando = qtdCarrosCirculando;
    }
}
