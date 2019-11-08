package com.xkit.ssm.dao;

import java.util.List;

import com.xkit.ssm.entity.Easybuy_address;

public interface Easybuy_addressDAO {
	public int addAddress(Easybuy_address easy);
	public List<Easybuy_address> selectadd();
}
