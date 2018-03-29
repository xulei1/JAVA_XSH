package com.ldyp.dao;

import java.util.List;

import com.ldyp.entity.Usr;

public interface UsrDao {
	public void addUsr(Usr usr);
	public void delUsr(Usr usr);
	public void UpdateUsr(Usr usr);
	public List<Usr> list();
}
