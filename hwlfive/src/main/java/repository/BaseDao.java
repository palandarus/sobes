package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDao <T>{

    private Class<T> tPClass;
    private String tPClassName;

    private Transaction currentTransaction;
    private Session currentSession;

    public BaseDao(Class<T> tClass) {
        this.tPClass = tPClass;
        this.tPClassName=tPClass.getClass().getName();
    }

    public Session openCurrentSession(SessionFactory sessionFactory){
        currentSession=sessionFactory.openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction(SessionFactory sessionFactory){
        openCurrentSession(sessionFactory);
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentSession.close();;
    }

    public void commitCurrentTransaction(){
        currentTransaction.commit();
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void update (T entity){
        getCurrentSession().update(entity);
    }

    public void persist (T entity){
        getCurrentSession().save(entity);
    }

    public void delete (T entity){
        getCurrentSession().delete(entity);
    }

    public void delete(Long id){
        String query=String.format("DELETE FROM %s WHERE id=%s",tPClassName, id);
        try {
            getCurrentSession().createQuery(query).executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public T findById(Long id){
        return (T)getCurrentSession().get(tPClassName,id);
    }
}
