package site.haiyang.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UtilHive {
    
    private static Logger logger = LoggerFactory.getLogger(UtilHive.class);
    
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    
    public static Connection connection; 
    
    private static String urlStr = "jdbc:hive2://10.27.110.139:10000/default";
    
    private static String username = "hive";
    
    private static String password = "hive";
    
    public static Connection getConnectForHive() throws ClassNotFoundException, SQLException{
        
        logger.info("=======================get connection begin=================================");
        
        Class.forName(driverName);
        
        Connection connection = DriverManager.getConnection(urlStr, username, password);
        
        return connection;
    }
    
    public static void closeAll(Connection conn, Statement state, ResultSet rs){
        
        logger.info("=======================close the resource=================================");
            
        try {
            if(rs != null){
                rs.close();
            }
            if(state != null){
                state.close();
            }
            if(conn != null){
                conn.close();
            }
          } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args) throws Exception{

        logger.info("=======================test hive jbbc start=================================");
        
        Class.forName(driverName);
        
        Connection con = DriverManager.getConnection(urlStr, username, password);
        
        Statement stmt = con.createStatement();
        
        
        String sql = "select brandId,proviceType,codeType,commodityId,count(1) as total from t_atv_drawprize_log  "
                 + "where substr(drawTime,1,10) = '2016-12-07' and state='3' "
                 + "group by brandId,proviceType,codeType,commodityId";
    //  String sql = "select ";
//      String sql = "show tables";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1) + "\t" );
        }
        UtilHive.closeAll(con, stmt, rs);
//      
    }
    
    public static List<HashMap<String, Object>> getObjects(String sql) throws Exception{
            Connection con = null;
            Statement stmt =  null;
            ResultSet rs = null;
           try {
                   Class.forName(driverName);
                   con = DriverManager.getConnection(urlStr, username, password);
                  stmt = con.createStatement();
                   rs = stmt.executeQuery(sql);
                   if (rs == null){
                       return Collections.EMPTY_LIST;   
                   }else{
                       ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
                       int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
                       List<HashMap<String, Object>> list = new ArrayList();   
                       HashMap<String, Object> rowData = new HashMap();   
                       while (rs.next()) {   
                        rowData = new HashMap(columnCount);   
                        for (int i = 1; i <= columnCount; i++) {   
                                rowData.put(md.getColumnName(i), rs.getObject(i));   
                        }   
                        list.add(rowData);   
                       }   
                       return list;  
                   }
        } catch (Exception e) {
            UtilHive.closeAll(con, stmt, rs);
        }
        return null;
    }
}
