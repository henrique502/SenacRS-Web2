/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hrdev.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "posts")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p ORDER BY p.data DESC"),
    @NamedQuery(name = "Post.findByTitulo", query = "SELECT p FROM Post p WHERE (lower(p.titulo) like :term) ORDER BY p.data DESC"),
    @NamedQuery(name = "Post.countAll", query = "SELECT COUNT(p.id) FROM Post p"),
    @NamedQuery(name = "Post.countByTitulo", query = "SELECT COUNT(p.id) FROM Post p WHERE (lower(p.titulo) like :term)"),
    @NamedQuery(name = "Post.getPostById", query = "SELECT p FROM Post p WHERE p.id = :postId")
})
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String FindAll = "Post.findAll";
    public static final String FindByTitulo = "Post.findByTitulo";
    public static final String CountAll = "Post.countAll";
    public static final String CountTitulo = "Post.countByTitulo";
    public static final String GetPostById = "Post.getPostById";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @XmlElement
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "titulo")
    @XmlElement
    private String titulo;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "conteudo")
    @XmlElement
    private String conteudo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlElement
    private Date data;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @XmlElement
    private List<Comentario> comentarioList;
    
    @JoinColumn(name = "autor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @XmlElement
    private Usuario autor;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String titulo, String conteudo, Date data) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hrdev.entidades.Post[ id=" + id + " ]";
    }
    
}
