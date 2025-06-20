package br.com.gestaofinanceira.domain.categoria.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaEntity extends PanacheEntity {

    @Column(nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CategoriaEntity [id=" + super.id + ", descricao=" + descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((super.id == null) ? 0 : super.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoriaEntity other = (CategoriaEntity) obj;
        if (super.id == null) {
            if (other.id != null)
                return false;
        } else if (!super.id.equals(other.id))
            return false;
        return true;
    }
    
    
}