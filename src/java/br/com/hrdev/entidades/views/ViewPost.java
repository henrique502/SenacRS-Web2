package br.com.hrdev.entidades.views;

import br.com.hrdev.helpers.StringHelper;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henriqueschmidt
 */
@Entity
@Table(name = "view_posts")
@XmlRootElement
public class ViewPost implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "conteudo")
    private String conteudo;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "comentarios")
    private long comentarios;

    public ViewPost() {
    }

    public int getId() {
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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getComentarios() {
        return comentarios;
    }

    public void setComentarios(long comentarios) {
        this.comentarios = comentarios;
    }
    
    public String getSmallConteudo(){
        return StringHelper.characterLimiter(StringHelper.stripTags(conteudo), 250);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
