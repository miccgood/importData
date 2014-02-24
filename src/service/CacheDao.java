/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import Entity.Capital;
import Entity.ERP_AC.AcAccount;
import Entity.ERP_AC.AcCreditCardType;
import Entity.ERP_FI.FiFund;
import Entity.ERP_SH.ShBank;
import Entity.ERP_SH.ShBankBranch;
import Entity.ERP_SH.ShDepartment;
import Entity.ERP_SH.ShEnterprise;
import Entity.ERP_SH.ShFormType;
import Entity.ERP_SH.ShMemberType;
import Entity.ERP_SH.ShPlan;
import Entity.ERP_SH.ShSource;
import Entity.ERP_SH.ShTitle;
import Entity.ERP_SH.VShRegion;
import GUI.TestGUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
/**
 *
 * @author momo-pc
 */
public class CacheDao {
    private static final Map<String, ShDepartment> shDepartmentMap = new HashMap<String, ShDepartment>();
    private static final Map<String, ShSource> shSourceMap = new HashMap<String, ShSource>();
    private static final Map<String, AcAccount> acAccountMap = new HashMap<String, AcAccount>();
    private static final Map<Integer, Map<String, FiFund>> fiFundMap = new HashMap<Integer, Map<String, FiFund>>();
    
    private static final Map<String, ShPlan> shPlanMap = new HashMap<String, ShPlan>();
    
    
    private static final Map<String, ShTitle> shTitleMap = new HashMap<String, ShTitle>();
    private static final Map<String, VShRegion> vShRegionMap = new HashMap<String, VShRegion>();
    private static final Map<String, ShBank> shBankMap = new HashMap<String, ShBank>();
    private static final Map<String, AcCreditCardType> acCreditCardTypeMap = new HashMap<String, AcCreditCardType>();
    private static final Map<Integer, Map<String, ShBankBranch>> shBankBranchMap = new HashMap<Integer, Map<String, ShBankBranch>>();
    private static final Map<String, ShMemberType> shMemberTypeMap = new HashMap<String, ShMemberType>();
    
    
    public EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("PersistenceDB2");
    public EntityManager entityManager;// = emf.createEntityManager();
    public EntityTransaction tx;// = entityManager.getTransaction();
    
    private static DAO dao = null;
    public CacheDao(String host, String database, String username, String password){
           
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

    public CacheDao(String username, String password){
        this("192.168.8.10", "TRC_LPA", username, password);
    }
    
    public CacheDao(){
        this(TestGUI.getHost(), TestGUI.getDatabase(), TestGUI.getUsername(), TestGUI.getPassword());
    }
    
    public void initCapital(){
         initShSource();
         initAcAccount();
         initShDepartment();
         initShPlan();
         initFiFund();
    }
    public void init(){
        initShDepartment();
        initShTitle();
        initVShRegion();
        initShBank();
        initAcCreditCardType();
        initShBankBranch();
        initShMemberType();
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
//        entityManager.flush();
    }
    
    public ShFormType findShFormTypeByFormTypeCode(String formTypeCode) {
        Query query = entityManager.createNamedQuery("ShFormType.findByFormTypeCode", ShFormType.class);
        query.setParameter("formTypeCode", formTypeCode);
        List<ShFormType> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } 
        return null;
    }
    
    private void initShDepartment() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!shDepartmentMap.isEmpty()) return;
        
        
