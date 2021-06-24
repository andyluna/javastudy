package com.liyi.study.jdbc.day0428.test;

import com.liyi.study.jdbc.day0427.bean.Customer;
import com.liyi.study.jdbc.day0427.util.JDBCUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 10:47  星期三
 */
public class BlobTest {

    //向数据表customer插入Blob类型的数据
    @Test
    public void testInsert() throws Exception{
        Connection con= JDBCUtils.getConnection();
        String sql="insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setObject(1,"大妹");
        ps.setObject(2,"damei@QQ.com");
        ps.setObject(3,"2020-01-03");

        File file;
        FileInputStream is=new FileInputStream(new File("穿越火线14.png"));
        ps.setBlob(4,is);

        ps.execute();

        JDBCUtils.closeResource(con,ps);
    }


    //查询数据表customer中的Blob字段
    @Test
    public void testQuery(){
        Connection con= null;
        PreparedStatement ps= null;
        InputStream is= null;
        FileOutputStream fos= null;
        ResultSet rs= null;
        try {
            con = JDBCUtils.getConnection();
            String sql="select id,name,email,birth,photo from customers where id=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1,19);




            rs = ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);
                Customer cust=new Customer(id,name,email,birth);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以为文件的方式保存在本地
                Blob photo=rs.getBlob("photo");
                is = photo.getBinaryStream();

                fos=new FileOutputStream("穿越火线1.png");

                byte[] buffer=new byte[1024];
                int len;
                while ((len=is.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }  finally {
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        JDBCUtils.closeResource(con,ps,rs);
    }


}
