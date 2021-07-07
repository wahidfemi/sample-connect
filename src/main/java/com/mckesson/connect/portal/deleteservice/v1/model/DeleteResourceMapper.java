package com.mckesson.connect.portal.deleteservice.v1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeleteResourceMapper implements RowMapper<DeleteResource>{

	public DeleteResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeleteResource userAccount = new DeleteResource();
		/*
		 * userAccount.setPlatformId(ApplicationConstants.PLATFORM_ID);
		 * userAccount.setAccountId(rs.getString("LVL1_VALU"));
		 */
		return userAccount;
	}
}
