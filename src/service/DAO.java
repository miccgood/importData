/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import Entity.Capital;
import ERP_PC.PcAuction;
import ERP_PC.PcAuctionType;
import ERP_PC.PcInsureKind;
import ERP_PC.PcInsureType;
import ERP_PC.PcOrder;
import ERP_PS.VPsPerson;
import Entity.ERP_AC.AcAccount;
import Entity.ERP_AC.AcCounter;
import Entity.ERP_AC.AcCreditCardType;
import Entity.ERP_FI.FiCapital;
import Entity.ERP_FI.FiCapitalFounder;
import Entity.ERP_FI.FiFund;
import Entity.ERP_SH.FwSequenceGenerator;
import Entity.ERP_SH.ShBank;
import Entity.ERP_SH.ShBankBranch;
import Entity.ERP_SH.ShDepartment;
import Entity.ERP_SH.ShEnterprise;
import Entity.ERP_SH.ShFormRunning;
import Entity.ERP_SH.ShFormType;
import Entity.ERP_SH.ShMemberType;
import Entity.ERP_SH.ShPerson;
import Entity.ERP_SH.ShPlan;
import Entity.ERP_SH.ShSource;
import Entity.ERP_SH.ShSubAccount;
import Entity.ERP_SH.ShTitle;
import Entity.ERP_SH.VShRegion;
import Entity.ERP_SH.VShSupplier;
import Entity.Sys.Sqlprimarykeys;
import GUI.TestGUI;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static java.util.Collections.EMPTY_LIST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Id;
import javax.persistence.Query;
import org.eclipse.persistence.config.FlushClearCache;
import org.eclipse.persistence.config.PersistenceUnitProperties;
/**
 *
 * @author momo-pc
 */
public class DAO {
    
    
    /** Create Entity Manager  Factory**/
    public EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("PersistenceDB2");
    public EntityManager entityManager;// = emf.createEntityManager();
    public EntityTransaction tx;// = entityManager.getTransaction();
    private static final Map<String, String> primaryKeyMap = new HashMap<>();
    private static DAO dao = null;
    public DAO(String host, String database, String username, String password){
           
        Map<String, String> map = new HashMap<>();
        map.put("javax.persistence.jdbc.url", "jdbc:db2://"+host+":50000/" + database + ":currentSchema=ERP_APP;");
        map.put("javax.persistence.jdbc.user", username);
        map.put("javax.persistence.jdbc.password", password);
        map.put("javax.persistence.jdbc.driver", "com.ibm.db2.jcc.DB2Driver");

        if(emf != null && emf.isOpen()){
            emf.close();
        }
        
//        map.put(PersistenceUnitProperties.FLUSH_CLEAR_CACHE, FlushClearCache.Drop);
        emf = Persistence.createEntityManagerFactory("PersistenceDB2", map );
        entityManager = emf.createEntityManager();
        tx = entityManager.getTransaction();
    }

    public DAO(String username, String password){
        this("192.168.8.10", "TRC_LPA", username, password);
    }
    
    public DAO(){
        this(TestGUI.getHost(), TestGUI.getDatabase(), TestGUI.getUsername(), TestGUI.getPassword());
    }
        
    public DAO getInstanct(){
        return dao;
    }
    
    public void startConnection(){
        emf = Persistence.createEntityManagerFactory("PersistenceDB2");
        entityManager = emf.createEntityManager();
    }
    
    public void startTransaction(){
        tx.begin();
    }

    public void commitTransaction(boolean commit){
        if(commit){
            tx.commit();
        }else{
            tx.rollback();
        }
        
    }
    
    public void flush(){
        entityManager.flush();
    }
    
    public void closeConnection(){
        entityManager.close();
//        Map<String, Object> map = emf.getProperties();
        emf.close();
    }
    
    public void addEntity(Object entity){
        entityManager.persist(entity);
        entityManager.flush();
    }
    
    public void addPcAuction(PcAuction auction){
        entityManager.persist(auction);
    }
    
    public void addPcOrder(PcOrder order){
        entityManager.persist(order);
    }
    
    public void updateEntity(Object entity){
        entityManager.merge(entity);
    }
    
    public void updateCounter(String tableGen, String table, String primaryKey){
    if(tableGen.equals(table)){
        return;
    }
    StringBuilder sql = new StringBuilder();
    sql.append("UPDATE ")
            .append(tableGen)
            .append(" SET VALUE = NVL((SELECT NVL(MAX(").append(primaryKey).append("),0) FROM ").append(table)
            .append("),0)+ 1 WHERE NAME = '").append(table).append("'");

    Query query = entityManager.createNativeQuery(sql.toString());

        int resut = query.executeUpdate();
    }
    
