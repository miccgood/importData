/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cache;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author tanet-t
 */
public class CacheDao {
//                       Map< table, Map<column, Map<criteria, List<Object>>>>
    private static final Map<String, Map<String, Map<String, List<Object>>>> mapDao = new HashMap<>();
    
    public static final Object getSingleValue(String tableName, String columnName, String criteria){
        try {
            return getValueList(tableName, columnName, criteria).get(0);
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    public static final List<Object> getValueList(String tableName, String columnName, String criteria){
        try {
            Map<String, Map<String, List<Object>>> table = mapDao.get(tableName);
            Map<String, List<Object>> column = table.get(columnName);
            return column.get(criteria);
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    
    public static final void setValue(String tableName, String columnName, String criteriaName, List<Object> value){
        Map<String, Map<String, List<Object>>> table = mapDao.get(tableName);
        if(table != null){
            Map<String, List<Object>> column = table.get(columnName);
            if(column != null){
                List<Object> valueList = column.get(criteriaName);
                if(valueList != null){
                    valueList.addAll(value);
                }else{
                    column.put(columnName, value);
                }
            }else{
                mapDao.put(tableName, createColumn(columnName, criteriaName, value));
            }
        }else{
            createTable(tableName, columnName, criteriaName, value);
        }
    }
    
    private static void createTable(String tableName, String columnName, String criteriaName, List<Object> value){
        mapDao.put(tableName, createColumn(columnName, criteriaName, value));
    }
    
    private static Map<String, Map<String, List<Object>>> createColumn(String columnName, String criteriaName, List<Object> value){
        Map<String, Map<String, List<Object>>> column = new HashMap<>();
        column.put(columnName, createCriteria(criteriaName, value));
        return column;
    }
    
    private static Map<String, List<Object>> createCriteria(String criteriaName, List<Object> value){
        Map<String, List<Object>> criteria = new HashMap<>();
        criteria.put(criteriaName, value);
        return criteria;
    }
}
