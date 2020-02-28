/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wises.database.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jvito
 */
@Entity
@Table(name = "sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findById", query = "SELECT s FROM Sala s WHERE s.id = :id"),
    @NamedQuery(name = "Sala.findByNome", query = "SELECT s FROM Sala s WHERE s.nome = :nome"),
    @NamedQuery(name = "Sala.findByQuantidadePessoasSentadas", query = "SELECT s FROM Sala s WHERE s.quantidadePessoasSentadas = :quantidadePessoasSentadas"),
    @NamedQuery(name = "Sala.findByPossuiMultimidia", query = "SELECT s FROM Sala s WHERE s.possuiMultimidia = :possuiMultimidia"),
    @NamedQuery(name = "Sala.findByPossuiAC", query = "SELECT s FROM Sala s WHERE s.possuiAC = :possuiAC"),
    @NamedQuery(name = "Sala.findByAreaDaSala", query = "SELECT s FROM Sala s WHERE s.areaDaSala = :areaDaSala"),
    @NamedQuery(name = "Sala.findByLocalizacao", query = "SELECT s FROM Sala s WHERE s.localizacao = :localizacao"),
    @NamedQuery(name = "Sala.findByLatitude", query = "SELECT s FROM Sala s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Sala.findByLongitude", query = "SELECT s FROM Sala s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Sala.findByAtivo", query = "SELECT s FROM Sala s WHERE s.ativo = :ativo"),
    @NamedQuery(name = "Sala.findByDataCriacao", query = "SELECT s FROM Sala s WHERE s.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Sala.findByDataAlteracao", query = "SELECT s FROM Sala s WHERE s.dataAlteracao = :dataAlteracao"),
    @NamedQuery(name = "Sala.findByOrganizacaoId", query = "SELECT s FROM Sala s JOIN s.idOrganizacao o WHERE o.id = :idOrganizacao"),
    @NamedQuery(name = "Sala.findByUrlImagem", query = "SELECT s FROM Sala s WHERE s.urlImagem = :urlImagem")
    })
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidadePessoasSentadas")
    private Integer quantidadePessoasSentadas;
    @Column(name = "possuiMultimidia")
    private Boolean possuiMultimidia;
    @Column(name = "possuiAC")
    private Boolean possuiAC;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "areaDaSala")
    private BigDecimal areaDaSala;
    @Size(max = 64)
    @Column(name = "localizacao")
    private String localizacao;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "ativo")
    private Boolean ativo;
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Column(name = "dataAlteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @Size(max = 300)
    @Column(name = "urlImagem")
    private String urlImagem;
    @OneToMany(mappedBy = "idSala")
    private Collection<AlocacaoSala> alocacaoSalaCollection;
    @JoinColumn(name = "idOrganizacao", referencedColumnName = "id")
    @ManyToOne
    private Organizacao idOrganizacao;

    public Sala() {
    }

    public Sala(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadePessoasSentadas() {
        return quantidadePessoasSentadas;
    }

    public void setQuantidadePessoasSentadas(Integer quantidadePessoasSentadas) {
        this.quantidadePessoasSentadas = quantidadePessoasSentadas;
    }

    public Boolean getPossuiMultimidia() {
        return possuiMultimidia;
    }

    public void setPossuiMultimidia(Boolean possuiMultimidia) {
        this.possuiMultimidia = possuiMultimidia;
    }

    public Boolean getPossuiAC() {
        return possuiAC;
    }

    public void setPossuiAC(Boolean possuiAC) {
        this.possuiAC = possuiAC;
    }

    public BigDecimal getAreaDaSala() {
        return areaDaSala;
    }

    public void setAreaDaSala(BigDecimal areaDaSala) {
        this.areaDaSala = areaDaSala;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    
    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @XmlTransient
    public Collection<AlocacaoSala> getAlocacaoSalaCollection() {
        return alocacaoSalaCollection;
    }

    public void setAlocacaoSalaCollection(Collection<AlocacaoSala> alocacaoSalaCollection) {
        this.alocacaoSalaCollection = alocacaoSalaCollection;
    }

    public Organizacao getIdOrganizacao() {
        return idOrganizacao;
    }

    public void setIdOrganizacao(Organizacao idOrganizacao) {
        this.idOrganizacao = idOrganizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.wises.database.pojo.Sala[ id=" + id + " ]";
    }
    
}