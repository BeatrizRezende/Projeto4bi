/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Biah
 */
@Entity
@Table(name = "cozinheiro", catalog = "bd_restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cozinheiro.findAll", query = "SELECT c FROM Cozinheiro c"),
    @NamedQuery(name = "Cozinheiro.findByIdCozinheiro", query = "SELECT c FROM Cozinheiro c WHERE c.idCozinheiro = :idCozinheiro"),
    @NamedQuery(name = "Cozinheiro.findByNome", query = "SELECT c FROM Cozinheiro c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cozinheiro.findByTipoDaComida", query = "SELECT c FROM Cozinheiro c WHERE c.tipoDaComida = :tipoDaComida"),
    @NamedQuery(name = "Cozinheiro.findByPedido", query = "SELECT c FROM Cozinheiro c WHERE c.pedido = :pedido")})
public class Cozinheiro implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCozinheiro")
    private Integer idCozinheiro;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "TipoDaComida")
    private String tipoDaComida;
    @Column(name = "pedido")
    private String pedido;
    
    
    @OneToMany (mappedBy = "cozinheiro")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cozinheiro() {
    }

    public Cozinheiro(Integer idCozinheiro) {
        this.idCozinheiro = idCozinheiro;
    }

    public Integer getIdCozinheiro() {
        return idCozinheiro;
    }

    public void setIdCozinheiro(Integer idCozinheiro) {
        Integer oldIdCozinheiro = this.idCozinheiro;
        this.idCozinheiro = idCozinheiro;
        changeSupport.firePropertyChange("idCozinheiro", oldIdCozinheiro, idCozinheiro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTipoDaComida() {
        return tipoDaComida;
    }

    public void setTipoDaComida(String tipoDaComida) {
        String oldTipoDaComida = this.tipoDaComida;
        this.tipoDaComida = tipoDaComida;
        changeSupport.firePropertyChange("tipoDaComida", oldTipoDaComida, tipoDaComida);
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        String oldPedido = this.pedido;
        this.pedido = pedido;
        changeSupport.firePropertyChange("pedido", oldPedido, pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCozinheiro != null ? idCozinheiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cozinheiro)) {
            return false;
        }
        Cozinheiro other = (Cozinheiro) object;
        if ((this.idCozinheiro == null && other.idCozinheiro != null) || (this.idCozinheiro != null && !this.idCozinheiro.equals(other.idCozinheiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
