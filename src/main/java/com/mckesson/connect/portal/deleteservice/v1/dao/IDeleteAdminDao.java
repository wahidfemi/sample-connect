package com.mckesson.connect.portal.deleteservice.v1.dao;

import java.util.List;

public interface IDeleteAdminDao {
    
	public int deleteAccountsFromLegacyOrd(List<String> accounts);

}
