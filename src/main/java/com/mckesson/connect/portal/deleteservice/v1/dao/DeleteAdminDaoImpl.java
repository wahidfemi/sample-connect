package com.mckesson.connect.portal.deleteservice.v1.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteAdminDaoImpl implements IDeleteAdminDao {

    private static final Logger log = LoggerFactory.getLogger(DeleteAdminDaoImpl.class);
    /*
    private static String userAccountsQuery = "select distinct ACCESS_ROLE_CD, ACCESS_ROLE_DSCR, LVL1_VALU, LVL2_VALU, LVL3_VALU,LVL4_VALU, LVL5_VALU, MANL_UPDT_IND, KEY1, KEY2 ,TRACEABILITY_FLAG" 
								    	 + " from ( select ROL.ACCESS_ROLE_CD, ACCESS_ROLE_DSCR, LVL1_VALU, LVL2_VALU, LVL3_VALU, LVL4_VALU, LVL5_VALU, MANL_UPDT_IND," 
								    	 + " NVL(DECODE(RTRIM(ROL.ACCESS_ROLE_CD),'SLS',LOC.LOC_DSCR, 'CHN',GRP.CUST_GRP_NAM, 'IND',CUS.CUST_ACCT_NAM," 
								    	 + " 'CID',CUS.CUST_ACCT_NAM, 'NRN',NATDSCR.NATL_ACCT_DSCR, 'HSP',NAT.NATL_GRP_NAM, 'SEC',SYS.SYS_NAM, ' '), ' ') KEY1," 
								    	 + " NVL(DECODE(RTRIM(ROL.ACCESS_ROLE_CD),'HSP', DECODE(LVL2_VALU, null, null, NATSUB.NATL_SUB_GRP_NAM), ' ') , ' ') KEY2," 
								    	 + " ACC.SYS_ID ,TRACEABILITY_FLAG" 
								    	 + " FROM S_IW_USER_ACCESS ACC, S_IW_ACCESS_ROLE ROL, S_IW_LOC LOC, S_IW_CUST_GRP GRP,"
								    	 + " S_IW_CUST_ACCT CUS, S_IW_SYS SYS, S_NATL_GRP NAT, S_NATL_SUB_GRP NATSUB,"
								    	 + " (Select distinct natl_acct_id, NATL_ACCT_DSCR From s_iw_cust_acct) NATDSCR WHERE UPPER(RTRIM(ACC.USER_ID)) = UPPER(?)"
								    	 + " AND RTRIM(ROL.ACCESS_ROLE_CD) = RTRIM(ACC.ACCESS_ROLE_CD) AND LVL1_VALU = LOC.LOC_ID (+) AND LVL1_VALU = GRP.CUST_GRP_CD (+)"
								    	 + " and LVL1_VALU = CUS.CUST_ACCT_ID (+) and LVL1_VALU = SYS.SYS_ID (+) and LVL1_VALU = NAT.NATL_GRP_CD (+) and" 
								    	 + " LVL2_VALU = NATSUB.NATL_SUB_GRP_CD (+) and (LVL1_VALU = NATSUB.NATL_GRP_CD (+) and LVL2_VALU = NATSUB.NATL_SUB_GRP_CD (+))" 
								    	 + " and LVL1_VALU = NATDSCR.NATL_ACCT_ID (+) order by ROL.ACCESS_ROLE_CD, LVL1_VALU, LVL2_VALU" 
								    	 + " )" 
								    	 + " where SYS_ID='STK2' and ACCESS_ROLE_CD = 'CID'";
    
    private static String userGroupsQuery = "select distinct ACCESS_ROLE_CD, ACCESS_ROLE_DSCR, LVL1_VALU, LVL2_VALU, LVL3_VALU,LVL4_VALU, LVL5_VALU, MANL_UPDT_IND, KEY1, KEY2 ,TRACEABILITY_FLAG" 
	    	 + " from ( select ROL.ACCESS_ROLE_CD, ACCESS_ROLE_DSCR, LVL1_VALU, LVL2_VALU, LVL3_VALU, LVL4_VALU, LVL5_VALU, MANL_UPDT_IND," 
	    	 + " NVL(DECODE(RTRIM(ROL.ACCESS_ROLE_CD),'SLS',LOC.LOC_DSCR, 'CHN',GRP.CUST_GRP_NAM, 'IND',CUS.CUST_ACCT_NAM," 
	    	 + " 'CID',CUS.CUST_ACCT_NAM, 'NRN',NATDSCR.NATL_ACCT_DSCR, 'HSP',NAT.NATL_GRP_NAM, 'SEC',SYS.SYS_NAM, ' '), ' ') KEY1," 
	    	 + " NVL(DECODE(RTRIM(ROL.ACCESS_ROLE_CD),'HSP', DECODE(LVL2_VALU, null, null, NATSUB.NATL_SUB_GRP_NAM), ' ') , ' ') KEY2," 
	    	 + " ACC.SYS_ID ,TRACEABILITY_FLAG" 
	    	 + " FROM S_IW_USER_ACCESS ACC, S_IW_ACCESS_ROLE ROL, S_IW_LOC LOC, S_IW_CUST_GRP GRP,"
	    	 + " S_IW_CUST_ACCT CUS, S_IW_SYS SYS, S_NATL_GRP NAT, S_NATL_SUB_GRP NATSUB,"
	    	 + " (Select distinct natl_acct_id, NATL_ACCT_DSCR From s_iw_cust_acct) NATDSCR WHERE UPPER(RTRIM(ACC.USER_ID)) = UPPER(?)"
	    	 + " AND RTRIM(ROL.ACCESS_ROLE_CD) = RTRIM(ACC.ACCESS_ROLE_CD) AND LVL1_VALU = LOC.LOC_ID (+) AND LVL1_VALU = GRP.CUST_GRP_CD (+)"
	    	 + " and LVL1_VALU = CUS.CUST_ACCT_ID (+) and LVL1_VALU = SYS.SYS_ID (+) and LVL1_VALU = NAT.NATL_GRP_CD (+) and" 
	    	 + " LVL2_VALU = NATSUB.NATL_SUB_GRP_CD (+) and (LVL1_VALU = NATSUB.NATL_GRP_CD (+) and LVL2_VALU = NATSUB.NATL_SUB_GRP_CD (+))" 
	    	 + " and LVL1_VALU = NATDSCR.NATL_ACCT_ID (+) order by ROL.ACCESS_ROLE_CD, LVL1_VALU, LVL2_VALU" 
	    	 + " )" 
	    	 + " where SYS_ID='STK2' and ACCESS_ROLE_CD != 'CID'";
    
    */
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public int deleteAccountsFromLegacyOrd(List<String> accounts) {
		// TODO Auto-generated method stub
		return 0;
	}

}
