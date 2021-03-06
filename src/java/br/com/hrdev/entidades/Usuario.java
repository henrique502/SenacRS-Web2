/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.entidades;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;

/**
 *
 * @author henriqueschmidt
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name = "usuarios")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNameOrEmail", query = "SELECT u FROM Usuario u WHERE " +
                "(lower(u.nome) like :term OR lower(u.email) like :term)"),
    
    @NamedQuery(name = "Usuario.countAll", query = "SELECT COUNT(u.id) FROM Usuario u"),
    @NamedQuery(name = "Usuario.countByNameOrEmail", query = "SELECT COUNT(u.id) FROM Usuario u WHERE " +
                "(lower(u.nome) like :term OR lower(u.email) like :term)"),
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String FindAll = "Usuario.findAll";
    public static final String FindByNameOrEmail = "Usuario.findByNameOrEmail";
    public static final String CountAll = "Usuario.countAll";
    public static final String CountByNameOrEmail = "Usuario.countByNameOrEmail";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @XmlElement
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    @XmlElement
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    @XmlElement
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @XmlElement
    @Column(name = "senha")
   
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acessos")
    @XmlElement
    private boolean acessos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    @XmlElement
    private List<Comentario> comentarioList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    @XmlElement
    private List<Post> postList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String email, String senha, boolean acessos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acessos = acessos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAcessos() {
        return acessos;
    }

    public void setAcessos(boolean acessos) {
        this.acessos = acessos;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
