package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RankingEntity {
    private Integer id;
    private Integer idVoluntario;
    private Integer idTarea;
    private Integer valorRanking;

    public RankingEntity(Integer idVoluntario, Integer idTarea, Integer valorRanking) {
        this.idVoluntario = idVoluntario;
        this.idTarea = idTarea;
        this.valorRanking = valorRanking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Integer idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getValorRanking() {
        return valorRanking;
    }

    public void setValorRanking(Integer valorRanking) {
        this.valorRanking = valorRanking;
    }
}
