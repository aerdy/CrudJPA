/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package crudjpa.service;

import crudjpa.doa.MahasiswaDao;
import crudjpa.entity.Mahasiswa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author bahrie
 */
public class ServiceMahasiswa {
    MahasiswaDao mahasiswaDao;
    EntityManager entityManager;

    public ServiceMahasiswa(EntityManager entityManager) {
        setEntityManager(entityManager);
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        mahasiswaDao=new MahasiswaDao();
        mahasiswaDao.setEntityManager(entityManager);
    }

    public void save(Mahasiswa mhs){
        try{
        entityManager.getTransaction().begin();
        mahasiswaDao.save(mhs);
        entityManager.getTransaction().commit();
        }catch(RollbackException ex){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Mahasiswa mhs){
        try{
            entityManager.getTransaction().begin();
            mahasiswaDao.delete(mhs);
            entityManager.getTransaction().commit();
        }catch(RollbackException ex){
            entityManager.getTransaction().rollback();
        }
    }

    public Mahasiswa getMhs(String mhs){
        return mahasiswaDao.getMahasiswa(mhs);
    }

    public List<Mahasiswa> getAllMhs(){
        return mahasiswaDao.getAllMahasiswa();
    }

}
