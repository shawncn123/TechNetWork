//package com.shenxf.ssh.service;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
//
//public class ImportDataFromCsv {
//
//	String filePath = "D:/aa2.csv";
//    
//	File file = new File(filePath);
//
//    if(file.exists()){
//        int i = 0;  
//        String strLine = null;  
//        Statement ps = null;  
//        Connection conn = null;  
//        String sql = null;  
//        try{  
//            conn = HibernateSessionUtil.getConnection();
//            conn.setAutoCommit(false);  
//            ps = conn.createStatement();  
//            BufferedReader bufferedreader = new BufferedReader(new FileReader(filePath));  
//            while ((strLine = bufferedreader.readLine()) != null) {  
//                i++;  
//                String [] values = strLine.split(",");//逗号隔开的各个列  
//                String cell0 = values[0];  
//                String cell1 = values[1];  
//                String cell2 = values[2];  
//                String cell3 = values[3];  
//                String cell4 = values[4];  
//                String cell5 = values[5];  
//                String cell6 = values[6];  
//                String cell7 = values[7];     
//                sql = String.format("INSERT INTO TBLDATA2(CELL0,CELL1,CELL2,CELL3,CELL4,CELL5,CELL6,CELL7,TID) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s',SEQ_TBLID.NEXTVAL)",  
//                        cell0,cell1,cell2,cell3,cell4,cell5,cell6,cell7);  
//                ps.executeUpdate(sql);  
//                if(i%500 == 0){  
//                    //500条记录提交一次  
//                    conn.commit();  
//                    System.out.println("已成功提交"+i+"行!");  
//                }  
//            }  
//            if(i%500 != 0){  
//                //不够500条的再提交一次（其实不用判断，直接提交就可以，不会重复提交的）  
//                conn.commit();  
//                System.out.println("已成功提交"+i+"行!");  
//            }  
//              
//        }catch(Exception ex){  
//            System.out.println("导出第"+(i+1)+"条时出错，数据是" + strLine);  
//            System.out.println("出错的sql语句是：" + sql);  
//            System.out.println("错误信息：");  
//            ex.printStackTrace();  
//            try {  
//                if (conn != null) {  
//                    conn.rollback();  
//                }  
//            } catch (Exception e) {  
//                e.printStackTrace();  
//            }  
//        } finally{  
//            try {  
//                if (ps != null) {  
//                    ps.close();  
//                }  
//            } catch (Exception ex) {  
//                ex.printStackTrace();  
//            }  
//            try {  
//                if (conn != null){  
//                    conn.close();  
//                }  
//            } catch (Exception ex) {  
//                ex.printStackTrace();  
//            }  
//        }  
//    }
//	
//}
