package com.digihealth.doc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digihealth.basedata.service.BaseDataService;
import com.digihealth.doc.entity.DocAnaesPreDiscussRecord;
import com.digihealth.doc.sql.DocAnaesPreDiscussRecordSql;
import com.digihealth.utils.ConnectionManager;

public class DocAnaesPreDiscussRecordDao {

	public void insert(DocAnaesPreDiscussRecord entity) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getAISDEVConnection();
			pstmt = conn.prepareStatement(DocAnaesPreDiscussRecordSql.insert);
			pstmt.setString(1, entity.getPreDiscussId());
			pstmt.setString(2, entity.getRegOptId());
			pstmt.setString(3, entity.getProcessState());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ִ��insert�������쳣��" + e.getMessage());
		} finally {
			try {
				ConnectionManager.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteByRegOptId(String name) {
		String beid = BaseDataService.getCurBasBusEntity().getBeid();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getAISDEVConnection();
			pstmt = conn.prepareStatement(DocAnaesPreDiscussRecordSql.deleteByRegOptId);
			pstmt.setString(1, beid);
			pstmt.setString(2, "%" + name + "%");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("----------DocAnaesPreDiscussRecordDao-deleteByRegOptId----------" + e.getMessage());
		} finally {
			try {
				ConnectionManager.close(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
