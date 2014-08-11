/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crudjpa.doa;

import crudjpa.entity.Mahasiswa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author bahrie
 */
public class MahasiswaDao {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Mahasiswa mhs) {
        try {
            if (mhs.getId() == null) {
                entityManager.persist(mhs);
            } else {
                entityManager.merge(mhs);
            }
        } catch (RollbackException ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Mahasiswa mhs){
        entityManager.remove(mhs);
    }

    public Mahasiswa getMahasiswa(String id){
        return entityManager.find(Mahasiswa.class, id);
    }

    public List<Mahasiswa> getAllMahasiswa(){
        return entityManager.createQuery("select m from Mahasiswa m").getResultList();
    }
}