StringBuilder sql = new StringBuilder();
sql.append("SELECT o1.DEPARTMENT_ID, o2.FULL_CODE AS DEPARTMENT_CODE,    o1.DEPARTMENT_NAME, ");
sql.append("o1.DEPARTMENT_DESC, o1.DEPARTMENT_TYPE, o1.ALLOW_SELECT, o1.TREE_LEFT, o1.TREE_RIGHT, o1.TREE_LEVEL, ");
sql.append("o1.PARENT_ID,o1.DEPARTMENT_CHART_ID,o1.IS_LEAF,o1.IS_CANCEL, o1.CANCEL_DATE,o1.CANCEL_PER_ID,o1.IS_LOCK_UPDATE, o1.CREATE_TIME, ");
sql.append("o1.CREATE_USER_ID,o1.CREATE_PROG, o1.LAST_UPD_TIME,o1.LAST_UPD_USER_ID,o1.LAST_UPD_PROG,o1.LAST_UPD_VERSION,  ");
sql.append("o1.BUSINESS_UNIT_ID,o1.IS_SELF_PAY,o1.IS_SPECIALIST, o1.BUSINESS_UNIT_TYPE,o1.IS_FINANCE_CENTER ");
sql.append("FROM Sh_Department o1 ");
sql.append("LEFT JOIN V_SH_DEPARTMENT o2 ON (o1.DEPARTMENT_ID = o2.DEPARTMENT_ID)  ");
        Query query = entityManager.createNativeQuery(sql.toString(), ShDepartment.class);
        
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShDepartment> list = query.getResultList();
        
        for (ShDepartment shDepartment : list) {
            String code = shDepartment.getDepartmentCode();
            if(!shDepartmentMap.containsKey(code)){
                shDepartmentMap.put(code, shDepartment);
            }
        }
    }
    
    public List<ShSource> getSourceList() {
        
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT a.SOURCE_ID, b.FULL_CODE SOURCE_CODE,  ");
        sql.append("a.TREE_LEFT,a.TREE_RIGHT,a.TREE_LEVEL,a.IS_LEAF,");
        sql.append("a.OLD_CODE,a.OLD_NAME,a.OLD_CLASS_CODE,a.IS_INHERIT,");
        sql.append("a.IS_OBJECTIVE_DONATE,a.IS_PROPAGATE,a.IS_EXTERNAL,");
        sql.append("a.IS_CANCEL,a.CANCEL_DATE,a.CANCEL_PER_ID,a.IS_LOCK_UPDATE,");
        sql.append("a.CREATE_TIME,a.CREATE_USER_ID,a.CREATE_PROG,a.LAST_UPD_TIME,");
        sql.append("a.LAST_UPD_USER_ID,a.LAST_UPD_PROG,a.LAST_UPD_VERSION,");
        sql.append("a.BUSINESS_UNIT_ID,a.SOURCE_NAME,a.SOURCE_DESC,a.SOURCE_CHART_ID,a.parent_Id ");
        sql.append("FROM SH_SOURCE a ");
        sql.append("LEFT JOIN V_SH_SOURCE b ON (a.SOURCE_ID = b.SOURCE_ID) ");
        sql.append("WHERE a.SOURCE_ID in (");
        sql.append("  SELECT o1.SOURCE_ID ");
        sql.append("  FROM SH_SOURCE_VIEW o1 ");
        sql.append("  JOIN SH_SOURCE_CHART o2 ON (o1.SOURCE_CHART_ID = o2.SOURCE_CHART_ID) ");
        sql.append("  WHERE o1.IS_LEAF = 'Y') ");
        sql.append("ORDER BY a.TREE_LEFT");
        Query query = entityManager.createNativeQuery(sql.toString(), ShSource.class);
//        query.setParameter(1, fullCode);
//        query.setParameter(1, enterpriseId);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
    private void initShSource() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!CacheDao.shSourceMap.isEmpty()) return;
        List<ShSource> list = getSourceList();
        
        for (ShSource shSource : list) {
            String code = shSource.getSourceCode();
            if(!CacheDao.shSourceMap.containsKey(code)){
                CacheDao.shSourceMap.put(code, shSource);
            }
        }
    }
    
    public List<ShPlan> getPlanList() {
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT a.PLAN_ID,a.PLAN_CHART_ID,b.FULL_CODE PLAN_CODE,a.PLAN_NAME,a.PLAN_DESC, ");
        sql.append("a.TREE_LEFT,a.TREE_RIGHT,a.TREE_LEVEL,a.PARENT_ID,a.IS_LEAF,a.IS_CANCEL, ");
        sql.append("a.CANCEL_DATE,a.CANCEL_PER_ID,a.IS_LOCK_UPDATE,a.CREATE_TIME,a.CREATE_USER_ID, ");
        sql.append("a.CREATE_PROG,a.LAST_UPD_TIME,a.LAST_UPD_USER_ID,a.LAST_UPD_PROG,a.LAST_UPD_VERSION, ");
        sql.append("a.BUSINESS_UNIT_ID ");
        sql.append("FROM SH_PLAN a  ");
        sql.append("LEFT JOIN V_SH_PLAN b ON (a.PLAN_ID = b.PLAN_ID)  ");
        sql.append("WHERE a.PLAN_ID in ( ");
        sql.append("SELECT o1.PLAN_ID  ");
        sql.append("FROM SH_PLAN_VIEW o1  ");
        sql.append("JOIN SH_PLAN_CHART o2 ON (o1.PLAN_CHART_ID = o2.PLAN_CHART_ID)  ");
        sql.append(")  ");
        sql.append("ORDER BY a.TREE_LEFT ");
        
        
        Query query = entityManager.createNativeQuery(sql.toString(), ShPlan.class);
//        query.setParameter(1, fullCode);
//        query.setParameter(2, enterpriseId);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
    private void initShPlan() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!CacheDao.shPlanMap.isEmpty()) return;
        List<ShPlan> list = getPlanList();
        
        for (ShPlan shPlan : list) {
            String code = shPlan.getPlanCode();
            if(!CacheDao.shPlanMap.containsKey(code)){
                CacheDao.shPlanMap.put(code, shPlan);
            }
        }
    }
    
    public List<AcAccount> getAccountList() {
        
        String sql = "SELECT a.ACCOUNT_ID, a.CHART_ID , o1.FULL_CODE AS ACCOUNT_CODE, a.ACCOUNT_NAME, "
            + "a.ACCOUNT_DESC, a.TREE_LEFT, a.TREE_RIGHT, a.TREE_LEVEL, a.PARENT_ID, a.IS_LEAF,"
            + "a.IS_CANCEL, a.CANCEL_DATE, a.CANCEL_PER_ID, a.IS_LOCK_UPDATE, a.CREATE_TIME, a.CREATE_USER_ID,"
            + "a.CREATE_PROG  ,a.LAST_UPD_TIME  ,a.LAST_UPD_USER_ID  ,a.LAST_UPD_PROG  ,a.LAST_UPD_VERSION  ,a.BUSINESS_UNIT_ID,"
            + "a.IS_RCA_USE  ,a.IS_INSURE "
            + "FROM AC_ACCOUNT a "
            + "LEFT JOIN AC_ACCOUNT_VIEW o1 ON (o1.ACCOUNT_ID = a.ACCOUNT_ID)"
            + "WHERE a.ACCOUNT_ID in ("
              + "SELECT o1.ACCOUNT_ID FROM AC_ACCOUNT_VIEW o1 JOIN AC_ACCOUNT_CHART o2 ON (o1.CHART_ID = o2.CHART_ID)"
              + ") "
            + "ORDER BY a.TREE_LEFT";
        
        
        Query query = entityManager.createNativeQuery(sql, AcAccount.class);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
    private void initAcAccount() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!CacheDao.acAccountMap.isEmpty()) return;
        List<AcAccount> list = getAccountList();
        
        for (AcAccount acAccount : list) {
            String code = acAccount.getAccountCode();
            if(!CacheDao.acAccountMap.containsKey(code)){
                CacheDao.acAccountMap.put(code, acAccount);
            }
        }
    }
    
    
    public List<FiFund> getFundList() {
        
        String sql =  "SELECT f.* FROM Fi_Fund f ";
        
        Query query = entityManager.createNativeQuery(sql, FiFund.class);
        query.setFlushMode(FlushModeType.COMMIT);
        return query.getResultList();
    }
    
    private void initFiFund() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!CacheDao.fiFundMap.isEmpty()) return;
        List<FiFund> list = getFundList();
        
        for (FiFund fiFund : list) {
            String code = fiFund.getFundCode();
            Integer departmentId = fiFund.getDepartmentId();
            //ถ้ามี department แล้วให้ดึงออกมาแล้ว set FiFund
            if(CacheDao.fiFundMap.containsKey(departmentId)){
                Map<String, FiFund> fundMap = CacheDao.fiFundMap.get(departmentId);
                fundMap.put(code, fiFund);
            }else{
                //สร้าง Map ใหม่
                Map<String, FiFund> fundMap = new HashMap<>();
                fundMap.put(code, fiFund);
                
                //ยัดค่าลง Map หลัก
                CacheDao.fiFundMap.put(departmentId, fundMap);
            }
            
        }
    }
    