    @SuppressWarnings("empty-statement")
    public Object findEntity(Object entity) {
        Integer primaryKey = getPrimaryKey(entity);
        return entityManager.find(entity.getClass(), primaryKey);
    }
    
    private Integer getPrimaryKey(Object entity){
        try {
            String[] className = entity.getClass().toString().split(" ");
            Class c = Class.forName(className[className.length-1]);
            for(Field field : c.getDeclaredFields()){
                Class type = field.getType();
                String name = field.getName();
                Annotation[] annotations = field.getDeclaredAnnotations(); //do something to these
                for (Annotation annotation : annotations) {
                    if(annotation.annotationType().equals(javax.persistence.Id.class)){
                        Method meth = c.getMethod(toGetMethodName(name));
                        return (Integer) meth.invoke(entity);
                    }
                }
            } 
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
        }
        
        return null;
    }
    
    private String toGetMethodName(String name){
        StringBuilder ret = new StringBuilder();
        return ret.append("get").append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).toString();
    }
    
    
    public void addShFormRunning(ShFormRunning formRunning){
        entityManager.persist(formRunning);
        entityManager.flush();
    }
    
    public void createFiCapital(FiCapital capital){
        entityManager.persist(capital);
//        entityManager.flush();
    }
    public void createShPerson(ShPerson person){
        entityManager.persist(person);
//        entityManager.flush();
    }
    public void createFiCapitalFounder(FiCapitalFounder capitalFounder){
        entityManager.persist(capitalFounder);
//        entityManager.flush();
    }
    
    public FiFund findFiFund(FiFund fund){
        FiFund fundDao = (FiFund) entityManager.find(FiFund.class, fund.getFundId().intValue());
        return fundDao;
    }
    
    public List<ShEnterprise> getEnterprises() { 
        
        Query query = entityManager.createQuery(" SELECT o FROM ShEnterprise o ");
        query.setFlushMode(FlushModeType.COMMIT);
        List list = query.getResultList();
        if (list != null && !list.isEmpty()) {
                return list;
        }
        return EMPTY_LIST;
//--
    }
     
    public ShDepartment findDepartmentByFullCode(Integer enterpriseId, String fullCode) {
        String sql = "SELECT a.* FROM SH_DEPARTMENT_VIEW a WHERE a.DEPARTMENT_ID in (SELECT o1.DEPARTMENT_ID FROM SH_DEPARTMENT_VIEW o1 JOIN SH_DEPARTMENT_CHART o2 ON (o1.DEPARTMENT_CHART_ID = o2.DEPARTMENT_CHART_ID) WHERE o1.FULL_CODE = ? AND o2.ENTERPRISE_ID = ?) ORDER BY a.TREE_LEFT";
//--
    Query query = entityManager.createNativeQuery(sql,ShDepartment.class);
//        Query query = entityManager.createQuery("SELECT d FROM ShDepartment d WHERE d.fullCode = :fullcode");
        query.setParameter(1, fullCode);
        query.setParameter(2, enterpriseId);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShDepartment> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 

        return null;
    }
    
    public FiFund findFundByFundCode(String fundCode, Integer departmentId) {
        Query query = entityManager.createQuery("SELECT f FROM FiFund f WHERE f.fundCode = :fundCode AND f.departmentId = :departmentId ");
        query.setParameter("fundCode", fundCode);
        query.setParameter("departmentId", departmentId);
        query.setFlushMode(FlushModeType.COMMIT);
        List<FiFund> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
           
    public ShFormType findShFormTypeByFormTypeCode(String formTypeCode) {
        Query query = entityManager.createNamedQuery("ShFormType.findByFormTypeCode", ShFormType.class);
        query.setParameter("formTypeCode", formTypeCode);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShFormType> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    
    public PcAuctionType findPcAuctionTypeByAuctionTypeId(Integer auctionTypeId) {
        Query query = entityManager.createNamedQuery("PcAuctionType.findByAuctionTypeId", PcAuctionType.class);
        query.setParameter("auctionTypeId", auctionTypeId);
        query.setFlushMode(FlushModeType.COMMIT);
        List<PcAuctionType> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    public AcCounter findAcCounterByName(String name) {
        Query query = entityManager.createNamedQuery("AcCounter.findByName", AcCounter.class);
        query.setParameter("name", name);
        query.setFlushMode(FlushModeType.COMMIT);
        List<AcCounter> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public List<AcCounter> getAcCounter() {
        Query query = entityManager.createQuery("SELECT a FROM AcCounter a", AcCounter.class);
        query.setFlushMode(FlushModeType.COMMIT);
        List<AcCounter> list = query.getResultList();
        return list;
    }
    
    
    public List<FwSequenceGenerator> getFwSequenceGenerator() {
        Query query = entityManager.createNamedQuery("FwSequenceGenerator.findAll", FwSequenceGenerator.class);
        query.setFlushMode(FlushModeType.COMMIT);
        List<FwSequenceGenerator> list = query.getResultList();
        return list;
    }
    
    
    public ShMemberType findShMemberTypeByName(String name) {
        Query query = entityManager.createNamedQuery("AcCounter.findByName", ShMemberType.class);
        query.setParameter("name", name);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShMemberType> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public ShFormRunning findShFormRunningByFormTypeCode(String formTypeCode) {
        Query query = entityManager.createNamedQuery("ShFormType.findByFormTypeCode", ShFormRunning.class);
        query.setParameter("formTypeCode", formTypeCode);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShFormRunning> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    public ShFormRunning getNewSeqNoFormRunningNo(Integer businessUnitId, String formTypeCode, String prefixLetter, String charCombine1, String charCombine2, String charCombine3) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT FR.* ")
            .append("FROM SH_FORM_RUNNING FR ")
            .append("WHERE FR.BUSINESS_UNIT_ID = ? AND ")
            .append("FR.FORM_TYPE_CODE = ? AND ")
            .append("FR.PREFIX_LETTER = ? AND ")
            .append("FR.CHAR_COMBINE_1 = ? AND ")
            .append("FR.CHAR_COMBINE_2 = ? AND ")
            .append("FR.CHAR_COMBINE_3 = ? ");

        Query query = entityManager.createNativeQuery(sql.toString(), ShFormRunning.class);
        query.setParameter(1, businessUnitId);
        query.setParameter(2, formTypeCode);
        query.setParameter(3, prefixLetter);
        query.setParameter(4, charCombine1);
        query.setParameter(5, charCombine2);
        query.setParameter(6, charCombine3);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShFormRunning> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }

			
    public VShRegion findRegionByFullName(String fullName) {
        Query query = entityManager.createNamedQuery("VShRegion.findByFullName", VShRegion.class);
        query.setParameter("fullName", fullName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<VShRegion> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public ShTitle findTitleByTitleName(String titleName) {
        
        Query query = entityManager.createNamedQuery("ShTitle.findByTitleName", ShTitle.class);
        query.setParameter("titleName", titleName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShTitle> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public ShBank findShBankByBankName(String bankName) {
        
        Query query = entityManager.createNamedQuery("ShBank.findByBankName", ShBank.class);
        query.setParameter("bankName", bankName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShBank> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public ShBankBranch findShBankBranchByBankBranchNameAndBankId(String bankBranchName, Integer bankId) {
        Query query = entityManager.createNamedQuery("ShBankBranch.findByBankBranchName", ShBankBranch.class);
        query.setParameter("bankBranchName", bankBranchName);
        query.setParameter("bankId", bankId);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShBankBranch> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public AcCreditCardType findAcCreditCardTypeByName(String name) {
        
        Query query = entityManager.createNamedQuery("AcCreditCardType.findByName", AcCreditCardType.class);
        query.setParameter("name", name);
        query.setFlushMode(FlushModeType.COMMIT);
        List<AcCreditCardType> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public PcInsureType findPcInsureTypeByName(String insureTypeName) {
        Query query = entityManager.createNamedQuery("PcInsureType.findByInsureTypeName", PcInsureType.class);
        query.setParameter("insureTypeName", insureTypeName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<PcInsureType> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public PcInsureKind findPcInsureKindByName(String insureKindName) {
        Query query = entityManager.createNamedQuery("PcInsureKind.findByInsureKindName", PcInsureKind.class);
        query.setParameter("insureKindName", insureKindName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<PcInsureKind> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public FiFund findAccountByFullCode(String fundCode) {
    
        Query query = entityManager.createQuery("SELECT f FROM FiFund f WHERE f.fundCode = :");
        query.setParameter(1, fundCode);
        query.setFlushMode(FlushModeType.COMMIT);
        List<FiFund> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }

    public VPsPerson findVPsPersonByPersonCode(String personCode) {
        Query query = entityManager.createNamedQuery("VPsPerson.findByPersonCode", VPsPerson.class);
        query.setParameter("personCode", personCode);
        query.setFlushMode(FlushModeType.COMMIT);
        List<VPsPerson> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    public VShSupplier findVShSupplierByFullName(String fullName) {
        Query query = entityManager.createNamedQuery("VShSupplier.findByFullName", VShSupplier.class);
        query.setParameter("fullName", fullName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<VShSupplier> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    public List<AcAccount> getAccountByFullCode(Integer enterpriseId, String fullCode) {
        String sql = "SELECT a.* FROM AC_ACCOUNT a WHERE a.ACCOUNT_ID in (SELECT o1.ACCOUNT_ID FROM AC_ACCOUNT_VIEW o1 JOIN AC_ACCOUNT_CHART o2 ON (o1.CHART_ID = o2.CHART_ID) WHERE o1.FULL_CODE = ? AND o2.ENTERPRISE_ID = ?) ORDER BY a.TREE_LEFT";
        
        Query query = entityManager.createNativeQuery(sql, AcAccount.class);
        query.setParameter(1, fullCode);
        query.setParameter(2, enterpriseId);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
    
    public List<ShSource> getSourceByFullCode(Integer enterpriseId, String fullCode) {
        String sql = "SELECT a.* FROM SH_SOURCE a WHERE a.SOURCE_ID in (SELECT o1.SOURCE_ID FROM SH_SOURCE_VIEW o1 JOIN SH_SOURCE_CHART o2 ON (o1.SOURCE_CHART_ID = o2.SOURCE_CHART_ID) WHERE o1.IS_LEAF = 'Y' AND o1.FULL_CODE = ? AND o2.ENTERPRISE_ID = ?) ORDER BY a.TREE_LEFT";
        Query query = entityManager.createNativeQuery(sql, ShSource.class);
        query.setParameter(1, fullCode);
        query.setParameter(2, enterpriseId);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
     public List<ShSubAccount> getSubAccountByFullCode(String fullCode, Integer departmentId, Integer sourceId) {
            
        String sql = "SELECT * FROM SH_SUB_ACCOUNT sa WHERE sa.SUB_ACCOUNT_CODE = ? AND sa.DEPARTMENT_ID = ? AND sa.SOURCE_ID = ? ";
        Query query = entityManager.createNativeQuery(sql, ShSubAccount.class);
        query.setParameter(1, fullCode);
        query.setParameter(2, departmentId);
        query.setParameter(3, sourceId);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
  
    public List<ShPlan> getPlanByFullCode(Integer enterpriseId, String fullCode) {
        String sql = "SELECT a.* FROM SH_PLAN a WHERE a.PLAN_ID in (SELECT o1.PLAN_ID FROM SH_PLAN_VIEW o1 JOIN SH_PLAN_CHART o2 ON (o1.PLAN_CHART_ID = o2.PLAN_CHART_ID) WHERE o1.FULL_CODE = ? AND o2.ENTERPRISE_ID = ?) ORDER BY a.TREE_LEFT";
        
        Query query = entityManager.createNativeQuery(sql, ShPlan.class);
        query.setParameter(1, fullCode);
        query.setParameter(2, enterpriseId);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
    public Integer getMaxByTable(String table, String primaryKey) {
        String sql = "SELECT MAX(o1." + primaryKey + ") FROM " + table + " o1";
        Query query = entityManager.createNativeQuery(sql);
        query.setFlushMode(FlushModeType.COMMIT);
        Integer maxId = null;
        try {
            maxId = (Integer)query.getSingleResult();
        } catch (ClassCastException e) {
            
        }
        
        return (maxId == null ? 1 : maxId);
    }
    
    public String getPrimaryKey(String table) {
        String sql = "SELECT NAME FROM SYSIBM.SYSCOLUMNS WHERE TBNAME = '" + table + "' AND KEYSEQ > 0 ORDER BY KEYSEQ ASC ";
        Query query = entityManager.createNativeQuery(sql);
        query.setFlushMode(FlushModeType.COMMIT);
        String primaryKey = null;
        try {
            primaryKey = (String) query.getSingleResult();
        } catch (Exception e) {
            
        }
        
        return primaryKey;
    }
    
    
    public String getPrimaryKeyCache(String table) {
        if(primaryKeyMap.isEmpty()){
    //        String sql = "SELECT NAME FROM SYSIBM.SYSCOLUMNS";// WHERE TBNAME = '" + table + "' AND KEYSEQ > 0 ORDER BY KEYSEQ ASC ";
            Query query = entityManager.createNamedQuery("Sqlprimarykeys.findAll", Sqlprimarykeys.class);
            query.setFlushMode(FlushModeType.COMMIT);
            String primaryKey = null;
            String tableName = null;
            try {
                List<Sqlprimarykeys> SqlprimarykeysList = query.getResultList();//query.getSingleResult();
                for (Sqlprimarykeys sqlprimarykeys : SqlprimarykeysList) {
                    tableName = sqlprimarykeys.getTableName();
                    primaryKey = sqlprimarykeys.getColumnName();
                    primaryKeyMap.put(tableName, primaryKey);
                }
            } catch (Exception e) {

            }
        }
        return primaryKeyMap.get(table);
    }
    
    
    
    public void testQuery() {
        String sql = "SELECT NAME FROM SYSIBM.SYSCOLUMNS";
        Query query = entityManager.createNativeQuery(sql);
        query.setMaxResults(1);
        query.getSingleResult();
    }
  
    public List testQuery(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}

