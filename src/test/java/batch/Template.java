package batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Template{

	private static final String url = "jdbc:mysql://127.0.0.1:3306/ecentre?"+ "useUnicode=true&characterEncoding=utf8"+ "&autoReconnect=true&failOverReadOnly=false";
	private static final String username = "root";
	private static final String password = "";
	
	private  static final String ZMXY_ORDER_NOTICE_SQL = "insert into zmxy_order_notice ("
			+"ORDER_NO,CARD_LOGO,IS_CONFIRMED,CONFIRMED_COUNT,MSG,CREATETIME,UPDATETIME"
			+",FIELD1,FIELD2,FIELD3,OPEN_ID,USER_ID) values("
			+"?,"  //订单号
			+"'080|080',"  //卡种
			+"'0',"   //0
			+"'0',"  //0
			+"NULL,"
			+"NULL,"  //创建时间
			+"NULL,"  //更新时间
			+"NULL,"
			+"NULL,"
			+"NULL,"
			+"NULL,"
			+"NULL"
			+")";
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(ZMXY_ORDER_NOTICE_SQL);
			long total = 61440;
			for(int i=1; i<total; i++){
				ps.setString(1,  UUID.randomUUID().toString());
			    ps.addBatch();
			    // 1w条记录插入一次
			    if (i % 10000 == 0){
			         ps.executeBatch();
			         conn.commit();
			         log.info("成功插入记录:{}",i);
			     }
			}
			// 最后插入不足1w条的数据
			ps.executeBatch();
			conn.commit();
			log.info("成功插入记录:{}",total);
		} catch (SQLException e) {
			log.error("数据操作异常",e);
		} finally{
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				log.error("数据资源关闭异常",e);
			}
		}
	}


}