//    ----------------------------------------------    ///
    private void initShTitle() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!shTitleMap.isEmpty()) return;
        Query query = entityManager.createNamedQuery("ShTitle.findAll", ShTitle.class);
//        query.setParameter("titleName", titleName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShTitle> list = query.getResultList();
        
        for (ShTitle shTitle : list) {
            String titleName = shTitle.getTitleName();
            if(!shTitleMap.containsKey(titleName)){
                shTitleMap.put(titleName, shTitle);
            }
        }
    }
    
    private void initVShRegion() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!vShRegionMap.isEmpty()) return;
        Query query = entityManager.createNamedQuery("VShRegion.findAll", VShRegion.class);
//        query.setParameter("fullName", fullName);
        query.setFlushMode(FlushModeType.COMMIT);
        List<VShRegion> list = query.getResultList();

        for (VShRegion vShRegion : list) {
            String fullName = vShRegion.getFullName();
            if(!vShRegionMap.containsKey(fullName)){
                vShRegionMap.put(fullName, vShRegion);
            }
        }
    }
         
    
    private void initShBank() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!shBankMap.isEmpty()) return;
        Query query = entityManager.createNamedQuery("ShBank.findAll", ShBank.class);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShBank> list = query.getResultList();
        for (ShBank shBank : list) {
            String fullName = shBank.getBankName();
            if(!shBankMap.containsKey(fullName)){
                shBankMap.put(fullName, shBank);
            }
        }
    }
    
    private void initAcCreditCardType() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!acCreditCardTypeMap.isEmpty()) return;
        Query query = entityManager.createNamedQuery("AcCreditCardType.findAll", AcCreditCardType.class);
        query.setFlushMode(FlushModeType.COMMIT);
        List<AcCreditCardType> list = query.getResultList();
        for (AcCreditCardType acCreditCardType : list) {
            String fullName = acCreditCardType.getName();
            if(!acCreditCardTypeMap.containsKey(fullName)){
                acCreditCardTypeMap.put(fullName, acCreditCardType);
            }
        }
    }
    
    private void initShBankBranch() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!shBankBranchMap.isEmpty()) return;
        Query query = entityManager.createNamedQuery("ShBankBranch.findAll", ShBankBranch.class);
        query.setFlushMode(FlushModeType.COMMIT);
