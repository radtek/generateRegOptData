package com.digihealth.doc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.digihealth.basedata.service.BaseDataService;
import com.digihealth.doc.sql.DocAccedeInformedSql;
import com.digihealth.utils.ConnectionManager;

public class DocAccedeInformedDao {

	public static void deleteByRegOptId(String name) {
		String beid = BaseDataService.getCurBasBusEntity().getBeid();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getAISDEVConnection();
			pstmt = conn.prepareStatement(DocAccedeInformedSql.deleteByRegOptId);
			pstmt.setString(1, beid);
			pstmt.setString(2, "%" + name + "%");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("----------DocAccedeInformedDao-deleteByRegOptId----------" + e.getMessage());
		} finally {
			try {
				ConnectionManager.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
