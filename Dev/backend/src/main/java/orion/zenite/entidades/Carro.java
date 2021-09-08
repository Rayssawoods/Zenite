package orion.zenite.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tblCarro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCarro")
    private int id;

    @Column(name="numeroCarro")
    private String numero;

    @Column(name="placa")
    private String placa;

    @Column(name="modelo")
    private String modelo;

    @Column(name="fabricante")
    private String fabricante;

    @Column(name="acessivel")
    private Boolean acessivel;

    @Column(name="qtdPassageirosSentados")
    private Integer qtdPassageirosSentados;

    @Column(name="qtdPassageirosEmPe")
    private Integer qtdPassageirosEmPe;

    @JsonIgnore
    @OneToMany(mappedBy = "carro", cascade = CascadeType.REMOVE)
    private List<CarroLinha> carroLinhas;

    @JsonIgnore
    @OneToMany(mappedBy = "carro", cascade = CascadeType.REMOVE)
    private List<MotoristaCarro> motoristaCarro;

    @JsonIgnore
    @OneToMany(mappedBy = "carro", cascade = CascadeType.REMOVE)
    private List<Viagem> viagem;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkGerente")
    private Gerente gerente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Boolean isAcessivel() {
        return acessivel;
    }

    public void setAcessivel(Boolean acessivel) {
        this.acessivel = acessivel;
    }

    public Integer getQtdPassageirosSentados() {
        return qtdPassageirosSentados;
    }

    public void setQtdPassageirosSentados(Integer qtdPassageirosSentados) {
        this.qtdPassageirosSentados = qtdPassageirosSentados;
    }

    public Integer getQtdPassageirosEmPe() {
        return qtdPassageirosEmPe;
    }

    public void setQtdPassageirosEmPe(Integer qtdPassageirosEmPe) {
        this.qtdPassageirosEmPe = qtdPassageirosEmPe;
    }

    public Integer getLinhaId() {
        if(carroLinhas.isEmpty()){
            return null;
        }
        return carroLinhas.get(0).getIdLinha();
    }

    public String getLinha() {
        if(carroLinhas.isEmpty()){
            return null;
        }
        Linha linha = carroLinhas.get(0).getLinha();
        String nome = String.format("%s - %s / %s",
                    linha.getNumero(), linha.getPontoIda().getNome(), linha.getPontoVolta().getNome());

        return nome;
    }

    public Linha pegarLinha() {
        if(carroLinhas.isEmpty()){
            return null;
        }
        Linha linha = carroLinhas.get(0).getLinha();
        return linha;
    }

    public String getMotorista() {
        if(motoristaCarro.isEmpty()){
            return null;
        }
        return motoristaCarro.get(0).getMotorista().getNomeFormatado();
    }

    public Integer getMotoristaId() {
        if(motoristaCarro.isEmpty()){
            return null;
        }
        return motoristaCarro.get(0).getMotorista().getId();
    }

    public String getMotoristaTelefone() {
        if(motoristaCarro.isEmpty()){
            return null;
        }
        return motoristaCarro.get(0).getMotorista().getNumeroTelefone();
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