//        query.setParameter("bankBranchName", bankBranchName);
//        query.setParameter("bankId", bankId);
        List<ShBankBranch> list = query.getResultList();
        for (ShBankBranch shBankBranch : list) {
            Integer bankId = shBankBranch.getBankId().getBankId();
            String bankBranchName = shBankBranch.getBankBranchName();
            //ถ้ามีแล้ว
            Map<String, ShBankBranch> map ;
            if(shBankBranchMap.containsKey(bankId)){
                map = shBankBranchMap.get(bankId);
                //ถ้ายังไม่มีสาขา
                if(!map.containsKey(bankBranchName)){
                    map.put(bankBranchName, shBankBranch);
                }
            }else{
                //ถ้ายังไม่มี ให้สร้างใหม่
                map = new HashMap<>();
                map.put(bankBranchName, shBankBranch);
                shBankBranchMap.put(bankId, map);
            }
        }
    }
    
    
    private void initShMemberType() {
        //ถ้ามีข้อมุลให้ไปคนหา
        if(!shMemberTypeMap.isEmpty()) return;
        Query query = entityManager.createNamedQuery("ShMemberType.findAll", ShMemberType.class);
        query.setFlushMode(FlushModeType.COMMIT);
        List<ShMemberType> list = query.getResultList();
        for (ShMemberType memberType : list) {
            String fullName = memberType.getMemberTypeName();
            if(!shMemberTypeMap.containsKey(fullName)){
                shMemberTypeMap.put(fullName, memberType);
            }
        }
    }
    
    public ShMemberType findShMemberTypeByNameCache(String name) {
        return shMemberTypeMap.get(name);
    }
    
    public ShBankBranch findShBankBranchByBankBranchNameAndBankIdCache(String bankBranchName, Integer bankId) {
         Map<String, ShBankBranch> map = shBankBranchMap.get(bankId);

         return (map != null ? map.get(bankBranchName) : null );
    }
    
    
    public AcCreditCardType findAcCreditCardTypeByNameCache(String name) {
       return acCreditCardTypeMap.get(name);
    }
    
    public ShBank findShBankByBankNameCache(String bankName) {
        return shBankMap.get(bankName);
    }
    
    public VShRegion findRegionByFullNameCache(String fullName) {
        return vShRegionMap.get(fullName);
    }
            
    public ShTitle findTitleByTitleNameCache (String titleName){
        return shTitleMap.get(titleName);
    }
    
    public ShDepartment findDepartmentByFullCodeCache (String code){
        return shDepartmentMap.get(code);
    }

    
    public Integer getSourceIdByFullCodeCache(String SourceFullCode) {
        try {
            return CacheDao.shSourceMap.get(SourceFullCode).getSourceId();
        } catch (NullPointerException e) {
            return null;
        }
    }
  
    public Integer getAccountIdByFullCodeCache(String accountFullCode) {
        try {
            return CacheDao.acAccountMap.get(accountFullCode).getAccountId();
        } catch (NullPointerException e) {
            return null;
        }
    }
    
     public Integer findDepartIdmentByFullCodeCache (String code){
        try {
            return CacheDao.shDepartmentMap.get(code).getDepartmentId();
        } catch (NullPointerException e) {
            return null;
        }
    }
     
    public Integer findPlanIdmentByFullCodeCache (String code){
        try {
            return CacheDao.shPlanMap.get(code).getPlanId();
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    public FiFund findFundByFundCode(String fundCode, Integer departmentId) {
        try {
            return CacheDao.fiFundMap.get(departmentId).get(fundCode);
        } catch (NullPointerException e) {
            return null;
        }
    }
}

