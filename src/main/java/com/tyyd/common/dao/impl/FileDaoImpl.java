package com.tyyd.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.FileDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;

@Repository
public class FileDaoImpl extends BaseDaoImpl implements FileDao {

	@Override
	public String getTableName() {
		return "BO_FILE";
	}

}
