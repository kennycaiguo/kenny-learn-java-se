package mavenMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlDemoMaven {
      public void ShowData() {
    	  String url = "jdbc:mysql://localhost:3306/regusers?serverTimezone=UTC  "; //���ݿ�����
    	  String name = "com.mysql.cj.jdbc.Driver";   //��������
    	  String user = "root";  //�û���
    	  String password = "root"; //����
          String sql="select * from users";//��ѯ���
    	  
    	  Connection conn = null;
    	  PreparedStatement pst = null;
    	  try
  		{
  			Class.forName(name);// ָ����������
  			conn = DriverManager.getConnection(url, user, password);// ��ȡ����
  			pst = conn.prepareStatement(sql);// ׼��ִ�����
  			 //Statement statement = conn.createStatement();
  			ResultSet rs = pst.executeQuery();
  			while(rs.next()) {//��ȡ����
  				System.out.println("��ţ�"+rs.getString(1));
  				System.out.println("������"+rs.getString(2));
  				System.out.println("�Ա�"+rs.getString(3));
  				System.out.println("���գ�"+rs.getString(4));
  				System.out.println("�ֻ���"+rs.getString(5));
  				System.out.println("���䣺"+rs.getString(6));
  				System.out.println("QQ��"+rs.getString(7));
  				
  			}
  			rs.close();
  			//�޸�
  			String sql2="UPDATE users set name='LILI' ,gender='female'  WHERE name='MARY'";
  			pst = conn.prepareStatement(sql2);// ׼��ִ�����
  			 pst.executeUpdate();
            //����
//  			 sql2="INSERT INTO users VALUES('003','Tom','male','25','13532619000','tracy@pussy.net','222333')";
//  			pst = conn.prepareStatement(sql2);
//  			pst.executeUpdate();
  			//ɾ��
//  			sql2="DELETE FROM users WHERE name='kk'";
//  			pst = conn.prepareStatement(sql2);
//  			pst.executeUpdate();
  			 conn.close();
  		} catch (Exception e)
  		{
  			e.printStackTrace();
  			
  		}
      }
}
