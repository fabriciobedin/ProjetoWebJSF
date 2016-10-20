/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fabricio
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByPrdCodigo", query = "SELECT p FROM Produto p WHERE p.prdCodigo = :prdCodigo"),
    @NamedQuery(name = "Produto.findByPrdDescricao", query = "SELECT p FROM Produto p WHERE p.prdDescricao = :prdDescricao"),
    @NamedQuery(name = "Produto.findByPrdDatahora", query = "SELECT p FROM Produto p WHERE p.prdDatahora = :prdDatahora"),
    @NamedQuery(name = "Produto.findByPrdValorunitario", query = "SELECT p FROM Produto p WHERE p.prdValorunitario = :prdValorunitario"),
    @NamedQuery(name = "Produto.findByPrdAtivo", query = "SELECT p FROM Produto p WHERE p.prdAtivo = :prdAtivo")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prd_codigo")
    private Integer prdCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "prd_descricao")
    private String prdDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_datahora")
    @Temporal(TemporalType.DATE)
    private Date prdDatahora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_valorunitario")
    private BigDecimal prdValorunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_ativo")
    private boolean prdAtivo;
    @JoinColumn(name = "usr_codigo", referencedColumnName = "usr_codigo")
    @ManyToOne(optional = false)
    private Usuario usrCodigo;
    @OneToMany(mappedBy = "prdCodigo")
    private Collection<Compraproduto> compraprodutoCollection;

    public Produto() {
    }

    public Produto(Integer prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public Produto(Integer prdCodigo, String prdDescricao, Date prdDatahora, BigDecimal prdValorunitario, boolean prdAtivo) {
        this.prdCodigo = prdCodigo;
        this.prdDescricao = prdDescricao;
        this.prdDatahora = prdDatahora;
        this.prdValorunitario = prdValorunitario;
        this.prdAtivo = prdAtivo;
    }

    public Integer getPrdCodigo() {
        return prdCodigo;
    }

    public void setPrdCodigo(Integer prdCodigo) {
        this.prdCodigo = prdCodigo;
    }

    public String getPrdDescricao() {
        return prdDescricao;
    }

    public void setPrdDescricao(String prdDescricao) {
        this.prdDescricao = prdDescricao;
    }

    public Date getPrdDatahora() {
        return prdDatahora;
    }

    public void setPrdDatahora(Date prdDatahora) {
        this.prdDatahora = prdDatahora;
    }

    public BigDecimal getPrdValorunitario() {
        return prdValorunitario;
    }

    public void setPrdValorunitario(BigDecimal prdValorunitario) {
        this.prdValorunitario = prdValorunitario;
    }

    public boolean getPrdAtivo() {
        return prdAtivo;
    }

    public void setPrdAtivo(boolean prdAtivo) {
        this.prdAtivo = prdAtivo;
    }

    public Usuario getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(Usuario usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    @XmlTransient
    public Collection<Compraproduto> getCompraprodutoCollection() {
        return compraprodutoCollection;
    }

    public void setCompraprodutoCollection(Collection<Compraproduto> compraprodutoCollection) {
        this.compraprodutoCollection = compraprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdCodigo != null ? prdCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.prdCodigo == null && other.prdCodigo != null) || (this.prdCodigo != null && !this.prdCodigo.equals(other.prdCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entity.Produto[ prdCodigo=" + prdCodigo + " ]";
    }
    
}
